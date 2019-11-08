package com.example.auth_test_2;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("token")
    private String token;

    public String getToken(){
        return token;
    }
}
