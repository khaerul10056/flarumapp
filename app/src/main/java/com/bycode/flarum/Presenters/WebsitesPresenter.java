package com.bycode.flarum.Presenters;

import android.content.Context;
import android.util.Log;

import com.bycode.flarum.ForumService;
import com.bycode.flarum.models.localDatabase.Website;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michal on 20.04.2017.
 */


public class WebsitesPresenter {
    private final Context context;
    private final WebsitesPresenterListener mListener;
    private final ForumService service;

    public interface WebsitesPresenterListener{
        void websitesReady(ArrayList <Website> websites);
    }

    public WebsitesPresenter(WebsitesPresenterListener listener, Context context){
        this.mListener = listener;
        this.context = context;
        this.service = new ForumService();
    }

    public void getWebsites(){
        ArrayList <Website> websites = new ArrayList<>();
        List<Website> websitesList = Website.listAll(Website.class);
        websites.addAll(websitesList);
        mListener.websitesReady(websites);
    }
}

