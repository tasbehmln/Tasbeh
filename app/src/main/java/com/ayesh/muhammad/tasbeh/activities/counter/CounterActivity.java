package com.ayesh.muhammad.tasbeh.activities.counter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.services.MyContextWrapper;

public class CounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        new CounterActivityController(this).invoke();
    }


}

