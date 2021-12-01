/**
  * Copyright 2021 bejson.com 
  */
package com.isep.group4.android_weather_forecast.beans.current_weather;

/**
 * Auto-generated: 2021-11-24 17:34:38
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Sys {

    private int type;
    private long id;
    private String country;
    private long sunrise;
    private long sunset;
    public void setType(int type) {
         this.type = type;
     }
     public int getType() {
         return type;
     }

    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setCountry(String country) {
         this.country = country;
     }
     public String getCountry() {
         return country;
     }

    public void setSunrise(long sunrise) {
         this.sunrise = sunrise;
     }
     public long getSunrise() {
         return sunrise;
     }

    public void setSunset(long sunset) {
         this.sunset = sunset;
     }
     public long getSunset() {
         return sunset;
     }

}