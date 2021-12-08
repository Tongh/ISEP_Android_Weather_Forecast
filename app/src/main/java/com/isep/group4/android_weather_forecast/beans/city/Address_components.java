/**
  * Copyright 2021 bejson.com 
  */
package com.isep.group4.android_weather_forecast.beans.city;
import java.util.List;

/**
 * Auto-generated: 2021-12-01 11:14:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Address_components {

    private String long_name;
    private String short_name;
    private List<String> types;
    public void setLong_name(String long_name) {
         this.long_name = long_name;
     }
     public String getLong_name() {
         return long_name;
     }

    public void setShort_name(String short_name) {
         this.short_name = short_name;
     }
     public String getShort_name() {
         return short_name;
     }

    public void setTypes(List<String> types) {
         this.types = types;
     }
     public List<String> getTypes() {
         return types;
     }

}