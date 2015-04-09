package com.ccpgames.eveapi.Client;


import com.ccpgames.eveapi.ServerStatus;
import com.google.gson.Gson;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Jeremy Shore on 1/25/2015.
 */
public class ApiServices {

    private static ICrestService buildCrestAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setConverter(new StringConverter())
                .setEndpoint("http://public-crest.eveonline.com")
                .build();

        return restAdapter.create(ICrestService.class);
    }

    public static void getServerStatus(final Callback<ServerStatus> callback) {
        buildCrestAdapter()
                .getCrest("", new Callback<String>() {
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
