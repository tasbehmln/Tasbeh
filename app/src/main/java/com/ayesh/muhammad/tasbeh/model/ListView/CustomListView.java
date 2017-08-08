package com.ayesh.muhammad.tasbeh.model.ListView;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
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
    private Activity context;
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
    public CustomListView(Activity activity, @IdRes int listView, @LayoutRes int sampleListView) {
        DataHolder.invokeData();
        this.listViewTagId = listView;
        this.listViewLayout = sampleListView;
        this.context = activity;
    }

    /**
     * Forms the ListView
     */
    public void makeView() {
        this.adapter = new ListViewAdapter(this.context, listViewLayout);
        ((ListView) context.findViewById(listViewTagId)).setAdapter(adapter);
    }

    /**
     * Returns a reference of the listView.
     * @return listView.
     */
    public ListView getListView() {
        return (ListView) context.findViewById(listViewTagId);
    }

    /**
     * Returns a reference of the containing adapter of listView.
     * @return {@link ListViewAdapter}.
     */
    public ListViewAdapter getAdapter() {
        return adapter;
    }
}