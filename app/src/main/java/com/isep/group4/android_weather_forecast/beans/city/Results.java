/**
  * Copyright 2021 bejson.com 
  */
package com.example.testcitysearch.gson;
import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2021-12-01 11:14:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Results {

    private List<Address_components> address_components;
    private Date formatted_address;
    private Geometry geometry;
    private boolean partial_match;
    private String place_id;
    private List<String> types;
    public void setAddress_components(List<Address_components> address_components) {
         this.address_components = address_components;
     }
     public List<Address_components> getAddress_components() {
         return address_components;
     }

    public void setFormatted_address(Date formatted_address) {
         this.formatted_address = formatted_address;
     }
     public Date getFormatted_address() {
         return formatted_address;
     }

    public void setGeometry(Geometry geometry) {
         this.geometry = geometry;
     }
     public Geometry getGeometry() {
         return geometry;
     }

    public void setPartial_match(boolean partial_match) {
         this.partial_match = partial_match;
     }
     public boolean getPartial_match() {
         return partial_match;
     }

    public void setPlace_id(String place_id) {
         this.place_id = place_id;
     }
     public String getPlace_id() {
         return place_id;
     }

    public void setTypes(List<String> types) {
         this.types = types;
     }
     public List<String> getTypes() {
         return types;
     }

}