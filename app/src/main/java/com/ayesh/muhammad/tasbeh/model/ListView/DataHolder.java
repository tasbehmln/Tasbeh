package com.ayesh.muhammad.tasbeh.model.ListView;

import android.widget.Toast;

import com.ayesh.muhammad.tasbeh.MainActivity;
import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.model.Category;
import com.ayesh.muhammad.tasbeh.services.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhammad on 05/08/17.
 */

public class DataHolder {
    private static ArrayList<Object> data;

    public static List<Object> getData() {
        return data;
    }
    public static List<Category> list;
    private static void implementTheDataHere(ArrayList<Object> data) {
//        data.add(new Data("أذكار الصلاة", R.drawable.masjed));
//        data.add(new Data("أذكار الصباح", R.drawable.sunrise1));
//        data.add(new Data("أذكار المساء", R.drawable.evening));
//        data.add(new Data("أذكار النوم", R.drawable.sleep));

        list = JsonParser.getCategories(MainActivity.getContext());
        for (Category c:list ) {
//            Toast.makeText(MainActivity.getContext(),c.getTitle()+" "+c.getImageFileName(),Toast.LENGTH_LONG).show();
            data.add(new Category(c.getTitle(),c.getImageFileName()));
        }

    }

    /**
     * instantiate the data ArrayList object.
     */
    public static void invokeData() {
        try {
            DataHolder.data = new ArrayList<>();
            implementTheDataHere(data);
        } catch (NullPointerException e) {
            implementTheDataHere(data);
        }
    }

}
