package com.isep.group4.android_weather_forecast.beans.forecast;

public class Minutely {

    private long dt;
    private int precipitation;

    public void setDt(long dt) {
        this.dt = dt;
    }
    public long getDt() {
        return dt;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }
    public int getPrecipitation() {
        return precipitation;
    }

}