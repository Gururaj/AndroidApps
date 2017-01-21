package com.gsmayya.loctrac.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by gsmayya on 1/8/17.
 *
 * Not working
 */

public class BroadcastReceiverOnBoot extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
      Intent serviceIntent = new Intent(context, ServiceStartOnBoot.class);
      context.startService(serviceIntent);
    }
  }
}
