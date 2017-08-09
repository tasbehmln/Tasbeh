package com.ayesh.muhammad.tasbeh.activities.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.model.Category;
import com.ayesh.muhammad.tasbeh.model.Theker;
import com.ayesh.muhammad.tasbeh.services.JsonParser;

import java.util.List;

public class CounterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        new CounterActivityController(this).invoke();

//        List<Category> list= JsonParser.getCategories(this);
//        for (Category c:list ) {
//            Toast.makeText(getApplicationContext(),c.getTitle()+" "+c.getImageFileName(),Toast.LENGTH_LONG).show();
//        }
//        Toast.makeText(getApplicationContext(),"....",Toast.LENGTH_LONG).show();
//        List<Theker> list2= JsonParser.getAllThekers(this,"MorningAthkar");
//        for (Theker c:list2 ) {
//            Toast.makeText(getApplicationContext(),c.getTheker()+" "+c.getCurrentCount(),Toast.LENGTH_LONG).show();
//        }
    }


}

