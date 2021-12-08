package com.isep.group4.android_weather_forecast.utils;

import android.util.Log;
import com.example.testcitysearch.gson.CitySearch;
import com.google.gson.Gson;
import com.isep.group4.android_weather_forecast.beans.current_weather.CurrentWeather;

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

    public static CurrentWeather handleCurrentWeather(String response){
        try {
            JSONObject object = new JSONObject(response);
            Log.d("Current Weather: ",object.toString());
            CurrentWeather currentWeather = new Gson().fromJson(object.toString(), CurrentWeather.class);
            return currentWeather;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
