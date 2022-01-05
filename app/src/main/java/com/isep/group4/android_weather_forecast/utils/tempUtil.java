package com.example.weatherapp.utils;

import java.text.DecimalFormat;

public class tempUtil {
    static DecimalFormat df = new DecimalFormat( "0.00");
    public static String transfer(double temp) {
        double C = temp - 273.15;
        return df.format(C) + "℃";
    }
}
