package com.pedromassango.jobschedulersample;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

public class Util {

    // schedule the start of the service every 10 - 30 seconds
    public static String scheduleJob(Context context) {

        ComponentName componentName = new ComponentName(context, MyJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, componentName);

        //builder.setOverrideDeadline( 1000); // delay to start the job
        builder.setPeriodic(15 * 60 * 1000); // 15 minute
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        JobInfo jobInfo = builder.build();
        // Start the job
        JobScheduler scheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        // start and get the result
        int jobResult = scheduler.schedule(jobInfo);

        if(jobResult == JobScheduler.RESULT_FAILURE) {
            return "Job failed to start";
        }else if(jobResult == JobScheduler.RESULT_SUCCESS){
            return "Job Running";
        }
        /*JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
        builder.setMinimumLatency(1 * 1000); // wait at least
        builder.setOverrideDeadline(3 * 1000); // maximum delay
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
        //builder.setRequiresDeviceIdle(true); // device should be idle
        //builder.setRequiresCharging(false); // we don't care if the device is charging or not
        JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);
        jobScheduler.schedule(builder.build());*/
        return "";
    }
}
