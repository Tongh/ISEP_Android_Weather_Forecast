package com.isep.group4.android_weather_forecast.utils;

import android.util.Log;
import com.example.testcitysearch.gson.CitySearch;
import com.google.gson.Gson;
import org.json.JSONObject;

public class handleUtils {
    public static CitySearch handleCitySearch(String response){
        try {
            JSONObject object = new JSONObject(response);
            Log.d("citySearch",object.toString());
            CitySearch citySearch = new Gson().fromJson(object.toString(), CitySearch.class);
            return citySearch;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
