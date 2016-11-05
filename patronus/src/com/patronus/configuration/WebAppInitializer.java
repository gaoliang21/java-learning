package com.patronus.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	WebApplicationContext rootContext = createRootContext(servletContext);
    	createSpringMvcContext(servletContext, rootContext);
    }
    
    private WebApplicationContext createRootContext(ServletContext servletContext) {
	    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	    rootContext.setConfigLocation("com.patronus.configuration.SpringConfig");
	
	    servletContext.addListener(new ContextLoaderListener(rootContext));
	    servletContext.setInitParameter("defaultHtmlEscape", "true");
	
	    return rootContext;
	}

    private void createSpringMvcContext(ServletContext servletContext, WebApplicationContext rootContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setParent(rootContext);
        context.setConfigLocation("com.patronus.configuration.SpringConfig");
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.do");
    }

}