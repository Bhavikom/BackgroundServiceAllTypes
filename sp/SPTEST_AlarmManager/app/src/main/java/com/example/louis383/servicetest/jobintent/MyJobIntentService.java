package com.example.louis383.servicetest.jobintent;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.widget.Toast;
import com.example.louis383.servicetest.Database.DatabaseQueryClass;
import com.example.louis383.servicetest.model.Student;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJobIntentService extends JobIntentService {
    final Handler mHandler = new Handler();
    Context context;
    private static final String TAG = "MyJobIntentService";
    /**
     * Unique job ID for this service.
     */
    private static final int JOB_ID = 2;

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, MyJobIntentService.class, JOB_ID, intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showToast("Job Execution Started");
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        /**
         * Write code here.. Perform Long operation here such as Download/Upload of file, Sync Some data
         * The system or framework is already holding a wake lock for us at this point
         */

        int maxCount = intent.getIntExtra("maxCountValue", -1);
        /**
         * Suppose we want to print 1 to 1000 number with one-second interval, Each task will take time 1 sec, So here now sleeping thread for one second.
         */
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyyy hh:mm:ss a");
        String dateToStr = format.format(today);
        //System.out.println(dateToStr);

        Student student = new Student(-1, dateToStr, "AlarmManager", String.valueOf(JOB_ID), "");
        DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(getApplicationContext());
        long id = databaseQueryClass.insertStudent(student);
        if(id>0){
            student.setId(id);
//            Toast.makeText(getApplicationContext(), " Student added : "+id, Toast.LENGTH_LONG).show();
        }

        /*for (int i = 0; i < maxCount; i++) {
            Log.d(TAG, "onHandleWork: The number is: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showToast("Job Execution Finished");
    }


    // Helper for showing tests
    void showToast(final CharSequence text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyJobIntentService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

