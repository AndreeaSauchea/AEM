package com.aem.community.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables= Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageAndreeaModel {

    public static final String CONTENT_DAM_AEM_62_APP_SAUCHEA_ANDREEA_JPG = "/content/dam/AEM62App/Sauchea Andreea.jpg";

    @Inject
    private SlingSettingsService settings;

    @Inject
    @Named("sling:resourceType")
    protected String resourceType;
    @Inject
    private String fileReference;

   public String getImage() {
        return StringUtils.defaultIfBlank(fileReference, CONTENT_DAM_AEM_62_APP_SAUCHEA_ANDREEA_JPG);
    }

}
