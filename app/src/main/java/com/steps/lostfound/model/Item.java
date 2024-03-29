package com.steps.lostfound.model;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;

/**
 * Model for database item.
 * <p/>
 * Created by Giorgi on 7/15/2015.
 */

@ParseClassName("Item")
public class Item extends ParseObject {

    public String getUserId() {
        return getString("userId");
    }

    public void setUserId(String userId) {
        put("userId", userId);
    }

    public String getCategory() {
        return getString("category");
    }

    public void setCategory(String category) {
        put("category", category);
    }

    public ParseGeoPoint getLocation() {
        return getParseGeoPoint("location");
    }

    public void setDate(Date date) {
        put("date", date);
    }

    public Date getDate() {
        return getDate("date");
    }

    public void setGeoLocation(ParseGeoPoint location) {
        put("location", location);
    }

    public int getRadius() {
        return getInt("radius");
    }

    public void setRadius(int radius) {
        put("radius", radius);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        put("description", description);
    }

    public boolean isLost() {
        return getBoolean("isLost");
    }

    public void setLost(boolean isLost) {
        put("isLost", isLost);
    }

    public boolean isResolved() {
        return getBoolean("isResolved");
    }

    public void setResolved(boolean isResolved) {
        put("isResolved", isResolved);
    }

    public static ParseQuery<Item> getQuery() {
        return ParseQuery.getQuery(Item.class);
    }

}
