package com.aem.community.core.models;

import javax.inject.Named;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.settings.SlingSettingsService;

@Model(adaptables=Resource.class)
public class DescribeYourselfModel {

    @Inject
    private SlingSettingsService settings;

    @Inject
    @Named("sling:resourceType")
    protected String resourceType;

    private String message;

    @PostConstruct
    protected void init() {
        message = "\tMy name is Andreea.\n";
        message += "\tI am an AEM developer in training.\n";
        message += "\tI have no idea what I am doing right now.\n";
    }

    public String getMessage() {
        return message;
    }
}
