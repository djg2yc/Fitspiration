package com.example.hulagirl.fitspiration;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;

public class EndButton extends AppCompatActivity {
   private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int notification_id;
    private RemoteViews remoteViews;
    private Context context;

    TextView mTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_button);

        final View someView = findViewById(R.id.background);
        final View root = someView.getRootView();


        context = this;
        mTextField = (TextView) findViewById(R.id.TextField);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("minutes remaining: " +  millisUntilFinished / 1000);
            }




            public void onFinish() {



                notificationManager = (NotificationManager)  getSystemService(NOTIFICATION_SERVICE);
                remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);

                remoteViews.setImageViewResource(R.id.notif_icon, R.mipmap.run);
                remoteViews.setTextViewText(R.id.notif_title, "Try A 5 Minute Walking Break!");


                notification_id = (int) System.currentTimeMillis();
                Intent button_intent = new Intent("button_clicked");
                button_intent.putExtra("id", notification_id);

                PendingIntent p_button_intent = PendingIntent.getBroadcast(context, 123, button_intent, 0);

                Intent notifications_intent = new Intent(context, EndButton.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notifications_intent,0);

                builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.mipmap.run).setAutoCancel(true)
                        .setCustomBigContentView(remoteViews).setCustomBigContentView(remoteViews).setContentIntent(pendingIntent);

                notificationManager.notify(notification_id,builder.build());

                root.setBackgroundColor(ContextCompat.getColor(EndButton.this, R.color.colorChange));



                mTextField.setText("done!");
            }
        }.start();





    }




        }
