package com.bycode.flario.Presenters;

import android.content.Context;

import com.bycode.flario.ForumService;
import com.bycode.flario.models.WebsiteInfoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by michal on 20.04.2017.
 */


public class WebsiteInfoPresenter {
    private final Context context;
    private final WebsiteInfoPresenterListener mListener;
    private final ForumService service;

    public interface WebsiteInfoPresenterListener{
        void websiteInfoReady(WebsiteInfoResponse websiteInfoResponse);
        void websiteInfoFailed(String error);
    }

    public WebsiteInfoPresenter(WebsiteInfoPresenterListener listener, Context context){
        this.mListener = listener;
        this.context = context;
        this.service = new ForumService();
    }

    public void getWebsiteInfo(String BASE_URL){
        service
                .getAPI(BASE_URL)
                .getWebsiteInformations()
                .enqueue(new Callback<WebsiteInfoResponse>() {
                    @Override
                    public void onResponse(Call<WebsiteInfoResponse> call, Response<WebsiteInfoResponse> response) {
                        WebsiteInfoResponse result = response.body();

                        if(result != null)
                            mListener.websiteInfoReady(result);
                    }

                    @Override
                    public void onFailure(Call<WebsiteInfoResponse> call, Throwable t) {
                        mListener.websiteInfoFailed(t.toString());
                        try {
                            throw  new InterruptedException("Erro na comunicação com o servidor!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}

