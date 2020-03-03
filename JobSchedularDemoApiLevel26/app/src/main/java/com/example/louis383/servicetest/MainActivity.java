package com.example.louis383.servicetest;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

    private static final int JOB_ID = 101;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* will not work above marshmallow required min periodic 15 min */
        ComponentName componentName = new ComponentName(this,MyJobScheduler.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, componentName);

        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo = builder.build();
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

    }
    public void ScheduleJOb(View view) {
        jobScheduler.schedule(jobInfo);
        Toast.makeText(this, "Job Scheduled .. ", Toast.LENGTH_SHORT).show();
    }

    public void ClearJob(View view) {
        jobScheduler.cancel(JOB_ID);
        Toast.makeText(this, "Job Canceled ",Toast.LENGTH_SHORT).show();
    }
}