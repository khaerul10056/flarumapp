package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michal on 19.04.2017.
 */



public class DiscussionsResponse {

    @SerializedName("data")
    @Expose
    private ArrayList<Discussion> data;
    @SerializedName("included")
    @Expose
    private List included = null;

    public ArrayList<Discussion> getData() {
        return data;
    }

    public void setData(ArrayList<Discussion> data) {
        this.data = data;
    }

    public List getIncluded() {
        return included;
    }

    public void setIncluded(List included) {
        this.included = included;
    }

}

