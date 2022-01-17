package com.isep.group4.android_weather_forecast.beans.adapter;

public class DayWeather {
    private long date;
    private String weather;
    private String temp;

    public DayWeather(long date, String weather, String  temp){
        this.temp = temp;
        this.weather = weather;
        this.date = date;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String  getTemp() {
        return temp;
    }

    public long getDate() {
        return date;
    }

    public String getWeather() {
        return weather;
    }
}
