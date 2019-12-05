package com.aem.community.core.models;

import javax.inject.Named;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables= Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DividerModel {
    @Inject
    protected String color;

    public String getColor() {
        return color;
    }
}
