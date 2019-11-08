package com.example.auth_test_2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Interface {
    @POST("api/tokens")
    Call<User> basicLogin();

    @POST("api/skip")
    Call<Pass> getSkip(@Body Pass skip_code);

    @POST("api/systemevents/get")
    Call<Events> getEvent(@Body MetaEvents meta);


}
