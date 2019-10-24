package com.brs.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer
{
   public void onStartup(ServletContext servletContext) throws ServletException {
	// TODO Auto-generated method stub
	   System.out.println("in here..");
	    XmlWebApplicationContext appContext = new XmlWebApplicationContext();
	    appContext.setConfigLocation("/WEB-INF/config/dispatcher-servlet.xml");

	    ServletRegistration.Dynamic registration = servletContext
	                .addServlet("rootDispatcher", new DispatcherServlet(appContext));
	    registration.setLoadOnStartup(1);
	    registration.addMapping("/spring-mvc/*");
}
}
