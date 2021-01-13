package com.jds.star;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartAppOnBootReceiver extends BroadcastReceiver {

    public StartAppOnBootReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("======", "=====" + intent.getAction() + "=======");
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()) ||
            Intent.ACTION_LOCKED_BOOT_COMPLETED.equals(intent.getAction()) ||
                Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {

            Log.e("========", "=====System booted=====");

            Intent serviceIntent = new Intent(context, MainActivity.class);
            serviceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            Intent serviceIntent = new Intent(context, MyService.class);
            context.startActivity(serviceIntent);
        }

    }
}