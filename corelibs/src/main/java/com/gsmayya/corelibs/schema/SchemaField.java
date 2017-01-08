package com.gsmayya.corelibs.schema;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by gsmayya on 1/7/17.
 */

public class SchemaField {

  private static Pair<String, String> _pair;

  public SchemaField(String fieldName, String fieldType) {
    _pair = new ImmutablePair<>(fieldName, fieldType);
  }

  public String getFieldName() {
    return _pair.getLeft();
  }

  public String getFieldType() {
    return _pair.getRight();
  }
}
