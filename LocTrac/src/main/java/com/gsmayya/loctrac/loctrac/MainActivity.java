package com.gsmayya.loctrac.loctrac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import corelibs.data.LocationData;
import com.gsmayya.commons.loctrac.LocationDatabase;
import com.gsmayya.commons.loctrac.MockingUtils;
import com.gsmayya.loctrac.service.ServiceStartOnBoot;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);

    LocationDatabase locationDatabase = new LocationDatabase(this);

    Intent serviceIntent = new Intent(this, ServiceStartOnBoot.class);
    this.startService(serviceIntent);
    // hacky method for now.
    mockAddData(locationDatabase);
    List<String> values = locationDatabase.getValues();

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
        this,
        android.R.layout.simple_list_item_1,
        android.R.id.text1,
        values
    );

    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        int itemPosition = position;
        String itemValue = (String) listView.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(),
            "Position " + itemPosition + " List Item " + itemValue, Toast.LENGTH_LONG)
            .show();
      }
    });
  }

  private void mockAddData(LocationDatabase locationDatabase) {
    for (LocationData locationData :  MockingUtils.getLocationData()) {
      locationDatabase.addRecord(locationData);
    }
  }
}
