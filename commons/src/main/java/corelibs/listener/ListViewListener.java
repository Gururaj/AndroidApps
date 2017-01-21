package corelibs.listener;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import corelibs.location.LocationData;

/**
 * Created by gsmayya on 1/21/17.
 */

public abstract class ListViewListener<T> extends BaseAdapter {

  private List<T> _list;
  Activity _activity;

  public ListViewListener(List<T> list, Activity activity) {
    _list = list;
    _activity = activity;
  }

  public List<T> getList() {
    return _list;
  }

  public Activity getActivity() {
    return _activity;
  }

  @Override
  public int getCount() {
    return _list.size();
  }

  @Override
  public Object getItem(int position) {
    return _list.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = getActivity().getLayoutInflater();
    if (convertView == null) {
      convertView = populateTextViews(inflater);
    }
    fillTextViews(position);
    return convertView;
  }

  public abstract void fillTextViews(int position);

  public abstract View populateTextViews(LayoutInflater inflater);

  public void add(T value) {
    _list.add(value);
  }
}
