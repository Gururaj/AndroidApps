package corelibs.schema;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.validation.Schema;

import corelibs.data.Data;

/**
 * Created by gsmayya on 1/7/17.
 */

public class SchemaData implements Iterable<SchemaField> {
  // provide helpers and others for data tables.

  private final List<SchemaField> _tableSchema = new ArrayList<>();
  private Data _data;

  private final String _tableName;
  private SchemaField _idField = null;

  public SchemaData(String tableName, Data data) {
    _tableName = tableName.toUpperCase().trim();
    _data = data;
  }

  public Class getData() {
    return _data.getClass();
  }

  public String getTableName() {
    return _tableName;
  }

  public boolean isComplete() {
    return StringUtils.isNotBlank(_tableName) && _idField != null;
  }

  // TODO: currently no type checking.
  public void addField(String name, SchemaType type) {
    addField(new SchemaField(name, type));
  }

  public void addId(String name, SchemaType type) {
    _idField = new SchemaField(name, type, true);
    addField(_idField);
  }

  private void addField(SchemaField schemaField) {
    _tableSchema.add(schemaField);
  }

  public SchemaField getIdField() {
    return _idField;
  }

  @Override
  public Iterator<SchemaField> iterator() {
    return _tableSchema.iterator();
  }

  public List<String> getDBCreateColumns() {
    List<String> columns = new ArrayList<>();
    for (SchemaField field : _tableSchema) {
      columns.add(field.getDBCreate());
    }
    return columns;
  }

  public List<String> getColumns() {
    List<String> columns = new ArrayList<>();
    for (SchemaField field : _tableSchema) {
      columns.add(field.getFieldName());
    }
    return columns;
  }

}
