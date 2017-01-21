package corelibs.schema;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by gsmayya on 1/7/17.
 */
public class SchemaField {

  private Pair<String, SchemaType> _pair;
  private boolean _isId;

  /**
   *
   * @param fieldName
   * @param fieldType
   */
  public SchemaField(String fieldName, SchemaType fieldType) {
    this(fieldName, fieldType, false);
  }

  /**
   *
   * @param fieldName
   * @param fieldType
   * @param isId
   */
  public SchemaField(String fieldName, SchemaType fieldType, boolean isId) {
    _pair = new ImmutablePair<>(fieldName, fieldType);
    _isId = isId;
  }

  /**
   *
   * @return
   */
  public boolean isId() {
    return _isId;
  }

  /**
   *
   * @return
   */
  public String getFieldName() {
    return _pair.getLeft();
  }

  /**
   *
   * @return
   */
  public SchemaType getFieldType() {
    return _pair.getRight();
  }

  /**
   *
   * @return
   */
  private String internalDBCreate() {
    return getFieldName() + " " + getFieldType().getDbTypeName();
  }

  /**
   *
   * @return
   */
  public String getDBCreate() {
    return (_isId)? internalDBCreate() + " PRIMARY KEY":internalDBCreate();
  }
}
