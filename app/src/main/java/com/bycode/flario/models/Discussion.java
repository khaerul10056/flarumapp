package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by michal on 19.04.2017.
 */

public class Discussion {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("attributes")
    @Expose
    private DiscussionAttributes discussionAttributes;

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

    public DiscussionAttributes getDiscussionAttributes() {
        return discussionAttributes;
    }

    public void setDiscussionAttributes(DiscussionAttributes discussionAttributes) {
        this.discussionAttributes = discussionAttributes;
    }

}
