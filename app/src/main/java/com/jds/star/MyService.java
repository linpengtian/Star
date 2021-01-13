package com.jds.star;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {

    @Override
    public void onCreate() {
        Log.e("service", "====Service created.====");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service", "====Service started by user.====");
        Toast.makeText(this, "Service started by user.", Toast.LENGTH_SHORT).show();

        takeScreenshot();

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "==== Service destroyed by user. ====");
        Toast.makeText(this, "Service destroyed by user.", Toast.LENGTH_LONG).show();
    }

    private void takeScreenshot() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                ScreenshotManager.INSTANCE.test(getApplicationContext());
            }

        }, 3000, 60000);
    }

}
