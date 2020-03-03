package com.yasoka.spcallrecord.recorder.call.a.c.j;

import android.net.Uri;

/* compiled from: BrowserUtil */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final Uri f295a = Uri.parse("content://browser/bookmarks");

    /* renamed from: b reason: collision with root package name */
    public static final Uri f296b = Uri.parse("content://com.android.chrome.browser/bookmarks");

    /* renamed from: c reason: collision with root package name */
    public static final String[] f297c = {"_id", "url", "visits", "date", "bookmark", "title", "favicon", "thumbnail", "touch_icon", "user_entered"};

    static {
        Uri.parse("content://com.android.chrome.browser/history");
    }
}
