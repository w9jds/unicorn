package com.ccpgames.unicorn;

import com.ccpgames.eveapi.Client.Crest;
import com.ccpgames.eveapi.ServerStatus;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;



/**
 * Created by Jeremy Shore on 4/15/2015.
 */

public class CrestTests extends TestCase {

    public void testPreConditions() {

    }

    public void testSingularityServerStatus() throws Exception {
        Crest crest = new Crest.CrestBuilder()
                .setSingularityEndpoint()
                .build();

        crest.getServerStatus(new Callback<ServerStatus>() {
            @Override
            public void success(ServerStatus serverStatus, Response response) {
                Assert.assertNotNull(serverStatus);
                Assert.assertEquals("SINGULARITY", serverStatus.getServerName().toUpperCase());
            }

            @Override
            public void failure(RetrofitError error) {
                throw error;
            }
        });

        new CountDownLatch(1).await(2000, TimeUnit.MILLISECONDS);
    }

    public void testTranquilityServerStatus() throws Exception {
        Crest crest = new Crest.CrestBuilder()
                .setTranquilityEndpoint()
                .build();

        crest.getServerStatus(new Callback<ServerStatus>() {
            @Override
            public void success(ServerStatus serverStatus, Response response) {
                Assert.assertNotNull(serverStatus);
                Assert.assertEquals("TRANQUILITY", serverStatus.getServerName().toUpperCase());
            }

            @Override
            public void failure(RetrofitError error) {
                throw error;
            }
        });

        new CountDownLatch(1).await(2000, TimeUnit.MILLISECONDS);
    }
}
