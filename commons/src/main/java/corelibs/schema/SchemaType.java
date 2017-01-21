package corelibs.schema;

/**
 * Created by gsmayya on 1/21/17.
 */
public enum SchemaType {
  INT("integer"),
  STRING("string"),
  DOUBLE("real");

  private final String _dbTypeName;

  /**
   *
   * @param dbTypeName
   */
  SchemaType(String dbTypeName) {
    _dbTypeName = dbTypeName.toUpperCase().trim();
  }

  /**
   *
   * @return
   */
  public String getDbTypeName() {
    return _dbTypeName;
  }

}
