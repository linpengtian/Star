package com.jds.star;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.e("========", "=====System booted=====");
            Intent serviceIntent = new Intent(context, MainActivity.class);
            serviceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            Intent serviceIntent = new Intent(context, MyService.class);
            context.startService(serviceIntent);
        }

    }
}