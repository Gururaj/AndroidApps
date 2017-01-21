package corelibs.location;

import android.content.Context;

import com.gsmayya.commons.data.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gsmayya.commons.data.Data;

import static corelibs.location.LocationData.schema;

/**
 * Created by gsmayya on 1/7/17.
 */
public class LocationDatabase extends Database implements Serializable {

  public LocationDatabase(Context context) {
    super(context, schema);
  }

  public List<LocationData> getValues() {
    List<LocationData> values = new ArrayList<>();
    for (Data locationData : getRows()) {
      values.add((LocationData) locationData);
    }
    return values;
  }

}
