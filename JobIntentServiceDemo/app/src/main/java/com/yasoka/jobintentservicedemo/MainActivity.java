package com.yasoka.jobintentservicedemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_CHECK_STATUS ="action_check_status";
    public static final String ACTION_DO_STUFF =" action_do_stuff";
    Button btnStartJob;
    TextView textView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(myServiceReceiver, new IntentFilter(ACTION_CHECK_STATUS));

        btnStartJob = findViewById(R.id.btn_startjob);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textview);
        btnStartJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statJob();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myServiceReceiver, new IntentFilter(ACTION_CHECK_STATUS));
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(myServiceReceiver);
        }catch (Exception e){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(myServiceReceiver);
        }catch (Exception e){

        }
    }

    public void statJob(){
        SimpleJobIntentService.enqueueWork(this, new Intent().setAction(ACTION_DO_STUFF));
    }
    private BroadcastReceiver myServiceReceiver = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getExtras() != null){
                int status = intent.getExtras().getInt("status",0);
                textView.setText(String.valueOf(status+"%"));
                progressBar.setProgress(status,true);
            }
        }
    };
}
