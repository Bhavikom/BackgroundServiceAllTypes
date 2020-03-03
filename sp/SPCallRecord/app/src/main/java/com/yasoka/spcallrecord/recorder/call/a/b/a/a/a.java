package com.yasoka.spcallrecord.recorder.call.a.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
import org.webrtc.Logging;

/* compiled from: outline */
public class a {
    public static int a(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    public static String a(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String a(Context context, int i, StringBuilder sb, String str, Exception exc) {
        sb.append(context.getResources().getString(i));
        sb.append(str);
        sb.append(exc.getMessage());
        return sb.toString();
    }

    public static String a(String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(j);
        return sb.toString();
    }

    public static String a(String str, Fragment fragment, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(fragment);
        sb.append(str2);
        return sb.toString();
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String a(JSONObject jSONObject, String str, String str2, Date date, SimpleDateFormat simpleDateFormat) {
        jSONObject.put(str, str2);
        return simpleDateFormat.format(Long.valueOf(date.getTime()));
    }

    public static StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder a(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static void a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.toString();
    }

    public static void a(Context context, String str, int i, String str2, boolean z) {
        Editor edit = context.getSharedPreferences(str, i).edit();
        edit.putBoolean(str2, z);
        edit.apply();
    }

    public static void a(SharedPreferences sharedPreferences, String str, long j) {
        Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void a(Cursor cursor, JSONObject jSONObject, String str, String str2, String str3) {
        jSONObject.put(str, cursor.getPosition());
        jSONObject.put(str2, str3);
    }

    public static void a(String str, Fragment fragment) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(fragment);
        sb.toString();
    }

    public static void a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Logging.d(str2, sb.toString());
    }

    public static String b(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.toString();
    }

    public static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }
}
