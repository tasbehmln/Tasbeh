package com.ayesh.muhammad.tasbeh;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ayesh.muhammad.tasbeh.services.NotificationID;
import com.ayesh.muhammad.tasbeh.services.NotificationMaker;


public class WelcomeActivity extends AppCompatActivity {

    private static int WELCOME_TIMEOUT = 1500;
    //can't put permissions here because it will disappear after 3 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NotificationMaker.scheduleNotification(getApplicationContext(),6000, NotificationID.getID());
                Intent categories = new Intent(getApplicationContext(), LanguageActivity.class);
                startActivity(categories);
                finish();
            }
        },WELCOME_TIMEOUT);

    }
}
