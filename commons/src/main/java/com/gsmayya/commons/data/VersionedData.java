package com.gsmayya.commons.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import corelibs.schema.SchemaData;
import corelibs.schema.SchemaField;

/**
 * Created by gsmayya on 1/7/17.
 */

public abstract class VersionedData {
  private SchemaData _schema;
  private final VersionedHelper _versionedHelper;

  public VersionedData(Context context, SchemaData schema) {
    _schema = schema;
    _versionedHelper = new VersionedHelper(context, getCreateSql(), _schema.getTableName());

  }

  protected String getCreateSql() {
    return "CREATE TABLE " + _schema.getTableName().toUpperCase() + "(" +
        generateColumns() + ")";
  }

  private String generateColumns() {
    // assumes first field is primary key (currenlty thats all we keep, later we can do)
    boolean firstColumn = true;
    StringBuffer sb = new StringBuffer();
    for (SchemaField schemaField : _schema) {
      sb.append(schemaField.getFieldName().toUpperCase());
      sb.append(" ");
      sb.append(schemaField.getFieldType().toUpperCase());
      if (firstColumn) {
        sb.append(" PRIMARY KEY ");
        firstColumn = false;
      }
      sb.append(",");
    }
    // remove last one since that is a , ;; idiotic way to get that in
    return sb.substring(0, sb.length() - 1);
  }

  public void addRecord(ContentValues contentValues) {
    SQLiteDatabase sqLiteDatabase =  _versionedHelper.getWritableDatabase();
    sqLiteDatabase.insert(_schema.getTableName(), null, contentValues);
    sqLiteDatabase.close();
  }



  public SchemaData getSchema() {
    return _schema;
  }

}