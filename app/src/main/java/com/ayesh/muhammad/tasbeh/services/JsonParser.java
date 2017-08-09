package com.ayesh.muhammad.tasbeh.services;


import android.content.Context;
import android.util.Log;

import com.ayesh.muhammad.tasbeh.model.Category;
import com.ayesh.muhammad.tasbeh.model.Theker;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class JsonParser {
    private static final String TAG = "Log from JSON";
    private static String language = "english";

    public static List<Theker> thekerList =new ArrayList<>();
    public static List<Category> categoryList =new ArrayList<>();
    private static String english;

    public static List<Category> getCategories(Context context) {

        String jsonStr = FileHelper.ReadFromFile("data.json",context).toString();

        Log.e(TAG, "Response from file: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray categories = jsonObj.getJSONArray("AthkarCategories");

                // looping through All Sports
                for (int i = 0; i < categories.length(); i++) {
                    JSONObject c = categories.getJSONObject(i);

                    String title = c.getString(language +"Title");
                    String imageFileName = c.getString("imageFileName");

                    Category tempCategory=new Category();
                    tempCategory.setTitle(title);
                    tempCategory.setImageFileName(imageFileName);

                    // adding contact to contact list
                    categoryList.add(tempCategory);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }

        return categoryList;
    }

    public static List<Theker> getAllThekers(Context context, String category) {

        String jsonStr = FileHelper.ReadFromFile("data.json",context).toString();

        Log.e(TAG, "Response from file: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray sportsCategory = jsonObj.getJSONArray(category);

                // looping through All Sports
                for (int i = 0; i < sportsCategory.length(); i++) {
                    JSONObject c = sportsCategory.getJSONObject(i);
                    String theker = c.getString(language+"Theker");
                    int currentCount = c.getInt("currentCount");

                    Theker tempTheker=new Theker();
                    tempTheker.setTheker(theker);
                    tempTheker.setCurrentCount(currentCount);

                    // adding contact to contact list
                    thekerList.add(tempTheker);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }

        return thekerList;
    }


   
}
