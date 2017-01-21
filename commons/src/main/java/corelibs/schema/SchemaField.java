package corelibs.schema;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by gsmayya on 1/7/17.
 */

public class SchemaField {

  private Pair<String, SchemaType> _pair;
  private boolean _isId;

  public SchemaField(String fieldName, SchemaType fieldType) {
    this(fieldName, fieldType, false);
  }

  public SchemaField(String fieldName, SchemaType fieldType, boolean isId) {
    _pair = new ImmutablePair<>(fieldName, fieldType);
    _isId = isId;
  }

  public boolean isId() {
    return _isId;
  }

  public String getFieldName() {
    return _pair.getLeft();
  }

  public SchemaType getFieldType() {
    return _pair.getRight();
  }

  private String internalDBCreate() {
    return getFieldName() + " " + getFieldType().getDbTypeName();
  }

  public String getDBCreate() {
    return (_isId)? internalDBCreate() + " PRIMARY KEY":internalDBCreate();
  }
}
