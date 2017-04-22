package com.bycode.flario;

import com.bycode.flario.models.DiscussionsResponse;
import com.bycode.flario.models.WebsiteInfoResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by michal on 19.04.2017.
 */

public class ForumService {
    public interface ForumAPI {
        @GET("api/discussions")
        Call<DiscussionsResponse> getlistDiscussions();

        @GET("api/forum")
        Call<WebsiteInfoResponse> getWebsiteInformations();
    }

    public ForumAPI getAPI(String BASE_URL){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ForumAPI.class);
    }
}
