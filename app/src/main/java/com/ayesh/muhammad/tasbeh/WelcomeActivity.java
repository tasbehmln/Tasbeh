package com.ayesh.muhammad.tasbeh;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class WelcomeActivity extends AppCompatActivity {

    private static int WELCOME_TIMEOUT = 3000;
    //can't put permissions here because it will disappear after 3 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent categories = new Intent(getApplicationContext(), LanguageActivity.class);
                startActivity(categories);
                finish();
            }
        },WELCOME_TIMEOUT);

    }
}
