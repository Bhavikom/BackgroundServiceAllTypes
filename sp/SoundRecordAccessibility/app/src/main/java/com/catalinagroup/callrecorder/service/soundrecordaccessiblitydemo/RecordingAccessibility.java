package com.catalinagroup.callrecorder.service.soundrecordaccessiblitydemo;

import android.accessibilityservice.AccessibilityService;
import android.graphics.PixelFormat;
import android.media.MediaRecorder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordingAccessibility extends AccessibilityService {
    LinearLayout mLayout;
    MediaRecorder recorder;
    public RecordingAccessibility() {
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        mLayout = new LinearLayout(this);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.type = WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY;
        lp.format = PixelFormat.TRANSLUCENT;
        lp.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.TOP;
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.action_bar, mLayout);
        wm.addView(mLayout, lp);


        configureStartRecording();
        configureStopRecording();
    }

    private void configureStartRecording() {
        Button startRecordingButton = mLayout.findViewById(R.id.start_recording);
        startRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CustomMediaRecorder recorder = CustomMediaRecorder.getInstance();
                recorder = new MediaRecorder();
                File audiofile = null;
                String out = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
                File sampleDir = new File(getExternalFilesDir(null), "/TestRecordingDasa1");
                if (!sampleDir.exists()) {
                    sampleDir.mkdirs();
                }
                String file_name = "Record";
                try {
                    audiofile = File.createTempFile(file_name, ".amr", sampleDir);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_RECOGNITION);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                recorder.setOutputFile(audiofile.getAbsolutePath());
                try {
                    recorder.prepare();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                recorder.start();

                //Log.i(MainActivity.LOG_PREFIX, String.format("Recording started. Saving to path: '%s'", audiofile.getAbsolutePath()));

            }
        });
    }

    private void configureStopRecording() {
        Button button = mLayout.findViewById(R.id.stop_recording);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // CustomMediaRecorder recorder = CustomMediaRecorder.getInstance();
                recorder.stop();
            }
        });
    }
}
