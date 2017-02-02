package es.cice.mytestservice.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import es.cice.mytestservice.R;
import es.cice.mytestservice.TestNotificationActivity;

public class TestService extends Service {

    public final static String TAG="TestService";
    public TestService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"[Thread: " + Thread.currentThread().getId()
                +"]onStartCommand()...");
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG,"TestService is working...");
        }
        Intent i=new Intent(getApplicationContext(), TestNotificationActivity.class);
        PendingIntent pIntent=PendingIntent.getActivity(getApplicationContext(),1,i,0);
        Notification.Builder builder=new Notification.Builder(this);
        builder
                .setSmallIcon(R.drawable.ic_test_notification)
                .setContentTitle("testIntentService")
                .setContentText("test Intent Service finished...")
                .setContentIntent(pIntent);
        Notification notification=builder.build();
        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(11111,notification);
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
