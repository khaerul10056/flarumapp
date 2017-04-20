package com.bycode.flarum.Presenters;

import android.content.Context;

import com.bycode.flarum.ForumService;
import com.bycode.flarum.models.Posts;
import com.bycode.flarum.models.Website;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Website website = new Website();
        website.setAddress("http://ubuntupolska.pl/ask/");

        Website website2 = new Website();
        website2.setAddress("https://discuss.flarum.org/");

        websites.add(website);
        websites.add(website2);
        mListener.websitesReady(websites);
    }
}

