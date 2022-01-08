package com.isep.group4.android_weather_forecast.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.isep.group4.android_weather_forecast.beans.adapter.HourWeather;
import com.isep.group4.android_weather_forecast.beans.current_weather.CurrentWeather;

import java.util.ArrayList;

public class sharedPreferenceUtil {
    private static Double latitude;
    private static Double longitude;
    private static volatile CurrentWeather currentWeather;
    private static ArrayList<HourWeather> hourWeathers;
    private static Context context;

    static public void saveLatLon(Context context, Double latitude, Double longitude) {
        sharedPreferenceUtil.context = context;
        sharedPreferenceUtil.latitude = latitude;
        sharedPreferenceUtil.longitude = longitude;
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = context.getSharedPreferences("Location", Context.MODE_PRIVATE).edit();
        editor.putString("latitude", String.valueOf(latitude));
        editor.putString("longitude", String.valueOf(longitude));
    }

    static public void saveCurrentWeather(Context context, CurrentWeather currentWeather) {
        sharedPreferenceUtil.currentWeather = currentWeather;
    }

    public static Double getLongitude() {
        return longitude;
    }

    public static Double getLatitude() {
        return latitude;
    }

    public static CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public static void setHourWeathers(ArrayList<HourWeather> hourWeathers) {
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = context.getSharedPreferences("HourWeathers", Context.MODE_PRIVATE).edit();
        editor.putString("hourweathers", hourWeathers.toString());
        sharedPreferenceUtil.hourWeathers = hourWeathers;
        Log.d("Forecast_Hour_Weather",hourWeathers.size()+"set");
    }

    public static ArrayList<HourWeather> getHourWeathers() {
        Log.d("Forecast_Hour_Weather",hourWeathers.size()+"get");
        return hourWeathers;
    }
}
