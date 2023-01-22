package com.mysite.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.mysite.core.models.MyComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { MyComponent.class,
        ComponentExporter.class }, resourceType = MyComponentImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MyComponentImpl implements MyComponent {
    static final String RESOURCE_TYPE = "mysite/components/mycomponent";

    @ValueMapValue
    private String message;

    @Override
    public String getMessage() {
        return StringUtils.isNotBlank(message) ? message.toUpperCase() : "";
    }

    @Override
    public String getExportedType() {
        return MyComponentImpl.RESOURCE_TYPE;
    }
}
