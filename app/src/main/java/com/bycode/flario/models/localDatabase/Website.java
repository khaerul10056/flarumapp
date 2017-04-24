package com.bycode.flario.models.localDatabase;

import com.orm.SugarRecord;

/**
 * Created by michal on 20.04.2017.
 */


public class Website extends SugarRecord {
    private String address;
    private String title;
    private Boolean isLogged;
    private Boolean showWelcomeMessage;
    private String token;
    private String welcomeTitle;
    private String welcomeMessage;

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

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getWelcomeTitle() {
        return welcomeTitle;
    }

    public void setWelcomeTitle(String welcomeTitle) {
        this.welcomeTitle = welcomeTitle;
    }

    public Boolean getShowWelcomeMessage() {
        return showWelcomeMessage;
    }

    public void setShowWelcomeMessage(Boolean showWelcomeMessage) {
        this.showWelcomeMessage = showWelcomeMessage;
    }
}
