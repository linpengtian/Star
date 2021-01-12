package com.jds.star;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

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
//        ScreenshotManager.INSTANCE.test(getApplicationContext());
    }

}
