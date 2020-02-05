package com.anysou.as_notification;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


import static com.anysou.as_notification.NotificationService.ACTION_SEND_PROGRESS_NOTIFICATION;

/**Android 8.0中各种通知写法汇总
 * https://www.jianshu.com/p/6aec3656e274
 *
 * 注意：手机 设置 通知显示设置  选择 原生样式
 *
 * 实现 应用角标（未实现，待研究） https://www.cnblogs.com/whycxb/p/10081963.html
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "NotificationDemo";

    private Context mContext;
    private Button mSimple;
    private Button mAction;
    private Button mRemoteInput;
    private Button mBigPictureStyle;
    private Button mBigTextStyle;
    private Button mInboxStyle;
    private Button mMediaStyle;
    private Button mMessagingStyle;
    private Button mProgress;
    private Button mCustomHeadsUp;
    private Button mCustom;
    private Button mClearAll;

    private NotificationManager mNM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏标题栏
        setContentView(R.layout.activity_main);

        mContext = this;

        mNM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mSimple = findViewById(R.id.btn_simple);
        mAction = findViewById(R.id.btn_action);
        mRemoteInput = findViewById(R.id.btn_remote_input);
        mBigPictureStyle = findViewById(R.id.btn_big_picture_style);
        mBigTextStyle = findViewById(R.id.btn_big_text_style);
        mInboxStyle = findViewById(R.id.btn_inbox_style);
        mMediaStyle = findViewById(R.id.btn_media_style);
        mMessagingStyle = findViewById(R.id.btn_messaging_style);
        mProgress = findViewById(R.id.btn_progress);
        mCustomHeadsUp = findViewById(R.id.btn_custom_heads_up);
        mCustom = findViewById(R.id.btn_custom);
        mClearAll = findViewById(R.id.btn_clear_all);

        mSimple.setOnClickListener(this);
        mAction.setOnClickListener(this);
        mRemoteInput.setOnClickListener(this);
        mBigPictureStyle.setOnClickListener(this);
        mBigTextStyle.setOnClickListener(this);
        mInboxStyle.setOnClickListener(this);
        mMediaStyle.setOnClickListener(this);
        mMessagingStyle.setOnClickListener(this);
        mProgress.setOnClickListener(this);
        mCustomHeadsUp.setOnClickListener(this);
        mCustom.setOnClickListener(this);
        mClearAll.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simple:
                Notificaitons.getInstance().sendSimpleNotification(mContext,mNM);
                break;
            case R.id.btn_action:
                Notificaitons.getInstance().sendActionNotification(mContext,mNM);
                break;
            case R.id.btn_remote_input:
                Notificaitons.getInstance().sendRemoteInputNotification(mContext,mNM);
                break;
            case R.id.btn_big_picture_style:
                Notificaitons.getInstance().sendBigPictureStyleNotification(mContext,mNM);
                break;
            case R.id.btn_big_text_style:
                Notificaitons.getInstance().sendBigTextStyleNotification(mContext,mNM);
                break;
            case R.id.btn_inbox_style:
                Notificaitons.getInstance().sendInboxStyleNotification(mContext,mNM);
                break;
            case R.id.btn_media_style:
                Notificaitons.getInstance().sendMediaStyleNotification(mContext,mNM,false);
                break;
            case R.id.btn_messaging_style:
                Notificaitons.getInstance().sendMessagingStyleNotification(mContext,mNM);
                break;
            case R.id.btn_progress:
                Intent intent = new Intent(this,NotificationService.class);
                intent.setAction(ACTION_SEND_PROGRESS_NOTIFICATION);
                startService(intent);
                break;
            case R.id.btn_custom_heads_up:
                Notificaitons.getInstance().sendCustomHeadsUpViewNotification(mContext,mNM);
                break;
            case R.id.btn_custom:
                Notificaitons.getInstance().sendCustomViewNotification(
                        mContext,
                        mNM,
                        new NotificationContentWrapper(
                                BitmapFactory.decodeResource(mContext.getResources(),
                                        R.mipmap.custom_view_picture_current),
                                "最美的期待",
                                "周笔畅 - 最美的期待"),
                        false,
                        true);
                break;
            case R.id.btn_clear_all:
                Notificaitons.getInstance().clearAllNotification(mNM);
                break;
            default:
                //do nothing
        }
    }


    // 菜单

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
