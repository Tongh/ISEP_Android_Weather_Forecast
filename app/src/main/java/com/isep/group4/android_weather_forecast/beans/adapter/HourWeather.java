package com.isep.group4.android_weather_forecast.beans.adapter;

public class HourWeather {
    private long time;
    private String weather;
    private String temp;

    public HourWeather(long time, String weather, String  temp){
        this.temp = temp;
        this.weather = weather;
        this.time = time;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String  getTemp() {
        return temp;
    }

    public long getTime() {
        return time;
    }

    public String getWeather() {
        return weather;
    }
}
