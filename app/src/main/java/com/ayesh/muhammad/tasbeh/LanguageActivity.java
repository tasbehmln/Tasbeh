package com.ayesh.muhammad.tasbeh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.ayesh.muhammad.tasbeh.services.MyContextWrapper;

import java.util.Locale;


public class LanguageActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        final Button arabicBtn = (Button)findViewById(R.id.arabicBtn);
        arabicBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String languageToLoad  = "ar"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                SharedPreferences arabicgepref = getSharedPreferences("language",MODE_PRIVATE);
                SharedPreferences.Editor editor = arabicgepref.edit();
                editor.putString("languageToLoad",languageToLoad );
                editor.commit();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("Language", "arabic");
                startActivity(i);
            }
        });
        final Button englishBtn = (Button)findViewById(R.id.englishBtn);
        englishBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String languageToLoad  = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                SharedPreferences languagepref = getSharedPreferences("language",MODE_PRIVATE);
                SharedPreferences.Editor editor = languagepref.edit();
                editor.putString("languageToLoad",languageToLoad );
                editor.commit();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("Language", "english");
                startActivity(i);
            }
        });

    }

}
