package com.gsmayya.commons.loctrac;

import com.gsmayya.corelibs.data.LocationData;
import com.gsmayya.corelibs.schema.SchemaData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gsmayya on 1/8/17.
 */

public class MockingUtils {

  public static final String TABLE_WDIG_LOCATION = "wdig_location";
  public static final String KEY_ID = "id";
  public static final String KEY_START_TIME = "start_time";
  public static final String KEY_DURATION = "duration";
  public static final String KEY_LAT = "latitude";
  public static final String KEY_LONG = "longitude";

  public static SchemaData schema = new SchemaData(TABLE_WDIG_LOCATION);

  static {
    schema.addField(KEY_ID, "integer");
    schema.addField(KEY_START_TIME, "integer");
    schema.addField(KEY_DURATION, "integer");
    schema.addField(KEY_LAT, "integer");
    schema.addField(KEY_LONG, "integer");
  }

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
}
