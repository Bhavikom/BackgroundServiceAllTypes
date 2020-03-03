package com.example.louis383.servicetest;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class MJobExecuter extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void... params){
        return "Background Long Running Task Finished...";
    }
}
