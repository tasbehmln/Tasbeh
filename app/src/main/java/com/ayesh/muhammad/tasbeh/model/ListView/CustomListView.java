package com.ayesh.muhammad.tasbeh.model.ListView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
    public CustomListView(Activity activity, Context context, @IdRes int listView, @LayoutRes int sampleListView) {
        DataHolder.invokeData(activity,context);
        this.listViewTagId = listView;
        this.listViewLayout = sampleListView;
        this.activity = activity;

    }

    /**
     * Forms the ListView
     */
    public void makeView() {
        this.adapter = new ListViewAdapter(this.activity, listViewLayout);
        ((ListView) activity.findViewById(listViewTagId)).setAdapter(adapter);

        ListView listView = activity.findViewById(listViewTagId);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(activity,((Category)DataHolder.getData().get(i)).getActivity());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    /**
     * Returns a reference of the listView.
     * @return listView.
     */
    public ListView getListView() {
        return (ListView) activity.findViewById(listViewTagId);
    }

    /**
     * Returns a reference of the containing adapter of listView.
     * @return {@link ListViewAdapter}.
     */
    public ListViewAdapter getAdapter() {
        return adapter;
    }
}