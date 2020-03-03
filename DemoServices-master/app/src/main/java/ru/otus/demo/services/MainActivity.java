package ru.otus.demo.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;

import ru.otus.demo.services.bound.DemoServiceConnection;

public class MainActivity extends AppCompatActivity {

    @NonNull
    final DemoServiceConnection mConnection = new DemoServiceConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startIntentService(View view) {
        Intent startIntentService = new Intent(this, DemoIntentService.class);
        startService(startIntentService);
    }

    public void startService(View view) {
        Intent startService = new Intent(this, DemoService.class);
        startService(startService);
    }

    public void startBoundService(View view) {
        mConnection.bindToService(this);
    }

    public void getTimeBoundService(View view) {
        String text = "there is no time to explain";
        if (mConnection.isConnected()) {
            long time = mConnection.getService().getTime();
            text = "Current time is:\n" +
                    new SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                            .format(time);
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        //Oops! ;)
        //Mistakes were made. You should find one of them to get time.
    }

    public void unbindBoundService(View view) {
        mConnection.unbindFromService(this);
    }


    @Override
    protected void onStop() {
        mConnection.unbindFromService(this);
        super.onStop();
    }
}
