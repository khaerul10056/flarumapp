package com.bycode.flarum.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michal on 22.04.2017.
 */

public class WebsiteInfoResponse {
    private WebsiteInfo data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public WebsiteInfo getData() {
        return data;
    }

    public void setData(WebsiteInfo data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
