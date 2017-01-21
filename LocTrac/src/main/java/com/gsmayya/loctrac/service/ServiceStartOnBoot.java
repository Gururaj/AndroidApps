package com.gsmayya.loctrac.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by gsmayya on 1/8/17.
 *
 * Not working
 */

public class ServiceStartOnBoot extends Service {

  private static final String SERVICE = "SERVICETAG";

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Toast.makeText(this, "Service starting", Toast.LENGTH_SHORT).show();
    return super.onStartCommand(intent, flags, startId);
  }

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
