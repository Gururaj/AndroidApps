package corelibs.schema;

/**
 * Created by gsmayya on 1/21/17.
 */

public enum SchemaType {
  INT("integer"),
  STRING("string");

  private final String _dbTypeName;

  SchemaType(String dbTypeName) {
    _dbTypeName = dbTypeName.toUpperCase().trim();
  }

  public String getDbTypeName() {
    return _dbTypeName;
  }

}
