package com.anysou.as_notification;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/***
 * 点击通知后启动的Activity。
 */
public class LaunchActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launch);
    }
}
