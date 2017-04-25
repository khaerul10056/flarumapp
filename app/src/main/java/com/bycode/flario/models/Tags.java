package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by michal on 25.04.2017.
 */

public class Tags {
    @SerializedName("data")
    @Expose
    private List<TagsDatum> data = null;

    public List<TagsDatum> getData() {
        return data;
    }

    public void setData(List<TagsDatum> data) {
        this.data = data;
    }
}
