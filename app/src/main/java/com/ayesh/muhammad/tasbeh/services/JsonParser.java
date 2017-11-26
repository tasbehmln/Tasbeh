package com.ayesh.muhammad.tasbeh.services;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.ayesh.muhammad.tasbeh.model.Category_test;
import com.ayesh.muhammad.tasbeh.model.Language;
import com.ayesh.muhammad.tasbeh.model.ListView.Category;
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
    private static String english;

    public static List<Category> getCategories(Context context) {
        List<Category> categoryList =new ArrayList<>();

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

                    String category = c.getString("category");
                    String rowTile = c.getString(language +"Title");
                    String icon = c.getString("icon");

                    Category tempCategory=new Category();
                    tempCategory.setCategoryName(category);
                    tempCategory.setRowTile(rowTile);
                    tempCategory.setResource(Services.getResId(icon, Drawable.class));

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
    public static List<Language> getLanguages(Context context){
        List<Language> languageList=new ArrayList<>();
        String jsonStr = FileHelper.ReadFromFile("settings.json",context).toString();
        JSONObject jsonObj=null;
        JSONArray languages=null;
        try {
            jsonObj = new JSONObject(jsonStr);
            languages= jsonObj.getJSONArray("Languages");
            for(int i=0; i<languages.length(); i++){
                Language language=new Language();
                JSONObject lang=(JSONObject) languages.get(i);
                language.setLanguage(lang.get("language").toString());
                language.setFlag(lang.get("flag").toString());
                languageList.add(language);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
       return languageList;
    }
    public static List<Theker> getAllThekers(Context context, String category) {

        String jsonStr = FileHelper.ReadFromFile("data.json",context).toString();
        final String ALL_ATHKAR="Athkar";
        Log.e(TAG, "Response from file: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONObject allAthkar = jsonObj.getJSONObject(ALL_ATHKAR);

                // Getting JSON Array node
                JSONArray chosenCategory = allAthkar.getJSONArray(category);

                // looping through All Sports
                for (int i = 0; i < chosenCategory.length(); i++) {
                    JSONObject c = chosenCategory.getJSONObject(i);
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
