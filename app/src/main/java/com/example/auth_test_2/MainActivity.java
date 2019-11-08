package com.example.auth_test_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "Tockens";
    public static final String APP_PREFERENCES_TOKEN1 = "token1";
    SharedPreferences mToken;
    EditText log;
    EditText pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToken = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        this.log = this.findViewById(R.id.editText);
        this.pas = this.findViewById(R.id.editText2);
    }
    public void onClock (View view){
        /*
        Interface loginService =
                ServiceGenerator.createService(Interface.class, String.valueOf(log.getText()),
                        String.valueOf(pas.getText()));

         */

        Interface loginService =
                ServiceGenerator.createService(Interface.class, "mobil",
                        "1234");
        Call<User> call = loginService.basicLogin();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    SharedPreferences sharedPrefences = MainActivity.this.getSharedPreferences
                            ("Tokens",0);
                    SharedPreferences.Editor editor = sharedPrefences.edit();
                    editor.putString("token1", response.body().getToken());
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, Activ_2.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, String.valueOf(response.message()), Toast.LENGTH_LONG).show();

                }
            }



            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, String.valueOf(t.getMessage()), Toast.LENGTH_LONG).show();
            }
        });

    }

    }

