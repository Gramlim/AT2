package com.example.auth_test_2;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {
    private String authTocken;

    public AuthenticationInterceptor(String token){
        this.authTocken = token;
    }
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException{
        Request original = chain.request();
        Request.Builder builder = original.newBuilder().header("Authorization",authTocken);

        Request request = builder.build();
        return chain.proceed(request);


}
}