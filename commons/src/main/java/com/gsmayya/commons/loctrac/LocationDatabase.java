package com.gsmayya.commons.loctrac;

import android.content.ContentValues;
import android.content.Context;

import com.gsmayya.corelibs.data.LocationData;
import com.gsmayya.commons.data.VersionedData;

import java.util.ArrayList;
import java.util.List;

import static com.gsmayya.commons.loctrac.MockingUtils.KEY_DURATION;
import static com.gsmayya.commons.loctrac.MockingUtils.KEY_ID;
import static com.gsmayya.commons.loctrac.MockingUtils.KEY_LAT;
import static com.gsmayya.commons.loctrac.MockingUtils.KEY_LONG;
import static com.gsmayya.commons.loctrac.MockingUtils.KEY_START_TIME;
import static com.gsmayya.commons.loctrac.MockingUtils.schema;

/**
 * Created by gsmayya on 1/7/17.
 */
public class LocationDatabase extends VersionedData {

  private List<LocationData> _dataList = new ArrayList<>();

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
