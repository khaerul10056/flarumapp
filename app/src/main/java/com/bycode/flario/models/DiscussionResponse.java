package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by michal on 25.04.2017.
 */

public class DiscussionResponse {
    @SerializedName("data")
    @Expose
    private Discussion data;
    @SerializedName("included")
    @Expose
    private List<DiscussionIncluded> included = null;

    public Discussion getData() {
        return data;
    }

    public void setData(Discussion data) {
        this.data = data;
    }

    public List<DiscussionIncluded> getIncluded() {
        return included;
    }

    public void setIncluded(List<DiscussionIncluded> included) {
        this.included = included;
    }


}
