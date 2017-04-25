package com.bycode.flario.Presenters;

import android.content.Context;

import com.bycode.flario.ForumService;
import com.bycode.flario.models.DiscussionResponse;
import com.bycode.flario.models.DiscussionsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by michal on 20.04.2017.
 */


public class DiscussionPresenter {
    private final Context context;
    private final DiscussionPresenterListener mListener;
    private final ForumService service;

    public interface DiscussionPresenterListener {
        void discussionReady(DiscussionResponse discussionsResponse);
    }

    public DiscussionPresenter(DiscussionPresenterListener listener, Context context){
        this.mListener = listener;
        this.context = context;
        this.service = new ForumService();
    }

    public void getDiscussion(String BASE_URL, Integer discussion_id){
        service
            .getAPI(BASE_URL)
            .getDiscussion(discussion_id)
            .enqueue(new Callback<DiscussionResponse>() {
                @Override
                public void onResponse(Call<DiscussionResponse> call, Response<DiscussionResponse> response) {
                    DiscussionResponse result = response.body();

                    if(result != null)
                        mListener.discussionReady(result);
                }

                @Override
                public void onFailure(Call<DiscussionResponse> call, Throwable t) {
                    try {
                        throw  new InterruptedException("Erro na comunicação com o servidor!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}

