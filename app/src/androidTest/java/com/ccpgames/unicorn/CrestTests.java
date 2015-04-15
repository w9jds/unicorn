package com.ccpgames.unicorn;

import com.ccpgames.eveapi.Client.Crest;
import com.ccpgames.eveapi.ServerStatus;
import com.google.gson.Gson;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;

import retrofit.MockRestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Jeremy Shore on 4/15/2015.
 */
public class CrestTests extends TestCase {

    public void testPreConditions() {

    }

    interface CrestEndpoint {
        @GET("/{path}")
        String getSingularityCrest(@Path("path") String path);

        @GET("/{path}")
        String getTranquilityCrest(@Path("path") String path);
    }

    static class MockCrestEndpoint implements CrestEndpoint {

        @Override
        public String getSingularityCrest(String path) {
            switch(path) {
                case "":
                    return "{'motd': {'dust': {'href': 'http://newsfeed.eveonline.coma/articles/71'}, 'eve': {'href': 'http://client.eveonline.com/motd/'}, 'server': {'href': 'http://client.eveonline.com/motd/'}}, 'crestEndpoint': {'href': 'https://api-sisi.testeveonline.com/'}, 'corporationRoles': {'href': 'https://api-sisi.testeveonline.com/corporations/roles/'}, 'itemGroups': {'href': 'https://api-sisi.testeveonline.com/inventory/groups/'}, 'channels': {'href': 'https://api-sisi.testeveonline.com/chat/channels/'}, 'corporations': {'href': 'https://api-sisi.testeveonline.com/corporations/'}, 'alliances': {'href': 'https://api-sisi.testeveonline.com/alliances/'}, 'itemTypes': {'href': 'https://api-sisi.testeveonline.com/types/'}, 'decode': {'href': 'https://api-sisi.testeveonline.com/decode/'}, 'battleTheatres': {'href': 'https://api-sisi.testeveonline.com/battles/theatres/'}, 'marketPrices': {'href': 'https://api-sisi.testeveonline.com/market/prices/'}, 'itemCategories': {'href': 'https://api-sisi.testeveonline.com/inventory/categories/'}, 'regions': {'href': 'https://api-sisi.testeveonline.com/regions/'}, 'bloodlines': {'href': 'https://api-sisi.testeveonline.com/bloodlines/'}, 'marketGroups': {'href': 'https://api-sisi.testeveonline.com/market/groups/'}, 'tournaments': {'href': 'https://api-sisi.testeveonline.com/tournaments/'}, 'map': {'href': 'https://api-sisi.testeveonline.com/map/'}, 'virtualGoodStore': {'href': 'https://sisivgs.testeveonline.com/'}, 'serverVersion': 'EVE-2015-DANNY 13.04.875461.875461', 'wars': {'href': 'https://api-sisi.testeveonline.com/wars/'}, 'incursions': {'href': 'https://api-sisi.testeveonline.com/incursions/'}, 'races': {'href': 'https://api-sisi.testeveonline.com/races/'}, 'authEndpoint': {'href': 'https://sisilogin.testeveonline.com/oauth/token/'}, 'serviceStatus': {'dust': 'vip', 'eve': 'online', 'server': 'online'}, 'userCounts': {'dust': 0, 'dust_str': '0', 'eve': 80, 'eve_str': '80'}, 'industry': {'facilities': {'href': 'https://api-sisi.testeveonline.com/industry/facilities/'}, 'systems': {'href': 'https://api-sisi.testeveonline.com/industry/systems/'}}, 'clients': {'dust': {'href': 'https://api-sisi.testeveonline.com/roots/dust/'}, 'eve': {'href': 'https://api-sisi.testeveonline.com/roots/eve/'}}, 'time': {'href': 'https://api-sisi.testeveonline.com/time/'}, 'marketTypes': {'href': 'https://api-sisi.testeveonline.com/market/types/'}, 'serverName': 'SINGULARITY'}";
                default:
                    return null;

            }
        }

