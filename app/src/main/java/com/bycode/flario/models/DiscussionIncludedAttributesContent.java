package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by michal on 25.04.2017.
 */

public class DiscussionIncludedAttributesContent {
    @SerializedName("sticky")
    @Expose
    private Boolean sticky;
    @SerializedName("locked")
    @Expose
    private Boolean locked;

    public Boolean getSticky() {
        return sticky;
    }

    public void setSticky(Boolean sticky) {
        this.sticky = sticky;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
