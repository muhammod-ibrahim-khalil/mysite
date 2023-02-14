package com.mysite.core.servlets;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.resource.Resource;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.SimpleCredentials;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Demo Servlet",
//                ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES + "=etc/mycomponent/message",
                ServletResolverConstants.SLING_SERVLET_METHODS + "=[" + HttpConstants.METHOD_GET + "]",
                ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/public/myservlet",
                ServletResolverConstants.SLING_SERVLET_EXTENSIONS + "=json",
                ServletResolverConstants.SLING_SERVLET_SELECTORS + "=s1",
                "sling.auth.requirements=" + "-/bin/public/myservlet"
        })
public class MyServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
//        Resource resource = request.getResource();
//        ModifiableValueMap valueMap = resource.adaptTo(ModifiableValueMap.class);

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource("/content/mysite/us/en");
        String pageTitle = resource.getValueMap().get("pageTitle", String.class);

        response.setContentType("text/plain");
        response.getWriter().write(pageTitle.toString());

        /*RequestParameter name = request.getRequestParameter("name");
        RequestParameter value = request.getRequestParameter("value");
        response.setContentType("text/plain");
        if(name!= null && value != null){
            response.getWriter().write("test message"+ name.toString()+ " " +value.toString());
//            valueMap.put("message", name.toString());
//            resource.getResourceResolver().commit();
        }*/
    }

}
