package com.pedromassango.jobschedulersample;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.pedromassango.jobschedulersample.Database.DatabaseQueryClass;
import com.pedromassango.jobschedulersample.model.Student;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pedro Massango on 5/16/18.
 */
public class MyJobService extends JobService {

    // JobService thread
    private JobThread jobThread;

    private void log(String msg) {
        Log.e("MyJobService", msg);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        log("onCreate();");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("onStartCommand();");

        // since onStartCommand is called only if the thread is already running
        // we just ignore this method, since we already started the thread in onCreate()
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        log("onStartJob();");
        //jobThread = new JobThread();
        //jobThread.start(); // start the thread when Service is created
        Toast.makeText(getApplicationContext(), "SPTEST_JOBSERVICE start ", Toast.LENGTH_SHORT).show();
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyyy hh:mm:ss a");
        String dateToStr = format.format(today);
        //System.out.println(dateToStr);

        Student student = new Student(-1, dateToStr, "JobService", String.valueOf(101), "");
        DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(getApplicationContext());
        long id = databaseQueryClass.insertStudent(student);
        if(id>0){
            student.setId(id);
//            Toast.makeText(getApplicationContext(), " Student added : "+id, Toast.LENGTH_LONG).show();
        }
        //jobFinished(params, false);
        // we just ignore this method,
        // since we already started the thread in onCreate()
        return false; // return true to let the service do the job
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        log("onStopJob();");

        // change the thread state to cancel the execution
//        jobThread.stopThread = true;
        Toast.makeText(getApplicationContext(), "SPTEST_JOBSERVICE finished ", Toast.LENGTH_SHORT).show();


        return false;
    }

    /**
     * Thread to run on this JobService
     */
    class JobThread extends Thread{

        boolean stopThread = false;

        @Override
        public void run() {
            int count = 0;

            // this will block the UI because JobService run on mainThread.
            // Now it is safe to execute because we are inside of a background
            // Thread

            Toast.makeText(getApplicationContext(), "SPTEST_JOBSERVICE running ", Toast.LENGTH_LONG).show();
            /*while (count != 100 && !stopThread){
                count++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    stopSelf();
                    log("Thread interrupted");
                }

                log("count: " +count);
            }*/
        }
    }

}
