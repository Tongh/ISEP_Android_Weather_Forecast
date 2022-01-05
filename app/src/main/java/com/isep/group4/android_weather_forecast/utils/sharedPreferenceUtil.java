package com.isep.group4.android_weather_forecast.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.isep.group4.android_weather_forecast.beans.current_weather.CurrentWeather;

public class sharedPreferenceUtil {
    private static Double latitude;
    private static Double longitude;
    private static volatile CurrentWeather currentWeather;

    static public void saveLatLon(Context context, Double latitude, Double longitude){
        sharedPreferenceUtil.latitude = latitude;
        sharedPreferenceUtil.longitude = longitude;
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = context.getSharedPreferences("Location",Context.MODE_PRIVATE).edit();
        editor.putString("latitude",String.valueOf(latitude));
        editor.putString("longitude",String.valueOf(longitude));
    }

    static public void saveCurrentWeather(Context context, CurrentWeather currentWeather){
        sharedPreferenceUtil.currentWeather = currentWeather;
    }

    public static Double getLongitude() {
        return longitude;
    }

    public static Double getLatitude() {
        return latitude;
    }

    public static CurrentWeather getCurrentWeather() { return currentWeather; }
}
