package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscussionIncluded {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("attributes")
    @Expose
    private DiscussionIncludedAttributes attributes;
//    @SerializedName("relationships")
//    @Expose
//    private DiscussionIncludedRelationships relationships;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DiscussionIncludedAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(DiscussionIncludedAttributes attributes) {
        this.attributes = attributes;
    }

//    public DiscussionIncludedRelationships getRelationships() {
//        return relationships;
//    }
//
//    public void setRelationships(DiscussionIncludedRelationships relationships) {
//        this.relationships = relationships;
//    }

}