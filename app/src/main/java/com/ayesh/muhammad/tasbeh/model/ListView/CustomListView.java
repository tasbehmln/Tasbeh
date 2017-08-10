package com.ayesh.muhammad.tasbeh.model.ListView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.WelcomeActivity;
import com.ayesh.muhammad.tasbeh.activities.counter.CounterActivity;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Makes a Customized List view.
 * <li>This class depends on:</li>
 * <ul>
 *     <li>{@link ListViewAdapter}: The adapter of the ListView.
 *
 * </ul>
 */

public class CustomListView {
    private int listViewTagId;
    private int listViewLayout;
    private Activity activity;
    private ListViewAdapter adapter;
    private static ArrayList<Object> data;
    public static String []categories;

    /**
     * Constructor.
     * Note: you have to invoke makeView() to make it work.
     *
     * <li>
     * @param activity parent activity.
     * <li>
     * @param listView id reference to the list view tag (ex: R.id.myListViewElementInTheMainActivity).
     * <li>
     * @param sampleListView Layout Reference of the customized layout that represents the row, (ex:R.layout.rowLayoutXmlFileName)
     */
    public CustomListView(Activity activity, @IdRes int listView, @LayoutRes int sampleListView) {
        this.listViewTagId = listView;
        this.listViewLayout = sampleListView;
        this.activity = activity;

    }

    /**
     * Forms the ListView
     */
    public void makeView() {
        invokeData();
        this.adapter = new ListViewAdapter(this.activity, listViewLayout, data);

        ListView listView = activity.findViewById(listViewTagId);
        listView.setAdapter(adapter);

        setOnItemClickListener(listView);
    }

    public void invokeData() {
        try {
            data = new ArrayList<>();
            implementTheDataHere(data);
        } catch (NullPointerException e) {
            implementTheDataHere(data);
        }
    }

    private void implementTheDataHere(ArrayList<Object> data) {
        categories= activity.getResources().getStringArray(R.array.categories);
        for (String s :categories) {

            Toast.makeText(activity.getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }

        data.add(new Category(categories[0], R.drawable.sunrise1, WelcomeActivity.class));
        data.add(new Category(categories[1], R.drawable.evening, CounterActivity.class));
        data.add(new Category(categories[2], R.drawable.masjed, CounterActivity.class));
        data.add(new Category(categories[3], R.drawable.sleep, WelcomeActivity.class));
    }

    private void setOnItemClickListener(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                goToActivity(view, i);
            }
        });
    }

    private void goToActivity(View view, int i) {
        Intent intent = new Intent(activity,((Category) data.get(i)).getActivity());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
}