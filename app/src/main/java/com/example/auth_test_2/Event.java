package com.example.auth_test_2;

import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("device_mac")
    private String device_mac;
    @SerializedName("event")
    private String event;
    @SerializedName("id")
    private String id;
    @SerializedName("meta")
    private String meta;
    @SerializedName("timestamp")
    private String timestamp;

    public String getDevice_mac(){
        return device_mac;
    }
    public String getEvent(){
        return event;
    }
    public String getId(){
        return id;
    }
    public String getMeta(){
        return meta;
    }
    public String getTimestamp(){
        return timestamp;
    }
}
