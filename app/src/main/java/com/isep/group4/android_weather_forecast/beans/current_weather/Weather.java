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
public class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setMain(String main) {
         this.main = main;
     }
     public String getMain() {
         return main;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setIcon(String icon) {
         this.icon = icon;
     }
     public String getIcon() {
         return icon;
     }

}