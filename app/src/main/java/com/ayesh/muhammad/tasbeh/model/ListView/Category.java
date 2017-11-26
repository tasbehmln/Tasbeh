package com.ayesh.muhammad.tasbeh.model.ListView;

import android.support.annotation.DrawableRes;

/**
 * Created by muhammad on 03/08/17.
 */

public class Category {
    private String text;
    private int resource;
    private Class<?> activity;
    private String categoryName;

    public Category(){

    }
    public Category( String rowTile, @DrawableRes int icon, Class<?> activity,String categoryName) {
        this.setRowTile(rowTile);
        this.setResource(icon);
        this.setActivity(activity);
        this.setCategoryName(categoryName);
    }

    public String getRowTitle() {
        return text;
    }

    public int getIcon() {
        return getResource();
    }


    public Class<?> getActivity() {
        return activity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setRowTile(String text) {
        this.text = text;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }
}
