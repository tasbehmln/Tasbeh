package com.ayesh.muhammad.tasbeh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ayesh.muhammad.tasbeh.activities.counter.CounterActivity;
import com.ayesh.muhammad.tasbeh.model.Category;
import com.ayesh.muhammad.tasbeh.services.JsonParser;

import java.util.ArrayList;
import java.util.List;

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
                Intent categories = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(categories);
                finish();
            }
        },WELCOME_TIMEOUT);

    }
}
