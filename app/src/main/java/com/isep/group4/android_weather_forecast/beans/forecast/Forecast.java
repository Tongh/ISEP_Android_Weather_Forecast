package com.isep.group4.android_weather_forecast.beans.forecast;

import java.util.List;


public class Forecast {

    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private Current current;
    private List<Minutely> minutely;
    private List<Hourly> hourly;
    private List<Daily> daily;


    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLat() {
        return lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
    public double getLon() {
        return lon;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }
    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
    public Current getCurrent() {
        return current;
    }

    public void setMinutely(List<Minutely> minutely) {
        this.minutely = minutely;
    }
    public List<Minutely> getMinutely() {
        return minutely;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }
    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }
    public List<Daily> getDaily() {
        return daily;
    }

}
