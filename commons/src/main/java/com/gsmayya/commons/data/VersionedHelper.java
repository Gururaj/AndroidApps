package com.gsmayya.commons.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gsmayya on 1/7/17.
 */

public class VersionedHelper extends SQLiteOpenHelper {

  private static final String TAG = VersionedHelper.class.getName();

  // Database Version
  private static final int DATABASE_VERSION = 1;
  // Database Name
  private static final String DATABASE_NAME = "wdig";

  private final String _createTable;
  private final String _tableName;

  public VersionedHelper(Context context, String createSql, String tableName) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    Log.i(DATABASE_NAME, createSql);
    _createTable = createSql;
    _tableName = tableName;
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    Log.i(TAG, _createTable);
    sqLiteDatabase.execSQL(_createTable);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    Log.i(TAG, _tableName);
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + _tableName);
    onCreate(sqLiteDatabase);
  }
}
