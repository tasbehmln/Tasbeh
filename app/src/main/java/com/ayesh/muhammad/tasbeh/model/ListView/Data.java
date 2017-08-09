package com.ayesh.muhammad.tasbeh.model.ListView;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by muhammad on 03/08/17.
 */

public class Data {
    private int text;
    private int resource;
    private Class<?> activity;

    public Data(@StringRes int rowTile, @DrawableRes int icon, Class<?> activity) {
        this.text = rowTile;
        this.resource = icon;
        this.activity = activity;
    }

    public int getText() {
        return text;
    }

    public int getIcon() {
        return resource;
    }


    public Class<?> getActivity() {
        return activity;
    }
}
