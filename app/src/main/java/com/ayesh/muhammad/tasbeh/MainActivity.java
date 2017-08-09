package com.ayesh.muhammad.tasbeh;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ayesh.muhammad.tasbeh.model.ListView.CustomListView;

public class MainActivity extends AppCompatActivity {
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        CustomListView listView = new CustomListView(this, R.id.list_view_main, R.layout.listview_row_main);
        listView.makeView();
    }

    public static Context getContext() {
            return context;
    }
}