        @Override
        public String getTranquilityCrest(String path) {
            switch(path) {
                case "":
                    return "{'motd': {'dust': {'href': 'http://newsfeed.eveonline.com/articles/71'}, 'eve': {'href': 'http://client.eveonline.com/motd/'}, 'server': {'href': 'http://client.eveonline.com/motd/'}}, 'crestEndpoint': {'href': 'https://crest-tq.eveonline.com/'}, 'corporationRoles': {'href': 'https://crest-tq.eveonline.com/corporations/roles/'}, 'itemGroups': {'href': 'https://crest-tq.eveonline.com/inventory/groups/'}, 'channels': {'href': 'https://crest-tq.eveonline.com/chat/channels/'}, 'corporations': {'href': 'https://crest-tq.eveonline.com/corporations/'}, 'alliances': {'href': 'https://crest-tq.eveonline.com/alliances/'}, 'itemTypes': {'href': 'https://crest-tq.eveonline.com/types/'}, 'decode': {'href': 'https://crest-tq.eveonline.com/decode/'}, 'battleTheatres': {'href': 'https://crest-tq.eveonline.com/battles/theatres/'}, 'marketPrices': {'href': 'https://crest-tq.eveonline.com/market/prices/'}, 'itemCategories': {'href': 'https://crest-tq.eveonline.com/inventory/categories/'}, 'regions': {'href': 'https://crest-tq.eveonline.com/regions/'}, 'bloodlines': {'href': 'https://crest-tq.eveonline.com/bloodlines/'}, 'marketGroups': {'href': 'https://crest-tq.eveonline.com/market/groups/'}, 'tournaments': {'href': 'https://crest-tq.eveonline.com/tournaments/'}, 'map': {'href': 'https://crest-tq.eveonline.com/map/'}, 'virtualGoodStore': {'href': 'https://vgs-tq.eveonline.com/'}, 'serverVersion': 'EVE-TRANQUILITY 8.53.875004.874992', 'wars': {'href': 'https://crest-tq.eveonline.com/wars/'}, 'incursions': {'href': 'https://crest-tq.eveonline.com/incursions/'}, 'races': {'href': 'https://crest-tq.eveonline.com/races/'}, 'authEndpoint': {'href': 'https://login-tq.eveonline.com/oauth/token/'}, 'serviceStatus': {'dust': 'online', 'eve': 'online', 'server': 'online'}, 'userCounts': {'dust': 1851, 'dust_str': '1851', 'eve': 21256, 'eve_str': '21256'}, 'industry': {'facilities': {'href': 'https://crest-tq.eveonline.com/industry/facilities/'}, 'systems': {'href': 'https://crest-tq.eveonline.com/industry/systems/'}}, 'clients': {'dust': {'href': 'https://crest-tq.eveonline.com/roots/dust/'}, 'eve': {'href': 'https://crest-tq.eveonline.com/roots/eve/'}}, 'time': {'href': 'https://crest-tq.eveonline.com/time/'}, 'marketTypes': {'href': 'https://crest-tq.eveonline.com/market/types/'}, 'serverName': 'TRANQUILITY'}";
                default:
                    return null;
            }
        }
    }

    public void testMockSingularityServerStatus() throws Exception {
        RestAdapter crestAdapter = new Crest.CrestBuilder()
                .setSingularityEndpoint()
                .buildRestAdapter();

        MockRestAdapter mockRestAdapter =
                MockRestAdapter.from(crestAdapter);

        MockCrestEndpoint mockCrestEndpoint = new MockCrestEndpoint();
        mockRestAdapter.create(CrestEndpoint.class, mockCrestEndpoint);

        ServerStatus serverStatus = new Gson().fromJson(
                mockCrestEndpoint.getSingularityCrest(""), ServerStatus.class) ;

        Assert.assertNotNull(serverStatus);
        Assert.assertEquals("SINGULARITY", serverStatus.getServerName().toUpperCase());
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

    public void testMockTranquilityServerStatus() throws Exception {
        RestAdapter crestAdapter = new Crest.CrestBuilder()
                .setSingularityEndpoint()
                .buildRestAdapter();

        MockRestAdapter mockRestAdapter =
                MockRestAdapter.from(crestAdapter);

        MockCrestEndpoint mockCrestEndpoint = new MockCrestEndpoint();
        mockRestAdapter.create(CrestEndpoint.class, mockCrestEndpoint);

        ServerStatus serverStatus = new Gson().fromJson(
                mockCrestEndpoint.getTranquilityCrest(""), ServerStatus.class) ;

        Assert.assertNotNull(serverStatus);
        Assert.assertEquals("TRANQUILITY", serverStatus.getServerName().toUpperCase());
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
