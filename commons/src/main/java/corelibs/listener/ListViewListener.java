package corelibs.listener;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 *
 * @param <T> Type of parameter
 */
public abstract class ListViewListener<T> extends BaseAdapter {

  /**
   *
   */
  private List<T> typeList;
  /**
   *
   */
  private Activity activity;

  /**
   *
   * @param list List
   * @param a Activity
   */
  public ListViewListener(final List<T> list, final Activity a) {
    this.typeList = list;
    this.activity = a;
  }

  /**
   *
   * @return Lists
   */
  public List<T> getTypeList() {
    return typeList;
  }

  /**
   *
   * @return Activity
   */
  public Activity getActivity() {
    return activity;
  }

  /**
   *
   * @return Count
   */
  @Override
  public int getCount() {
    return typeList.size();
  }

  /**
   *
   * @param position Integer
   * @return Object
   */
  @Override
  public Object getItem(final int position) {
    return typeList.get(position);
  }

  /**
   *
   * @param position Integer
   * @return Item Id
   */
  @Override
  public long getItemId(final int position) {
    return 0;
  }

  /**
   *
   * @param position Position
   * @param convertView Converted view
   * @param parent Parent group
   * @return ConvertedView
   */
  @Override
  public View getView(final int position, View convertView, final ViewGroup parent) {
    LayoutInflater inflater = getActivity().getLayoutInflater();
    if (convertView == null) {
      convertView = populateTextViews(inflater);
    }
    fillTextViews(position);
    return convertView;
  }

  /**
   *
   * @param position Position
   */
  public abstract void fillTextViews(int position);

  /**
   *
   * @param inflater Infalter
   * @return CreatedView
   */
  public abstract View populateTextViews(LayoutInflater inflater);

  /**
   *
   * @param value Value to add
   */
  public void add(final T value) {
    typeList.add(value);
  }
}
