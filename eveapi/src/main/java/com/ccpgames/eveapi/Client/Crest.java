package com.ccpgames.eveapi.Client;


import com.ccpgames.eveapi.ServerStatus;
import com.google.gson.Gson;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Jeremy Shore on 1/25/2015.
 */
public class Crest {

    private Endpoint crestEndpoint;

    void setCrestEndpoint(Endpoint crestEndpoint) {
        this.crestEndpoint = crestEndpoint;
    }

    interface Endpoint {
        @GET("/{path}")
        void getCrest(@Path("path") String path, Callback<?> callback);
    }

    public void getServerStatus(final Callback<ServerStatus> callback) {
        crestEndpoint.getCrest("", new Callback<String>() {
            @Override
            public void success(String json, Response response) {
                callback.success(new Gson().fromJson(json, ServerStatus.class), response);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }
}
