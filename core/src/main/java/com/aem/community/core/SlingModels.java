package com.aem.community.core;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;

@SlingServlet(paths="/bin/slingmodel2", methods="GET")
public class SlingModels {
    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Reference
    ResourceResolverFactory resourceResolverFactory;
    ResourceResolver resourceResolver;
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException,IOException{
        logger.info("inside sling model test servlet");
        response.setContentType("text/html");
        try {
            resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
            Resource resource = resourceResolver.getResource("/content/testsling/slingmodel");
            ValueMap valueMap=resource.adaptTo(ValueMap.class);

            response.getWriter().write("la la la Output from ValueMap is First Name: "+valueMap.get("firstName").toString()+" Last Name: "+valueMap.get("lastName").toString()+" Technology: "+valueMap.get("technology").toString()+"");

            UserInfo userInfo = resource.adaptTo(UserInfo.class);
            response.getWriter().write(" and Output from Sling Model is First Name: "+userInfo.getFirstName()+" Last Name: "+userInfo.getLastName()+" Technology: "+userInfo.getTechnology());

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        finally{
            if(resourceResolver.isLive())
                resourceResolver.close();
        }


    }
}
