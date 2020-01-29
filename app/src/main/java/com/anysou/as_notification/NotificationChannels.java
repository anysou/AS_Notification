package com.anysou.as_notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;

/***
 * 建立 所有等级的 通知渠道
 *
 * 把demo中用到的所有NotificationChannel封装到一个方法里面，在应用启动的时候一次性创建。
 *
 * 在Android O版本中，发送通知的时候必须要为通知设置通知渠道，否则通知不会被发送。
 */

public class NotificationChannels {

    public final static String CRITICAL = "critical";
    public final static String IMPORTANCE = "importance";
    public final static String DEFAULT = "default";
    public final static String LOW = "low";
    public final static String MEDIA = "media";

    //API 26    android 8.0 Oreo    奥利奥
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createAllNotificationChannels(Context context) {

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(nm == null) {
            return;
        }

        // 创建一个通知渠道至少需要渠道ID、渠道名称以及重要等级这三个参数，
        // 其中渠道ID可以随便定义，只要保证全局唯一性就可以。
        // 渠道名称是给用户看的，需要能够表达清楚这个渠道的用途。
        // 重要等级的不同则会决定通知的不同行为，当然这里只是初始状态下的重要等级，用户可以随时手动更改某个渠道的重要等级，App是无法干预的

        NotificationChannel mediaChannel = new NotificationChannel(
                MEDIA,
                context.getString(R.string.channel_media),
                NotificationManager.IMPORTANCE_DEFAULT);
        // 配置通知渠道的属性
        mediaChannel.setDescription("这是一个中级事件");
        // 设置通知出现时声音，默认通知是有声音的
        mediaChannel.setSound(null,null);
        // 设置通知出现时的闪灯（如果 android 设备支持的话）
        mediaChannel.enableLights(true);
        mediaChannel.setLightColor(Color.RED);
        // 设置通知出现时的震动（如果 android 设备支持的话）
        mediaChannel.enableVibration(true);
        mediaChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});


        nm.createNotificationChannels(Arrays.asList(
                new NotificationChannel(
                        CRITICAL,
                        context.getString(R.string.channel_critical),
                        NotificationManager.IMPORTANCE_HIGH),
                new NotificationChannel(
                        IMPORTANCE,
                        context.getString(R.string.channel_importance),
                        NotificationManager.IMPORTANCE_DEFAULT),
                new NotificationChannel(
                        DEFAULT,
                        context.getString(R.string.channel_default),
                        NotificationManager.IMPORTANCE_LOW),
                new NotificationChannel(
                        LOW,
                        context.getString(R.string.channel_low),
                        NotificationManager.IMPORTANCE_MIN),
                //custom notification channel
                mediaChannel
        ));

    }
}
