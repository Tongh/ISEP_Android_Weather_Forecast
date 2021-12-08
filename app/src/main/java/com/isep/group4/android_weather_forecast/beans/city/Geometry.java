/**
  * Copyright 2021 bejson.com 
  */
package com.isep.group4.android_weather_forecast.beans.city;

/**
 * Auto-generated: 2021-12-01 11:14:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Geometry {

    private Bounds bounds;
    private Location location;
    private String location_type;
    private Viewport viewport;
    public void setBounds(Bounds bounds) {
         this.bounds = bounds;
     }
     public Bounds getBounds() {
         return bounds;
     }

    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setLocation_type(String location_type) {
         this.location_type = location_type;
     }
     public String getLocation_type() {
         return location_type;
     }

    public void setViewport(Viewport viewport) {
         this.viewport = viewport;
     }
     public Viewport getViewport() {
         return viewport;
     }

}