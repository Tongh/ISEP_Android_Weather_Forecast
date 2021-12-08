/**
  * Copyright 2021 bejson.com 
  */
package com.isep.group4.android_weather_forecast.beans.city;
import java.util.List;

/**
 * Auto-generated: 2021-12-01 11:14:4
 *s
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CitySearch {

    private List<Results> results;
    private String status;
    public void setResults(List<Results> results) {
         this.results = results;
     }
     public List<Results> getResults() {
         return results;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

}