package com.ccpgames.eveapi.Client;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Jeremy Shore on 4/9/15.
 */
interface ICrestService {

    @GET("/{path}")
    void getCrest(@Path("path") String path, Callback<?> callback);

}
