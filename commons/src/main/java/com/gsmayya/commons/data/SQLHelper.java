package com.gsmayya.commons.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.common.base.Joiner;

import org.chalup.microorm.MicroOrm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import corelibs.schema.SchemaData;
import corelibs.schema.SchemaField;

/**
 * Created by gsmayya on 1/7/17.
 */
class SQLHelper extends SQLiteOpenHelper {

  private static final String TAG = "SQLHELPER";

  // Database Version
  private static final int DATABASE_VERSION = 1;
  // Database Name
  private static final String DATABASE_NAME = "wdig";

  private final String _tableName;
  private final AtomicLong _id;
  private final SchemaField _idColumn;
  private final SchemaData _schema;

  /**
   *
   * @param context
   * @param schema
   */
  SQLHelper(Context context, SchemaData schema) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    _schema = schema;
    _tableName = _schema.getTableName();
    _idColumn = schema.getIdField();
    _id = new AtomicLong(getMaxIdFromDB(getReadableDatabase(), getMaxSql()));
  }

  /**
   *
   * @return
   */
  long getNextId() {
    return _id.incrementAndGet();
  }

  /**
   *
   * @return
   */
  List<Data> getRowList() {
    String sql = "select "
        + Joiner.on(",").join(_schema.getColumns())
        + " from " + _tableName;
    List<Data> datas = new ArrayList<>();
    Log.i(TAG, "Row request sql " + sql);
    MicroOrm orm = new MicroOrm();

    try (Cursor cursor = getReadableDatabase().rawQuery(sql, null)) {
      datas = orm.listFromCursor(cursor, _schema.getData());
    } catch (Exception e) {
      Log.e("Error", "Cannot get rows from table ", e);
    }
    return datas;
  }

  /**
   *
   * @param db
   * @param maxSql
   * @return
   */
  private long getMaxIdFromDB(SQLiteDatabase db, String maxSql) {
    Log.i(TAG, "MaxId request sql " + maxSql);
    try (Cursor cursor = db.rawQuery(maxSql, null)) {
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        long max = cursor.getInt(cursor.getColumnIndex(_idColumn.getFieldName()));
        if (max > 0) {
          return max;
        }
      }
    } catch (Exception e) {
      Log.e("Error", "Cannot get max from table ", e);
    }
    return 0;
  }

  /**
   *
   * @param sqLiteDatabase
   */
  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    Log.i(TAG, "Create sql " + getCreateSql());
    sqLiteDatabase.execSQL(getCreateSql());
  }

  /**
   *
   * @param sqLiteDatabase
   * @param i
   * @param i1
   */
  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    Log.i(TAG, "Update sql " + _tableName);
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + _tableName);
    onCreate(sqLiteDatabase);
  }

  /**
   *
   * @return
   */
  private String getMaxSql() {
    return "SELECT MAX("
        + _idColumn.getFieldName()
        + ") as "
        + _idColumn.getFieldName()
        + " from " + _tableName;
  }

  /**
   *
   * @return
   */
  private String getCreateSql() {
    return "CREATE TABLE " + _tableName + "("
        + Joiner.on(",").join(_schema.getDBCreateColumns())
        + ")";
  }

}
