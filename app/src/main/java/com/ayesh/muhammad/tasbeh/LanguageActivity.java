package com.ayesh.muhammad.tasbeh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ayesh.muhammad.tasbeh.adapter.CustomAdapter;
import com.ayesh.muhammad.tasbeh.model.ListItem;

import java.util.ArrayList;


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
        setContentView(R.layout.activity_language);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<ListItem>();

        for (int i = 0;i <=1;i++){

            ListItem listItem = new ListItem();
            listItem.setLanguageName(languageList[i]);
            listItem.setLanguageImage(flags[i]);

            arrayList.add(listItem);
        }
        customAdapter = new CustomAdapter(this,arrayList);
        listView.setAdapter(customAdapter);
//
//        final Button arabicBtn = (Button)findViewById(R.id.arabicBtn);
//        arabicBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                String languageToLoad  = "ar"; // your language
//                Locale locale = new Locale(languageToLoad);
//                Locale.setDefault(locale);
//                Configuration config = new Configuration();
//                config.locale = locale;
//                getBaseContext().getResources().updateConfiguration(config,
//                        getBaseContext().getResources().getDisplayMetrics());
//
//                SharedPreferences arabicgepref = getSharedPreferences("language",MODE_PRIVATE);
//                SharedPreferences.Editor editor = arabicgepref.edit();
//                editor.putString("languageToLoad",languageToLoad );
//                editor.commit();
//                Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                i.putExtra("Language", "arabic");
//                startActivity(i);
//            }
//        });
//        final Button englishBtn = (Button)findViewById(R.id.englishBtn);
//        englishBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String languageToLoad  = "en"; // your language
//                Locale locale = new Locale(languageToLoad);
//                Locale.setDefault(locale);
//                Configuration config = new Configuration();
//                config.locale = locale;
//                getBaseContext().getResources().updateConfiguration(config,
//                        getBaseContext().getResources().getDisplayMetrics());
//
//                SharedPreferences languagepref = getSharedPreferences("language",MODE_PRIVATE);
//                SharedPreferences.Editor editor = languagepref.edit();
//                editor.putString("languageToLoad",languageToLoad );
//                editor.commit();
//
//                Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                i.putExtra("Language", "english");
//                startActivity(i);
//            }
//        });

    }

}
