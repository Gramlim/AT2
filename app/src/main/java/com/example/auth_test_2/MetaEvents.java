package com.example.auth_test_2;

import com.google.gson.annotations.SerializedName;

public class MetaEvents {
    @SerializedName("items_on_page")
    private String items_on_page;
    @SerializedName("page")
    private String page;
    @SerializedName("per_page")
    private String per_page;
    @SerializedName("total_items")
    private String total_items;
    @SerializedName("total_pages")
    private String total_pages;

    public String getPage(){
        return page;
    }
    public String getPer_page(){
        return per_page;
    }
    public String getItemsOnPage(){
        return items_on_page;
    }
    public MetaEvents(String p, String pp){
        this.page = p;
        this.per_page = pp;
    }

}
