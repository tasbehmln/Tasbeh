package com.ayesh.muhammad.tasbeh.model.ListView;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.WelcomeActivity;
import com.ayesh.muhammad.tasbeh.activities.counter.CounterActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhammad on 05/08/17.
 */

public class DataHolder {
    private static ArrayList<Object> data;
    private static Activity activity;
    private static Context context;
    public static String []categories;
    public static List<Object> getData() {
        return data;
    }

    private static void implementTheDataHere(ArrayList<Object> data) {
        categories=context.getResources().getStringArray(R.array.categories);
        for (String s :categories) {

            Toast.makeText(activity.getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }

        data.add(new Category(categories[0], R.drawable.sunrise1, WelcomeActivity.class));
        data.add(new Category(categories[1], R.drawable.evening, CounterActivity.class));
        data.add(new Category(categories[2], R.drawable.masjed, CounterActivity.class));
        data.add(new Category(categories[3], R.drawable.sleep, WelcomeActivity.class));
    }

    /**
     * instantiate the data ArrayList object.
     */
    public static void invokeData(Activity activity,Context con) {
        try {
            DataHolder.context=con;
            DataHolder.activity = activity;
            DataHolder.data = new ArrayList<>();
            implementTheDataHere(data);
        } catch (NullPointerException e) {
            implementTheDataHere(data);
        }
    }

}
