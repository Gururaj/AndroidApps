package com.gsmayya.loctrac.data;

import android.content.ContentValues;

import org.chalup.microorm.annotations.Column;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import corelibs.data.Data;
import corelibs.schema.SchemaData;
import corelibs.schema.SchemaType;

/**
 * Created by gsmayya on 1/7/17.
 */


public class LocationData extends Data {

  private static final String KEY_START_TIME = "start_time";
  private static final String TABLE_WDIG_LOCATION = "wdig_location_2";
  private static final String KEY_ID = "id";
  private static final String KEY_DURATION = "duration";
  private static final String KEY_LAT = "latitude";
  private static final String KEY_LONG = "longitude";

  static SchemaData schema = new SchemaData(LocationData.TABLE_WDIG_LOCATION, new LocationData());

  static {
    schema.addId(LocationData.KEY_ID, SchemaType.INT);
    schema.addField(LocationData.KEY_START_TIME, SchemaType.INT);
    schema.addField(LocationData.KEY_DURATION, SchemaType.INT);
    schema.addField(LocationData.KEY_LAT, SchemaType.INT);
    schema.addField(LocationData.KEY_LONG, SchemaType.INT);
  }

  @Column(LocationData.KEY_START_TIME)
  private long _startTime;

  @Column(LocationData.KEY_DURATION)
  private long _duration;

  //private Location location; //get gps coordinates as separate
  @Column(LocationData.KEY_LAT)
  private long _lat;

  @Column(LocationData.KEY_LONG)
  private long _longitude;

  public long getStartTime() {
    return _startTime;
  }

  public long getDuration() {
    return _duration;
  }

  public long getLat() {
    return _lat;
  }

  public long getLongitude() {
    return _longitude;
  }

  public void setStartTime(long startTime) {
    _startTime = startTime;
  }

  public void setDuration(long duration) {
    _duration = duration;
  }

  public void setLat(long lat) {
    _lat = lat;
  }

  public void setLongitude(long longitude) {
    _longitude = longitude;
  }

  @Override
  public String toString() {
    return " START TIME: " + String.valueOf(_startTime)
        + " DURATION " + String.valueOf(_duration)
        + " LATITUDE " + String.valueOf(_lat)
        + " LONGITUDE " + String.valueOf(_longitude);
  }


  public static List<LocationData> getMockedData() {
    List<LocationData> locationDataList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      LocationData locationData = new LocationData();
      locationData.setStartTime(System.currentTimeMillis());
      locationData.setDuration(10);
      locationData.setLat((i+1) * new Random().nextInt());
      locationData.setLongitude((i+1) * new Random().nextInt());
      locationDataList.add(locationData);
    }
    return locationDataList;
  }

  public ContentValues addRecord(long id) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(KEY_ID, id);
    contentValues.put(KEY_START_TIME, getStartTime());
    contentValues.put(KEY_DURATION, getDuration());
    contentValues.put(KEY_LAT, getLat());
    contentValues.put(KEY_LONG, getLongitude());
    return contentValues;
  }
}

