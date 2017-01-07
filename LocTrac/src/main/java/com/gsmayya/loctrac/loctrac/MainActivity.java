package com.gsmayya.loctrac.loctrac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gsmayya.corelibs.LocationData;
import com.gsmayya.loctrac.commons.LocationDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);

    LocationDatabase locationDatabase = new LocationDatabase(this);

    for (LocationData locationData : LocationDatabase.getLocationData()) {
      locationDatabase.addRecord(locationData);
    }

    // hacky method for now.
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
}