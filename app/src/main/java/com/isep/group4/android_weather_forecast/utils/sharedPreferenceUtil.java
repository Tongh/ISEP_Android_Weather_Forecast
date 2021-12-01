package com.isep.group4.android_weather_forecast.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class sharedPreferenceUtil {
    static Double latitude;
    static Double longitude;

    static public void saved(Context context, Double latitude, Double longitude){
        sharedPreferenceUtil.latitude = latitude;
        sharedPreferenceUtil.longitude = longitude;
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = context.getSharedPreferences("Location",Context.MODE_PRIVATE).edit();
        editor.putString("latitude",String.valueOf(latitude));
        editor.putString("longitude",String.valueOf(longitude));
    }

    public static Double getLongitude() {
        return longitude;
    }

    public static Double getLatitude() {
        return latitude;
    }
}
