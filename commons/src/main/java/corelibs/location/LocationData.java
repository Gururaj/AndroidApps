package corelibs.location;

import android.content.ContentValues;

import org.chalup.microorm.annotations.Column;

import com.gsmayya.commons.data.Data;
import corelibs.schema.SchemaData;
import corelibs.schema.SchemaType;

/**
 * Created by gsmayya on 1/7/17.
 */
public class LocationData implements Data {

  private static final String KEY_START_TIME = "start_time";
  private static final String TABLE_WDIG_LOCATION = "wdig_location_2";
  private static final String KEY_ID = "id";
  private static final String KEY_DURATION = "duration";
  private static final String KEY_LAT = "latitude";
  private static final String KEY_LONG = "longitude";

  /**
   *
   */
  static SchemaData schema = new SchemaData(LocationData.TABLE_WDIG_LOCATION, new LocationData());

  static {
    schema.addId(LocationData.KEY_ID, SchemaType.INT);
    schema.addField(LocationData.KEY_START_TIME, SchemaType.INT);
    schema.addField(LocationData.KEY_DURATION, SchemaType.INT);
    schema.addField(LocationData.KEY_LAT, SchemaType.DOUBLE);
    schema.addField(LocationData.KEY_LONG, SchemaType.DOUBLE);
  }

  @Column(LocationData.KEY_START_TIME)
  private long _startTime;

  @Column(LocationData.KEY_DURATION)
  private long _duration;

  //private Location location; //get gps coordinates as separate
  @Column(LocationData.KEY_LAT)
  private double _latitude;

  @Column(LocationData.KEY_LONG)
  private double _longitude;

  public long getStartTime() {
    return _startTime;
  }

  public long getDuration() {
    return _duration;
  }

  public double getLatitude() {
    return _latitude;
  }

  public double getLongitude() {
    return _longitude;
  }

  public void setStartTime(long startTime) {
    _startTime = startTime;
  }

  public void setDuration(long duration) {
    _duration = duration;
  }

  public void setLatitude(double latitude) {
    _latitude = latitude;
  }

  public void setLongitude(double longitude) {
    _longitude = longitude;
  }

  @Override
  public String toString() {
    return " START TIME: " + String.valueOf(_startTime)
        + " DURATION " + String.valueOf(_duration)
        + " LATITUDE " + String.valueOf(_latitude)
        + " LONGITUDE " + String.valueOf(_longitude);
  }

  @Override
  public ContentValues addRecord(long id) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(KEY_ID, id);
    contentValues.put(KEY_START_TIME, getStartTime());
    contentValues.put(KEY_DURATION, getDuration());
    contentValues.put(KEY_LAT, getLatitude());
    contentValues.put(KEY_LONG, getLongitude());
    return contentValues;
  }
}

