package corelibs.data;

/**
 * Created by gsmayya on 1/7/17.
 */


public class LocationData {

  private long _startTime;
  private long _duration;

  //private Location location; //get gps coordinates as separate
  private long _lat;
  private long _longitude;

  public LocationData(long startTime, long duration, long lat, long longitude) {
    _startTime = startTime;
    _duration = duration;
    _lat = lat;
    _longitude = longitude;
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
    return " START TIME: " + String.valueOf(_startTime)
        + " DURATION " + String.valueOf(_duration)
        + " LATITUDE " + String.valueOf(_lat)
        + " LONGITUDE " + String.valueOf(_longitude);
  }
}
