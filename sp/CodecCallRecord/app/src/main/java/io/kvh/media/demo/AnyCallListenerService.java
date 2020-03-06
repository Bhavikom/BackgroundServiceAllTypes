package io.kvh.media.demo;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioManager.AudioPlaybackCallback;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.kvh.media.KCacheUtils;
import io.kvh.media.sound.SoundMan;
import io.kvh.media.sound.UniversalRecordMp3;

public class AnyCallListenerService extends AccessibilityService {
    UniversalRecordMp3 _UniversalRecordMp3;

    @Override
    public void onCreate()
    {
        super.onCreate();
        _UniversalRecordMp3=new UniversalRecordMp3(this);

    }
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event == null) {
            return;
        }
        try {
            if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {

                Log.e("Evevt Current Class", event.getClassName().toString() + "-" + event.getText() + "-" + event.getEventType());
                if (event.getClassName().toString().equals("com.android.incallui.InCallActivity")) {
                    // SoundMan.getInstance().start();
                    _UniversalRecordMp3.startRecording();

                    Toast.makeText(this, String.format("Check your file at: %s", KCacheUtils.getCacheDirectory() + "/record"), Toast.LENGTH_LONG).show();
                } else {
                    // SoundMan.getInstance().stop();
                    _UniversalRecordMp3.stopRecording();
                }
            }
        }catch (Exception e)
        {
            Log.e("ex", Objects.requireNonNull(e.getMessage()));
        }
    }

    @Override
    public void onInterrupt() {

    }
}
