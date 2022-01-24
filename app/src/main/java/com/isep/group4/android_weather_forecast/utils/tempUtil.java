package com.isep.group4.android_weather_forecast.utils;

import java.text.DecimalFormat;

public class tempUtil {
    static DecimalFormat df = new DecimalFormat( "0");
    public static String transfer(double temp) {
        double C = temp - 273.15;
        return df.format(C) + "℃";
    }
    public static Double transferDouble(double temp){
        double C = temp - 273.15;
        return (double) (Math.round(C * 100) / 100);
    }
}
