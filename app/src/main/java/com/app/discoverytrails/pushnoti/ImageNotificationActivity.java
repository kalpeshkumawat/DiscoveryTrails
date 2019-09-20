package com.app.discoverytrails.pushnoti;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.app.discoverytrails.MainActivity;
import com.app.discoverytrails.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ImageNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_notification);


        Picasso.get().load("http://lorempixel.com/400/200/")
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                        Log.d("dddd", "1111");

                        sendNotification("Hello", bitmap, "ggg");

                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        Log.d("dddd", "eee");

                    }


                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        Log.d("dddd", "rrrr");

                    }
                });

    }

    private void sendNotification(String messageBody, Bitmap imagBitmap, String TrueOrFalse) {

        // Important data

        String channelId = "234";
        String channelName = "Channel_1";
        String channelDescription = "This is static description, Please change it . Important -> It  display when user disable particular notification channel";



        Bundle bundle = new Bundle();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);


        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channelId)
                .setContentTitle("Notification title Text"/* Please accordingly */)
                .setContentText("Text when your notification is collapsed")
                .setAutoCancel(true)  // set True for remove notification when user click on notification and navigate into app
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                //.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.win))  // For custom tune for notification
                .setContentIntent(pendingIntent)
                .setSubText("This is subtext" /* This text display in notification header */)
                .setColor(getResources().getColor(R.color.colorPrimaryDark)) ///* Notification icon color on notification & lower version lollipop or below is changes icon background color on notification * /)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.drawable.ic_3d_rotation); // Notification icon on status bar and on notification


        if (Build.VERSION.SDK_INT >= 23) {


            // Marshmallow or Above


            // You can edit below style according to you requirement

            notificationBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(imagBitmap).bigLargeIcon(imagBitmap).setBigContentTitle("Big Content Text").setSummaryText("Text when your notification is expanded"));

        }
        else{

            // Below Marshmallow


            // You can add any style to notification here

        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // TODO : Oreo &  Above Oreo version we need to crate " NotificationChannel "

            // Here we create single notification channel

            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);
            channel.setShowBadge(true);
            channel.canShowBadge();
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500});

            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);
        } else {

            // TODO : Below Oreo version we no need to crate " NotificationChannel "


        }

        assert notificationManager != null;
        notificationManager.notify(0, notificationBuilder.build());

    }

}
