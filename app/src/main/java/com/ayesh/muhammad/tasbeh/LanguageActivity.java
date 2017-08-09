package com.ayesh.muhammad.tasbeh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ayesh.muhammad.tasbeh.activities.counter.CounterActivity;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        final Button arabicBtn = (Button)findViewById(R.id.arabicBtn);
        arabicBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CounterActivity.class);
                i.putExtra("Language", "arabic");
                startActivity(i);
            }
        });
        final Button englishBtn = (Button)findViewById(R.id.englishBtn);
        englishBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CounterActivity.class);
                i.putExtra("Language", "english");
                startActivity(i);
            }
        });
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            Intent intent = new Intent(this, CounterActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.commit();
        }
    }
}
