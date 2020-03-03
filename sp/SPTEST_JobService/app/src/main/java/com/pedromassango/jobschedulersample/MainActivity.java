package com.pedromassango.jobschedulersample;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pedromassango.jobschedulersample.Database.DatabaseQueryClass;
import com.pedromassango.jobschedulersample.adapter.StudentListRecyclerViewAdapter;
import com.pedromassango.jobschedulersample.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(this);

    private List<Student> studentList = new ArrayList<>();

    private TextView studentListEmptyTextView;
    private RecyclerView recyclerView;
    private StudentListRecyclerViewAdapter studentListRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.studentRecyclerView);
        studentListEmptyTextView = (TextView) findViewById(R.id.emptyStudentListTextView);

        studentList.addAll(databaseQueryClass.getAllStudent());

        studentListRecyclerViewAdapter = new StudentListRecyclerViewAdapter(this, studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(studentListRecyclerViewAdapter);

        viewVisibility();


    }

    // To stop job
    public void onStartJob(View v){

        showStatus(Util.scheduleJob(this));
        /*componentName = new ComponentName(this, MyJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, componentName);

        //builder.setOverrideDeadline( 1000); // delay to start the job
        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        JobInfo jobInfo = builder.build();
        // Start the job
        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        // start and get the result
        int jobResult = scheduler.schedule(jobInfo);

        if(jobResult == JobScheduler.RESULT_FAILURE) {
            showStatus("Job failed to start");
        }else if(jobResult == JobScheduler.RESULT_SUCCESS){
            showStatus("Job Running");
        }*/
    }

    // To stop the job
    public void onStopJob(View v){
        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        //scheduler.cancel(0);
        List<JobInfo> jobs = scheduler.getAllPendingJobs();

        if(jobs.isEmpty()){
            showStatus("No Job to cancel");
        }else{
            int id = jobs.get(0).getId();

            scheduler.cancel(id);
            showStatus("Job stopped");
        }
    }

    private void showStatus(String state){
        TextView textView = findViewById(R.id.tv_job_state);
        textView.setText( state);
    }
    public void viewVisibility() {
        if(studentList.isEmpty())
            studentListEmptyTextView.setVisibility(View.VISIBLE);
        else
            studentListEmptyTextView.setVisibility(View.GONE);
    }
}
