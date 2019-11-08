package com.example.auth_test_2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {
    @SerializedName("_meta")
    private MetaEvents _meta;
    @SerializedName("items")
    private List<Event> list;

    public MetaEvents getMeta(){
        return _meta;
    }
    public List<Event> getEvents(){
        return list;
    }
}
