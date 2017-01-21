package com.gsmayya.loctrac.loctrac;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import corelibs.location.LocationData;
import corelibs.location.LocationDatabase;
import corelibs.listener.MyLocationListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  private static final String ACTIVITY = "MAIN";

  ListView listView;
  LocationDatabase locationDatabase;
  MyLocationListener myListener;
  LocationListViewAdapter _adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);
    // setup database
    locationDatabase = new LocationDatabase(this);
    // set up location
    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

    // get current list of values
    List<LocationData> values = locationDatabase.getValues();

    // need to create column list
    _adapter = new LocationListViewAdapter(this, values);

    listView.setAdapter(_adapter);

    myListener = new LocTracLocationListener(locationDatabase, _adapter);
    setLocationManager(locationManager, myListener);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        LocationData itemValue = (LocationData) listView.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(),
            itemValue + " Clicked", Toast.LENGTH_SHORT)
            .show();
      }
    });
  }

  private void setLocationManager(LocationManager locationManager, LocationListener locationListener) {
    // long minTime = 10 * 60 * 1000;
    long minTime = 6 * 1000;
    long minDistance = 0;

    if (ActivityCompat.checkSelfPermission(this,
        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      Log.i(ACTIVITY, "Permissions not available. Should find out to request");
      return;
    }
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, locationListener);
  }

}
