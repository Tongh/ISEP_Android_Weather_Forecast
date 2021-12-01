package com.isep.group4.android_weather_forecast.beans.forecast;

import java.util.List;


public class Hourly {

    private long dt;
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private int uvi;
    private int clouds;
    private int visibility;
    private double wind_speed;
    private int wind_deg;
    private double wind_gust;
    private List<Weather> weather;
    private int pop;


    public void setDt(long dt) {
        this.dt = dt;
    }
    public long getDt() {
        return dt;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
    public double getTemp() {
        return temp;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }
    public double getFeels_like() {
        return feels_like;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
    public int getPressure() {
        return pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getHumidity() {
        return humidity;
    }

    public void setDew_point(double dew_point) {
        this.dew_point = dew_point;
    }
    public double getDew_point() {
        return dew_point;
    }

    public void setUvi(int uvi) {
        this.uvi = uvi;
    }
    public int getUvi() {
        return uvi;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }
    public int getClouds() {
        return clouds;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
    public int getVisibility() {
        return visibility;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }
    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }
    public int getWind_deg() {
        return wind_deg;
    }

    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }
    public double getWind_gust() {
        return wind_gust;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
    public List<Weather> getWeather() {
        return weather;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }
    public int getPop() {
        return pop;
    }

}