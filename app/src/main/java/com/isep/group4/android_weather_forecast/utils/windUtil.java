package com.isep.group4.android_weather_forecast.utils;

public class windUtil {
    public static String ToDirection(int degree) {
        if (degree <= 22.5 || degree > 337.5) {
            return "North";
        }
        return "";
    }
}
