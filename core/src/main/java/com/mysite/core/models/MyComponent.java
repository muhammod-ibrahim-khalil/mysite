package com.mysite.core.models;

import com.adobe.cq.export.json.ComponentExporter;

public interface MyComponent extends ComponentExporter {
    public String getMessage();
}
