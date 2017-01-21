package com.gsmayya.loctrac.loctrac;

import android.location.Location;

import com.gsmayya.commons.data.Data;
import corelibs.listener.ListViewListener;
import corelibs.location.LocationData;
import corelibs.location.LocationDatabase;
import corelibs.listener.MyLocationListener;

/**
 * Created by gsmayya on 1/21/17.
 */

public class LocTracLocationListener extends MyLocationListener {
  public LocTracLocationListener(LocationDatabase locationDatabase, ListViewListener adapter) {
    super(locationDatabase, adapter);
  }

  @Override
  public Data getData(Location location) {
    LocationData locationData = new LocationData();
    long currentTime = System.currentTimeMillis();
    locationData.setStartTime(currentTime);
    locationData.setDuration(location.getElapsedRealtimeNanos() / (1000 * 1000 * 1000));
    locationData.setLongitude(location.getLongitude());
    locationData.setLatitude(location.getLatitude());
    getDatabase().addRecord(locationData);
    return locationData;
  }
}
