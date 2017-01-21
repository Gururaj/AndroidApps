package corelibs.schema;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gsmayya.commons.data.Data;

/**
 * Created by gsmayya on 1/7/17.
 */
public class SchemaData implements Iterable<SchemaField> {
  // provide helpers and others for data tables.

  private final List<SchemaField> _tableSchema = new ArrayList<>();
  private Data _data;

  private final String _tableName;
  private SchemaField _idField = null;

  /**
   *
   * @param tableName
   * @param data
   */
  public SchemaData(String tableName, Data data) {
    _tableName = tableName.toUpperCase().trim();
    _data = data;
  }

  /**
   *
   * @return
   */
  public Class getData() {
    return _data.getClass();
  }

  /**
   *
   * @return
   */
  public String getTableName() {
    return _tableName;
  }

  /**
   *
   * @return
   */
  public boolean isComplete() {
    return StringUtils.isNotBlank(_tableName) && _idField != null;
  }

  /**
   *
   * @param name
   * @param type
   */
  public void addField(String name, SchemaType type) {
    addField(new SchemaField(name, type));
  }

  /**
   *
   * @param name
   * @param type
   */
  public void addId(String name, SchemaType type) {
    _idField = new SchemaField(name, type, true);
    addField(_idField);
  }

  /**
   *
   * @param schemaField
   */
  private void addField(SchemaField schemaField) {
    _tableSchema.add(schemaField);
  }

  /**
   *
   * @return
   */
  public SchemaField getIdField() {
    return _idField;
  }

  /**
   *
   * @return
   */
  @Override
  public Iterator<SchemaField> iterator() {
    return _tableSchema.iterator();
  }

  /**
   *
   * @return
   */
  public List<String> getDBCreateColumns() {
    List<String> columns = new ArrayList<>();
    for (SchemaField field : _tableSchema) {
      columns.add(field.getDBCreate());
    }
    return columns;
  }

  /**
   *
   * @return
   */
  public List<String> getColumns() {
    List<String> columns = new ArrayList<>();
    for (SchemaField field : _tableSchema) {
      columns.add(field.getFieldName());
    }
    return columns;
  }

}
