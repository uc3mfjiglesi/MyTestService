package es.cice.mytestservice.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import es.cice.mytestservice.R;
import es.cice.mytestservice.TestNotificationActivity;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class TestIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "es.cice.mytestservice.services.action.FOO";
    private static final String ACTION_BAZ = "es.cice.mytestservice.services.action.BAZ";

    // TODO: Rename parameters
    public static final String EXTRA_PARAM1 = "es.cice.mytestservice.services.extra.PARAM1";
    public static final String EXTRA_PARAM2 = "es.cice.mytestservice.services.extra.PARAM2";
    private static final String TAG="TestIntentService" ;

    public TestIntentService() {
        super("TestIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, TestIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, TestIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String extra1=intent.getStringExtra(EXTRA_PARAM1);
        Log.d(TAG,"[Thread: " + Thread.currentThread().getId()
                +"]onHandleIntent()...");
        Log.d(TAG,EXTRA_PARAM1 + ":" + extra1);
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
            Log.d(TAG,"[Thread: " + Thread.currentThread().getId()
                    +"]TestService is working...");
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
    }





    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
