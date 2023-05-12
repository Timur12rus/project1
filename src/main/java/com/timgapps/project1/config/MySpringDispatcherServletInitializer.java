package com.timgapps.project1.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
