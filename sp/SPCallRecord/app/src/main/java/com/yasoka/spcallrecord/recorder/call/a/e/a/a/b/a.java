package com.yasoka.spcallrecord.recorder.call.a.e.a.a.b;

/* compiled from: MediaFormat */
public enum a {
    AMR,
    WAV,
    AAC,
    MP3,
    MP4,
    THREE_GP;

    public static int a(int i) {
        switch (i) {
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 7;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                return 1;
        }
    }

    public static a b(int i) {
        switch (i) {
            case 1:
                return MP3;
            case 2:
                return THREE_GP;
            case 3:
                return MP4;
            case 4:
                return AAC;
            case 5:
                return AMR;
            case 6:
                return WAV;
            default:
                return AMR;
        }
    }

    public String a() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return ".amr";
        }
        if (ordinal == 1) {
            return ".wav";
        }
        if (ordinal == 2) {
            return ".aac";
        }
        if (ordinal == 3) {
            return ".mp3";
        }
        if (ordinal != 4) {
            return ordinal != 5 ? ".unk" : ".3gp";
        }
        return ".mp4";
    }
}
