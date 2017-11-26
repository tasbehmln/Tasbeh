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

import com.ayesh.muhammad.tasbeh.FavoriteActivity;
import com.ayesh.muhammad.tasbeh.MainActivity;
import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.SwipeActivity;
import com.ayesh.muhammad.tasbeh.TempActivity;
import com.ayesh.muhammad.tasbeh.WelcomeActivity;
import com.ayesh.muhammad.tasbeh.activities.counter.CounterActivity;
import com.ayesh.muhammad.tasbeh.model.Language;
import com.ayesh.muhammad.tasbeh.services.JsonParser;

import java.util.ArrayList;
import java.util.List;
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
    private final Context context;
    private int listViewTagId;
    private int listViewLayout;
    private Activity activity;
    private ListViewAdapter adapter;
    private String type;
    private static ArrayList<Object> data;
    private static List<Category> categories;
    //public static String []categories;
    public static String []favorite;

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
    public CustomListView(Activity activity, @IdRes int listView, @LayoutRes int sampleListView,Context context) {
        this.listViewTagId = listView;
        this.listViewLayout = sampleListView;
        this.activity = activity;
        this.context=context;
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
            implementTheDataHere(data,type);
        } catch (NullPointerException e) {
            implementTheDataHere(data,type);
        }
    }

    private void implementTheDataHere(ArrayList<Object> data,String type) {
        if (activity instanceof FavoriteActivity){
            type="favorite";
        }
        else if(activity instanceof MainActivity){
            type="main";
        }
        if (type=="main"){
//            categories= activity.getResources().getStringArray(R.array.categories);
//
//            data.add(new Category(categories[0], R.drawable.masjed, FavoriteActivity.class,"PrayerAthkar"));
//            data.add(new Category(categories[1], R.drawable.sunrise1, SwipeActivity.class,"MorningAthkar"));
//            data.add(new Category(categories[2], R.drawable.evening, CounterActivity.class,"EveningAthkar"));
//            data.add(new Category(categories[3], R.drawable.sleep, CounterActivity.class,"SleepAthkar"));

            categories= JsonParser.getCategories(context);
            for (int i=0;i<categories.size();i++) {
                data.add(new Category(
                        categories.get(i).getRowTitle(),
                        categories.get(i).getIcon(),
                        SwipeActivity.class,
                        categories.get(i).getCategoryName()));
            }
        }else if(type=="favorite"){
            favorite=activity.getResources().getStringArray(R.array.favorite);
            for (int i=0;i<favorite.length;i++) {
                data.add(new Category(favorite[i], R.drawable.bookmark, TempActivity.class,"Favorites"));
            }
        }

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
        intent.putExtra("favoriteText", ((Category) data.get(i)).getRowTitle());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
}