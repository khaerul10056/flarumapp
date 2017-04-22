package com.bycode.flarum.Presenters;

import android.content.Context;

import com.bycode.flarum.ForumService;
import com.bycode.flarum.models.DiscussionsResponse;

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
        void latestDiscussionsReady(DiscussionsResponse discussionsResponse);
    }

    public LatestDiscussionsPresenter(LatestDiscussionsPresenterListener listener, Context context){
        this.mListener = listener;
        this.context = context;
        this.service = new ForumService();
    }

    public void getDiscussions(String BASE_URL){
        service
            .getAPI(BASE_URL)
            .getlistDiscussions()
            .enqueue(new Callback<DiscussionsResponse>() {
                @Override
                public void onResponse(Call<DiscussionsResponse> call, Response<DiscussionsResponse> response) {
                    DiscussionsResponse result = response.body();

                    if(result != null)
                        mListener.latestDiscussionsReady(result);
                }

                @Override
                public void onFailure(Call<DiscussionsResponse> call, Throwable t) {
                    try {
                        throw  new InterruptedException("Erro na comunicação com o servidor!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}

