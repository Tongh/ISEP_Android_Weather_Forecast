package com.isep.group4.android_weather_forecast.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeUtil {
    public static long  Transfer(long time) {
        Date date = new Date(time * 1000);
        String pattern = "yyyy-MM-dd HH";
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String ret = dateFormat.format(date);
        return Long.parseLong(ret.split(" ")[1]);
    }
}
