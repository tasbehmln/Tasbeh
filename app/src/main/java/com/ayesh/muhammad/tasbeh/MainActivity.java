package com.ayesh.muhammad.tasbeh;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ayesh.muhammad.tasbeh.model.ListView.CustomListView;
import com.ayesh.muhammad.tasbeh.services.MyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListView listView = new CustomListView(this,this, R.id.list_view_main, R.layout.listview_row_main);
        listView.makeView();
    }
}

