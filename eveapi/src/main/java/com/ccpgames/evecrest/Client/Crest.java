package com.ccpgames.evecrest.Client;

import com.ccpgames.evecrest.ServerStatus;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Created by Jeremy Shore on 1/25/2015.
 */
public class Crest {

    public static final String PUBLIC_SINGULARITY = "http://public-crest-sisi.testeveonline.com/";
    public static final String SINGULARITY = "https://api-sisi.testeveonline.com/";
    public static final String PUBLIC_TRANQUILITY = "http://public-crest.eveonline.com/";
    public static final String TRANQUILITY = "https://crest-tq.eveonline.com/";

    Endpoint crestEndpoint = new Builder()
            .setTranquilityEndpoint()
            .buildEndpoint();

    public void setCrestEndpoint(Endpoint crestEndpoint) {
        this.crestEndpoint = crestEndpoint;
    }

    interface Endpoint {
        @GET("/{path}")
        void getCrest(@Path("path") String path, Callback<?> callback);

        @GET("/{path}")
        void getCrest(@Path("path") String path, @QueryMap HashMap<String, String> params,
                      Callback<?> callback);
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

    public static class Builder {

        private String basePath;

        public Builder setSingularityEndpoint() {
            this.basePath = SINGULARITY;
            return this;
        }

        public Builder setTranquilityEndpoint() {
            this.basePath = TRANQUILITY;
            return this;
        }

        public Crest build() {
            Crest crest = new Crest();
            crest.setCrestEndpoint(buildEndpoint());
            return crest;
        }

        public Endpoint buildEndpoint() {
            return new RestAdapter.Builder()
                    .setConverter(new StringConverter())
                    .setEndpoint(basePath)
                    .build()
                    .create(Endpoint.class);
        }
    }
}
