package com.gsmayya.commons.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import corelibs.schema.SchemaData;

/**
 * Created by gsmayya on 1/7/17.
 * Abstract class for having common code around sepcifics databases (tables)
 */

public abstract class Database {
  private SchemaData _schema;
  private final SQLHelper _versionedHelper;

  /**
   *
   * @param context
   * @param schema
   */
  public Database(Context context, SchemaData schema) {
    _schema = schema;
    _versionedHelper = new SQLHelper(context, _schema);
  }

  /**
   *
   * @return Get list of rows from database
   */
  protected List<Data> getRows() {
    return _versionedHelper.getRowList();
  }

  /**
   *
   * @return Next id from the database
   */
  public long getNextId() {
    return _versionedHelper.getNextId();
  }

  /**
   *
   * @param contentValues
   */
  public void addRecord(ContentValues contentValues) {
    SQLiteDatabase sqLiteDatabase =  _versionedHelper.getWritableDatabase();
    sqLiteDatabase.insert(_schema.getTableName(), null, contentValues);
    sqLiteDatabase.close();
  }

  /**
   *
   * @param data
   */
  public void addRecord(Data data) {
    addRecord(data.addRecord(getNextId()));
  }
}