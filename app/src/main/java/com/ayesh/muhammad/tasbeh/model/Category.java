package com.ayesh.muhammad.tasbeh.model;

/**
 * Created by mohammad.k.hader on 8/8/2017.
 */

public class Category {
    private String title,imageFileName;

    public Category(String title, String imageFileName) {
        this.title = title;
        this.imageFileName = imageFileName;
    }

    public Category() {
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
