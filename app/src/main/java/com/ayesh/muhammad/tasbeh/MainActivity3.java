package com.ayesh.muhammad.tasbeh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ListView mainList = (ListView) findViewById(R.id.mainList);

        ArrayList<String> listData = new ArrayList<>();

        listData.add("سبحان الله");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listData);

        mainList.setAdapter(listAdapter);
    }
}
