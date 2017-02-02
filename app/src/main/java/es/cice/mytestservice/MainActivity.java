package es.cice.mytestservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import es.cice.mytestservice.services.MyCustomThreadService;
import es.cice.mytestservice.services.TestIntentService;
import es.cice.mytestservice.services.TestService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTestService(View v){
        Intent intent=new Intent(this, TestService.class);
        startService(intent);
    }
    public void startTestIntentService(View v){
        Intent intent=new Intent(this, TestIntentService.class);
        intent.putExtra(TestIntentService.EXTRA_PARAM1,"paramTest");
        startService(intent);
    }
    public void startMyCustomThreadService(View v){
        Intent intent=new Intent(this, MyCustomThreadService.class);
        startService(intent);
    }
}
