package com.anysou.as_notification;

import android.graphics.Bitmap;

/***
 * 封装的通知数据结构体，通过一个对象传递所有相关数据。
 */
public class NotificationContentWrapper {
    public Bitmap bitmap;
    public String title;
    public String summery;

    public NotificationContentWrapper(Bitmap bitmap, String title, String summery) {
        this.bitmap = bitmap;
        this.title = title;
        this.summery = summery;
    }
}
