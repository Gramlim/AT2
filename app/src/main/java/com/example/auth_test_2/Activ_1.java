package com.example.auth_test_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activ_1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_1_xml);

        SharedPreferences sharedPrefences = getSharedPreferences("Tokens",0);
        String token = sharedPrefences.getString("token1", "fail");
        final Interface loginService =
                ServiceGenerator.createService(Interface.class, token);
        Call<Pass> call = loginService.getSkip( new Pass("95"));
        call.enqueue(new Callback<Pass>() {
            @Override
            public void onResponse(Call<Pass> call, Response<Pass> response) {
            Intent intent = new Intent (Activ_1.this, Activ_2.class);
            startActivity(intent);
            }

            @Override
            public void onFailure(Call<Pass> call, Throwable t) {

            }
        });


    }

}
