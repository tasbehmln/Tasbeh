package com.ayesh.muhammad.tasbeh.model.ListView;

import android.app.Activity;
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

    public static List<Object> getData() {
        return data;
    }

    private static void implementTheDataHere(ArrayList<Object> data) {
        Toast.makeText(activity.getApplicationContext(), "I am here", Toast.LENGTH_SHORT).show();
        data.add(new Category(R.string.app_name, R.drawable.masjed, CounterActivity.class));
        data.add(new Category(R.string.app_name, R.drawable.sunrise1, WelcomeActivity.class));
        data.add(new Category(R.string.app_name, R.drawable.evening, CounterActivity.class));
        data.add(new Category(R.string.app_name, R.drawable.sleep, WelcomeActivity.class));
    }

    /**
     * instantiate the data ArrayList object.
     */
    public static void invokeData(Activity activity) {
        try {
            DataHolder.activity = activity;
            DataHolder.data = new ArrayList<>();
            implementTheDataHere(data);
        } catch (NullPointerException e) {
            implementTheDataHere(data);
        }
    }

}
