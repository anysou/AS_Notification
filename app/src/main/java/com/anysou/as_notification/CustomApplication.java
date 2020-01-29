package com.anysou.as_notification;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

/***
 * 在应用启动后一次性创建所有需要的 NotificationChannel。
 */
public class CustomApplication extends Application {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();

        NotificationChannels.createAllNotificationChannels(this);
    }
}
