package corelibs.listener;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.gsmayya.commons.data.Database;

import java.io.Serializable;

import com.gsmayya.commons.data.Data;

/**
 * Created by gsmayya on 1/21/17.
 */

public abstract class MyLocationListener implements LocationListener, Serializable {
  private static final String TAG = "LISTENER";
  private final Database _database;
  private final ListViewListener _adapter;

  public MyLocationListener(Database database, ListViewListener adapter) {
    _database = database;
    _adapter = adapter;
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {
  }

  @Override
  public void onProviderEnabled(String provider) {
  }

  @Override
  public void onProviderDisabled(String provider) {
  }

  @Override
  public void onLocationChanged(Location location) {
    Log.i(TAG, location.toString());
    _adapter.add(getData(location));
    _adapter.notifyDataSetChanged();
  }

  public Database getDatabase() {
    return _database;
  }

  public abstract Data getData(Location location);
}
