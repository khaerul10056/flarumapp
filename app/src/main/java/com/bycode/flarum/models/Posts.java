package com.bycode.flarum.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michal on 19.04.2017.
 */



public class Posts {

    @SerializedName("data")
    @Expose
    private ArrayList<Post> data;
    @SerializedName("included")
    @Expose
    private List included = null;

    public ArrayList<Post> getData() {
        return data;
    }

    public void setData(ArrayList<Post> data) {
        this.data = data;
    }

    public List getIncluded() {
        return included;
    }

    public void setIncluded(List included) {
        this.included = included;
    }

}

