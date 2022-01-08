package com.isep.group4.android_weather_forecast.beans.forecast;

public class Minutely {

    private long dt;
    private double precipitation;

    public void setDt(long dt) {
        this.dt = dt;
    }
    public long getDt() {
        return dt;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }
    public double getPrecipitation() {
        return precipitation;
    }

}