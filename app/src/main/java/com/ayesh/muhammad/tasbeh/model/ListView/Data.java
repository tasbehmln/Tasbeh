package com.ayesh.muhammad.tasbeh.model.ListView;

import android.support.annotation.DrawableRes;

/**
 * Created by muhammad on 03/08/17.
 */

public class Data {
    private String text;
    private int resource;

    public Data(String rowTile, @DrawableRes int icon) {
        this.text = rowTile;
        this.resource = icon;
    }

    public String getText() {
        return text;
    }

    public int getIcon() {
        return resource;
    }
}
