package com.gsmayya.loctrac.loctrac;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import corelibs.listener.ListViewListener;
import corelibs.location.LocationData;

/**
 * Created by gsmayya on 1/21/17.
 */

public class LocationListViewAdapter extends ListViewListener<LocationData> {

  TextView txtTimeStamp;
  TextView txtDuration;
  TextView txtLatitude;
  TextView txtLongitude;

  public LocationListViewAdapter(Activity activity,
                                 List<LocationData> list) {
    super(list, activity);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = getActivity().getLayoutInflater();
    LocationData locationData = getList().get(position);

    if (convertView == null) {
      convertView = inflater.inflate(R.layout.column_row, null);
      txtTimeStamp = (TextView) convertView.findViewById(R.id.timestamp);
      txtDuration = (TextView) convertView.findViewById(R.id.duration);
      txtLatitude = (TextView) convertView.findViewById(R.id.latitude);
      txtLongitude = (TextView) convertView.findViewById(R.id.longitude);
    }

    txtTimeStamp.setText(String.valueOf(locationData.getStartTime()));
    txtDuration.setText(String.valueOf(locationData.getDuration()));
    txtLatitude.setText(String.valueOf(locationData.getLatitude()));
    txtLongitude.setText(String.valueOf(locationData.getLongitude()));

    return convertView;
  }

  @Override
  public void fillTextViews(int position) {
    LocationData locationData = getList().get(position);
    txtTimeStamp.setText(String.valueOf(locationData.getStartTime()));
    txtDuration.setText(String.valueOf(locationData.getDuration()));
    txtLatitude.setText(String.valueOf(locationData.getLatitude()));
    txtLongitude.setText(String.valueOf(locationData.getLongitude()));
  }

  @Override
  public View populateTextViews(LayoutInflater inflater) {
    View convertView = inflater.inflate(R.layout.column_row, null);
    txtTimeStamp = (TextView) convertView.findViewById(R.id.timestamp);
    txtDuration = (TextView) convertView.findViewById(R.id.duration);
    txtLatitude = (TextView) convertView.findViewById(R.id.latitude);
    txtLongitude = (TextView) convertView.findViewById(R.id.longitude);
    return convertView;
  }
}
