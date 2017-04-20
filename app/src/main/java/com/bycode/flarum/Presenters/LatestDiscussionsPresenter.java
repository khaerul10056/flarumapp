package com.bycode.flarum.Presenters;

import android.app.Service;
import android.content.Context;

import com.bycode.flarum.ForumService;
import com.bycode.flarum.models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by michal on 20.04.2017.
 */


public class LatestDiscussionsPresenter {
    private final Context context;
    private final LatestDiscussionsPresenterListener mListener;
    private final ForumService service;

    public interface LatestDiscussionsPresenterListener{
        void latestDiscussionsReady(Posts posts);
    }

    public LatestDiscussionsPresenter(LatestDiscussionsPresenterListener listener, Context context){
        this.mListener = listener;
        this.context = context;
        this.service = new ForumService();
    }

    public void getDiscussions(String BASE_URL){
        service
            .getAPI(BASE_URL)
            .getlistPosts()
            .enqueue(new Callback<Posts>() {
                @Override
                public void onResponse(Call<Posts> call, Response<Posts> response) {
                    Posts result = response.body();

                    if(result != null)
                        mListener.latestDiscussionsReady(result);
                }

                @Override
                public void onFailure(Call<Posts> call, Throwable t) {
                    try {
                        throw  new InterruptedException("Erro na comunicação com o servidor!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}

