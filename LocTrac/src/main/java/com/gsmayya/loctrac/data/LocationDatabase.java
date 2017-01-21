package com.gsmayya.loctrac.data;

import android.content.ContentValues;
import android.content.Context;

import corelibs.data.Data;

import com.gsmayya.commons.data.Database;

import java.util.ArrayList;
import java.util.List;

import static com.gsmayya.loctrac.data.LocationData.schema;

/**
 * Created by gsmayya on 1/7/17.
 */
public class LocationDatabase extends Database {

  public LocationDatabase(Context context) {
    super(context, schema);
  }

  public void addRecord(LocationData locationData) {
    addRecord(locationData.addRecord(getNextId()));
  }

  public List<String> getValues() {
    List<String> values = new ArrayList<>();
    for (Data locationData : getRows()) {
      values.add(locationData.toString());
    }
    return values;
  }

}
