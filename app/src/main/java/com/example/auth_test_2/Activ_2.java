package com.example.auth_test_2;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Activ_2 extends ListActivity {
    EditText p;
    EditText pp;
    Interface tokenService;
    int page = 0;
    int per_page = 0;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_1_xml);
        this.p = this.findViewById(R.id.page);
        this.pp = this.findViewById(R.id.per_page);
        SharedPreferences sharedPrefences = getSharedPreferences("Tokens",0);
        String token = sharedPrefences.getString("token1", "fail");
        tokenService = ServiceGenerator.createService(Interface.class, token);
    }
    public void onGO(View view){
        page = Integer.valueOf(String.valueOf(p.getText()));
        per_page = Integer.valueOf(String.valueOf(pp.getText()));
        if(page>0 && per_page>0) {
            Call<Events> call = tokenService.getEvent(new MetaEvents(String.valueOf(page), String.valueOf(per_page)));
            Toast.makeText(Activ_2.this, String.valueOf(page)+" "+String.valueOf(per_page), Toast.LENGTH_LONG).show();

            call.enqueue(new Callback<Events>() {
                @Override
                public void onResponse(Call<Events> call, Response<Events> response) {
                    if(response.isSuccessful()) {
                        setDataToList(response.body().getEvents());
                    } else {
                        Toast.makeText(Activ_2.this, response.message(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Events> call, Throwable t) {
                    Toast.makeText(Activ_2.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });


        }



    }
    void setDataToList(List<Event> list) {
        setListAdapter(new CustomAdapter(this, list));
    }
}
