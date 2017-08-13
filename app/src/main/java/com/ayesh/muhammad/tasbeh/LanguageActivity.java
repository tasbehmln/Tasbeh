package com.ayesh.muhammad.tasbeh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.ayesh.muhammad.tasbeh.adapter.CustomAdapter;
import com.ayesh.muhammad.tasbeh.model.ListItem;

import java.util.ArrayList;
import java.util.Locale;


public class LanguageActivity  extends AppCompatActivity{
    private ListView listView;
    private CustomAdapter customAdapter;
    private ArrayList<ListItem> arrayList;
    private String[] languageList =new String[] {
            "Arabic",
            "English"
            };

    private int[] flags =new int[] {
            R.drawable.arabic,
            R.drawable.english
           };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences pref = getSharedPreferences("ActivityOnlyOnce", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.commit();
        }

        setContentView(R.layout.activity_language);
        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:

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
                        Intent ii = new Intent(getApplicationContext(),MainActivity.class);
                        ii.putExtra("Language", "arabic");
                        startActivity(ii);

                        break;
                    case 1:
                        String languageEN = "en";
                        locale = new Locale(languageEN);
                        Locale.setDefault(locale);
                        Configuration configEN = new Configuration();
                        configEN.locale = locale;
                        getBaseContext().getResources().updateConfiguration(configEN,
                                getBaseContext().getResources().getDisplayMetrics());

                        SharedPreferences languagePrefEN = getSharedPreferences("language",MODE_PRIVATE);
                        SharedPreferences.Editor editorEN = languagePrefEN.edit();
                        editorEN.putString("languageToLoad",languageEN );
                        editorEN.commit();

                        Intent en = new Intent(getApplicationContext(),MainActivity.class);
                        en.putExtra("Language", "english");
                        startActivity(en);
                        break;
                }
                ListItem listItem=(ListItem) listView.getItemAtPosition(i);
            }
        });
        arrayList = new ArrayList<ListItem>();

        for (int i = 0;i <=1;i++){

            ListItem listItem = new ListItem();
            listItem.setLanguageName(languageList[i]);
            listItem.setLanguageImage(flags[i]);

            arrayList.add(listItem);
        }
        customAdapter = new CustomAdapter(this,arrayList);
        listView.setAdapter(customAdapter);



    }

}
