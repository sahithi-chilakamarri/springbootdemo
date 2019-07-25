package com.stackroute.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configurtion class
@Configuration
public class WebConfiguration {
    //Creates bean for the servletregistration
    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        //Mapping with console
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
