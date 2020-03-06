package io.kvh.media.sound;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class UniversalRecordMp3 {
    private Context ct;
    private static final String ALLOWED_CHARACTERS = "qwertyuiopasdfghjklzxcvbnm";
    final public Handler handler = new Handler();
    private MediaRecorder recorder = null;
    private String rendomfileid = "";
    private File recording = null;
    private int countfile = 0;
    private String _recordjson, _recordtype;
    private static String getRandomString() {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(20);
        for (int i = 0; i < 20; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }
    public UniversalRecordMp3(Context _ct)
    {
        ct=_ct;
    }
    private File makeOutputFilemp3() {
        File dir = new File(Objects.requireNonNull( ct.getExternalFilesDir(null)).getAbsolutePath() + "/ysk");
        Log.e("path",dir.getAbsolutePath());
        if (!dir.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                dir.mkdirs();
            } catch (Exception e) {
            Log.e("exp",e.getMessage());
                return null;
            }
        } else {
            if (!dir.canWrite()) {
                return null;
            }
        }
        String suffix = ".mp4";
        String filename = rendomfileid + suffix;
        Log.e("Filename", filename);
        try {
            File file = new File(dir, filename);
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
            return file.getAbsoluteFile();
        } catch (IOException e) {
            //
            return null;
        }
    }
    public void stopRecording() {
        if(recorder!=null) {
            recorder.stop();
            recorder.release();
            recorder = null;

        }
    }
    public void startRecording() {
        rendomfileid=getRandomString();
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_RECOGNITION);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            recorder.setOutputFile(makeOutputFilemp3());
        }
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e("UniversalRecordMp3", "prepare() failed");
        }
        recorder.start();
    }

}
