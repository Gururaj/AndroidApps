package com.gsmayya.commons.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import corelibs.data.Data;
import corelibs.schema.SchemaData;

/**
 * Created by gsmayya on 1/7/17.
 *
 * This is totally screwed up logic between this and VersionaedHelper. Should have only one standard class outside
 * Just have to plugin implementation ..
 *
 * DataBaseHelper helper = new Helper(DatabaseImpl);
 *
 * helper.add etc
 */

public abstract class Database {
  private SchemaData _schema;
  private final SQLHelper _versionedHelper;

  public Database(Context context, SchemaData schema) {
    _schema = schema;
    _versionedHelper = new SQLHelper(context, _schema);
  }

  protected List<Data> getRows() {
    return _versionedHelper.getRowList();
  }

  public long getNextId() {
    return _versionedHelper.getNextId();
  }

  public void addRecord(ContentValues contentValues) {
    SQLiteDatabase sqLiteDatabase =  _versionedHelper.getWritableDatabase();
    sqLiteDatabase.insert(_schema.getTableName(), null, contentValues);
    sqLiteDatabase.close();
  }


}