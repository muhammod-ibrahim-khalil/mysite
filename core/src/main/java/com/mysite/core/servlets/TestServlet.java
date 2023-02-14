package com.mysite.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Test Servlet",
        ServletResolverConstants.SLING_SERVLET_METHODS + "=[" + HttpConstants.METHOD_GET + "]",
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/public/test",
        ServletResolverConstants.SLING_SERVLET_EXTENSIONS + "=json",
        "sling.auth.requirements=" + "-/bin/public/test"
})
public class TestServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.getWriter().write("Test Message");
    }
}
