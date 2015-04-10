package com.ccpgames.eveapi.Client;

import retrofit.RestAdapter;

/**
 * Created by Jeremy Shore on 4/9/2015.
 */
public class CrestBuilder {

    private String basePath;

    public CrestBuilder setSingularityEndpoint() {
        this.basePath = "http://public-crest-sisi.testeveonline.com/";
        return this;
    }

    public CrestBuilder setTranquilityEndpoint() {
        this.basePath = "https://crest-tq.eveonline.com/";
        return this;
    }

    public Crest build() {
        Crest crest = new Crest();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setConverter(new StringConverter())
                .setEndpoint(basePath)
                .build();

        crest.setCrestEndpoint(restAdapter.create(Crest.Endpoint.class));
        return crest;
    }
}
