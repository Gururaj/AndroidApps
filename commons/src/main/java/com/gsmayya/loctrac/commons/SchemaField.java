package com.gsmayya.loctrac.commons;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Pair;

/**
 * Created by gsmayya on 1/7/17.
 */

@TargetApi(Build.VERSION_CODES.ECLAIR)
public class SchemaField extends Pair<String, String> {
  public SchemaField(String fieldName, String fieldType) {
    super(fieldName, fieldType);
  }

  public String getFieldName() {
    return first;
  }

  public String getFieldType() {
    return second;
  }
}
