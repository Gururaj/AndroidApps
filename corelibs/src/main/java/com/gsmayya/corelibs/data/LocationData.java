package com.gsmayya.corelibs.data;

/**
 * Created by gsmayya on 1/7/17.
 */


public class LocationData {


  private long _id; // Auto sequence id
  private long _startTime;
  private long _duration;

  //private Location location; //get gps coordinates as separate
  private long _lat;
  private long _longitude;

  public LocationData(long id, long startTime, long duration, long lat, long longitude) {
    _id = id;
    _startTime = startTime;
    _duration = duration;
    _lat = lat;
    _longitude = longitude;
  }

  public long getId() {
    return _id;
  }

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

  @Override
  public String toString() {
    return "ID: " + String.valueOf(_id)
        + " START TIME: " + String.valueOf(_startTime)
        + " DURATION " + String.valueOf(_duration)
        + " LATITUDE " + String.valueOf(_lat)
        + " LONGITUDE " + String.valueOf(_longitude);
  }
}

