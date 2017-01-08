package com.gsmayya.loctrac.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by gsmayya on 1/8/17.
 */

public class ServiceStartOnBoot extends Service {

  private static final String SERVICE = "SERVICETAG";

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    Log.i(SERVICE, "Service running..");
    return null;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Log.i(SERVICE, "Service running..");
  }
}
