package com.ayesh.muhammad.tasbeh.model.ListView;

import com.ayesh.muhammad.tasbeh.R;

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

    private static void implementTheDataHere(ArrayList<Object> data) {
        data.add(new Data("أذكار الصلاة", R.drawable.masjed));
        data.add(new Data("أذكار الصباح", R.drawable.sunrise1));
        data.add(new Data("أذكار المساء", R.drawable.evening));
        data.add(new Data("أذكار النوم", R.drawable.sleep));
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
