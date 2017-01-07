package com.gsmayya.loctrac.commons;

import android.content.ContentValues;
import android.content.Context;

import com.gsmayya.corelibs.LocationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gsmayya on 1/7/17.
 */
public class LocationDatabase extends VersionedData {

  private static final String TABLE_WDIG_LOCATION = "wdig_location";
  private static final String KEY_ID = "id";
  private static final String KEY_START_TIME = "start_time";
  private static final String KEY_DURATION = "duration";
  private static final String KEY_LAT = "latitude";
  private static final String KEY_LONG = "longitude";

  private static SchemaData schema = new SchemaData(TABLE_WDIG_LOCATION);

  static {
    schema.addField(KEY_ID, "integer");
    schema.addField(KEY_START_TIME, "integer");
    schema.addField(KEY_DURATION, "integer");
    schema.addField(KEY_LAT, "integer");
    schema.addField(KEY_LONG, "integer");
  }

  private List<LocationData> _dataList = new ArrayList<>();

  public static List<LocationData> getLocationData() {
    List<LocationData> locationDataList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      LocationData locationData = new LocationData(i,
          System.currentTimeMillis(),
          10,
          i * new Random().nextInt(),
          i * new Random().nextInt());
      locationDataList.add(locationData);
    }
    return locationDataList;
  }

  public LocationDatabase(Context context) {
    super(context, schema);
  }

  public void addRecord(LocationData locationData) {
    _dataList.add(locationData);
    ContentValues contentValues = new ContentValues();
    contentValues.put(KEY_ID, locationData.getId());
    contentValues.put(KEY_START_TIME, locationData.getStartTime());
    contentValues.put(KEY_DURATION, locationData.getDuration());
    contentValues.put(KEY_LAT, locationData.getLat());
    contentValues.put(KEY_LONG, locationData.getLongitude());
    addRecord(contentValues);
  }

  public List<String> getValues() {
//        _dataList
//                .stream()
//                .map(s -> s.getValue())
//                .collect(toList());
    List<String> values = new ArrayList<>();
    for (LocationData locationData : _dataList) {
      values.add(locationData.toString());
    }
    return values;
  }

}
