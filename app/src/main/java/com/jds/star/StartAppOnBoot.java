package com.jds.star;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartAppOnBoot extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        try {
            final PendingResult pendingResult = goAsync();
            Thread.sleep(1000); pendingResult.finish();
            Intent activityIntent = new Intent(context, MyService.class);
            activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(activityIntent);
        } catch (Exception ex) {
            Log.e("==================", ex.getMessage());
        }

//        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
//            Log.e("========", "=====System booted=====");
//
//            Intent serviceIntent = new Intent(context, MainActivity.class);
//            serviceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////            Intent serviceIntent = new Intent(context, MyService.class);
//            context.startActivity(serviceIntent);
//        }

    }
}