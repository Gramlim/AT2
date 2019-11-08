package com.example.auth_test_2;

import android.util.Log;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://intelligent-system.online/")
                .addConverterFactory(GsonConverterFactory.create());

        String authToken = Credentials.basic(username, password);

        AuthenticationInterceptor interceptor =
                new AuthenticationInterceptor(authToken);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        builder.client(httpClient.build());

        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, String authToken){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://intelligent-system.online/")
                .addConverterFactory(GsonConverterFactory.create());

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor("Bearer " + authToken);

        Log.d("request", interceptor.toString());
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        builder.client(httpClient.build());
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}