package com.ccpgames.crest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jeremy Shore on 4/9/15.
 */
public class ServerStatus {

    @SerializedName("serverName")
    private String serverName;

    @SerializedName("serverVersion")
    private String serverVersion;

    @SerializedName("serviceStatus")
    private ServiceStatus status;

    @SerializedName("userCounts")
    private UserCounts counts;

    public int getEvePlayerCount() {
        return counts.eve;
    }

    public int getDustPlayerCount() {
        return counts.dust;
    }

    public String getEveStatus() {
        return status.eve;
    }

    public String getServerStatus() {
        return status.server;
    }

    public String getDustStatus() {
        return status.dust;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public String getServerName() {
        return serverName;
    }

    private class ServiceStatus {

        @SerializedName("eve")
        protected String eve;

        @SerializedName("server")
        protected String server;

        @SerializedName("dust")
        protected String dust;

    }

    private class UserCounts {

        @SerializedName("eve")
        protected int eve;

        @SerializedName("dust")
        protected int dust;
    }
}
