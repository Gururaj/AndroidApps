package corelibs.schema;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gsmayya on 1/7/17.
 */

public class SchemaData implements Iterable<SchemaField> {
  // provide helpers and others for data tables.

  private final List<SchemaField> _tableSchema = new ArrayList<>();

  private final String _tableName;

  public SchemaData(String tableName) {
    _tableName = tableName;
  }

  public String getTableName() {
    return _tableName;
  }

  // TODO: currently no type checking.
  public void addField(String name, String type) {
    _tableSchema.add(new SchemaField(name, type));
  }

  @Override
  public Iterator<SchemaField> iterator() {
    return _tableSchema.iterator();
  }
}
