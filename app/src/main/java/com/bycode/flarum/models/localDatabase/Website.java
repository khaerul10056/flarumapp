package com.bycode.flarum.models.localDatabase;

import com.orm.SugarRecord;

/**
 * Created by michal on 20.04.2017.
 */


public class Website extends SugarRecord {
    private String address;
    private String title;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
