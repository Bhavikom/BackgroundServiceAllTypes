package com.yasoka.spcallrecord.recorder.call.a.c.e;

import a.c.j.c;
import a.e.a.a.a.b;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.util.MalformedJsonException;
import com.app.activity.MyApp;
import com.crashlytics.android.Crashlytics;
import java.io.EOFException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLException;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Response;

/* compiled from: ClassGlobal */
public abstract class a {

    /* renamed from: a.c.e.a$a reason: collision with other inner class name */
    /* compiled from: ClassGlobal */
    static class C0000a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ Context f173a;

        C0000a(Context context) {
            this.f173a = context;
        }

        public void run() {
            Calendar calendar;
            String str = "lastDateVerifIDPhone";
            String str2 = "dateVerifIDPhone";
            try {
                if (e.e(this.f173a) > 0) {
                    long j = this.f173a.getSharedPreferences(str2, 0).getLong(str, 0);
                    if (j == 0) {
                        calendar = null;
                    } else {
                        calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(j);
                    }
                    String str3 = "no";
                    String str4 = "user/verifIDPhone.php";
                    String str5 = "idClient";
                    String str6 = "idPhone";
                    String str7 = "";
                    if (calendar == null) {
                        Calendar instance = Calendar.getInstance();
                        Context context = this.f173a;
                        long timeInMillis = instance.getTimeInMillis();
                        Editor edit = context.getSharedPreferences(str2, 0).edit();
                        edit.putLong(str, timeInMillis);
                        edit.apply();
                        HashMap hashMap = new HashMap();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str7);
                        sb.append(e.e(this.f173a));
                        hashMap.put(str6, sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str7);
                        sb2.append(e.d(this.f173a));
                        hashMap.put(str5, sb2.toString());
                        Response execute = com.app.retrofit.a.b().a().insertData(str4, hashMap).execute();
                        if (execute != null && execute.isSuccessful() && execute.body() != null && ((String) execute.body()).equals(str3)) {
                            e.a(this.f173a, 0);
                            return;
                        }
                        return;
                    }
                    Calendar instance2 = Calendar.getInstance();
                    instance2.setTime(new Date());
                    instance2.add(12, -30);
                    if (instance2.compareTo(calendar) > 0) {
                        calendar.setTime(new Date());
                        Context context2 = this.f173a;
                        long timeInMillis2 = calendar.getTimeInMillis();
                        Editor edit2 = context2.getSharedPreferences(str2, 0).edit();
                        edit2.putLong(str, timeInMillis2);
                        edit2.apply();
                        HashMap hashMap2 = new HashMap();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str7);
                        sb3.append(e.e(this.f173a));
                        hashMap2.put(str6, sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str7);
                        sb4.append(e.d(this.f173a));
                        hashMap2.put(str5, sb4.toString());
                        Response execute2 = com.app.retrofit.a.b().a().insertData(str4, hashMap2).execute();
                        if (execute2 != null && execute2.isSuccessful() && execute2.body() != null && ((String) execute2.body()).equals(str3)) {
                            e.a(this.f173a, 0);
                        }
                    }
                }
            } catch (Throwable th) {
                th.getStackTrace();
            }
        }
    }

    public static void a(Context context, boolean z) {
        a.b.a.a.a.a(context, "user", 0, "sizeCallsLimitWIFI", z);
    }

    public static boolean b(String str, Map<String, String> map) {
        try {
            if (e.e(MyApp.b().getApplicationContext()) > 0) {
                map.put("tokenSecurity", e.w(MyApp.b().getApplicationContext()));
                Response execute = com.app.retrofit.a.b().a().insertData(str, map).execute();
                if (execute != null && execute.isSuccessful() && execute.body() != null && ((String) execute.body()).equals("ok")) {
                    return true;
                }
            }
        } catch (ConnectException e2) {
            e2.getStackTrace();
        } catch (SocketTimeoutException e3) {
            e3.getStackTrace();
        } catch (UnknownHostException e4) {
            e4.getStackTrace();
        } catch (SocketException e5) {
            e5.getStackTrace();
        } catch (MalformedJsonException e6) {
            e6.getStackTrace();
        } catch (SSLException e7) {
            e7.getStackTrace();
        } catch (com.google.gson.stream.MalformedJsonException e8) {
            e8.getStackTrace();
        } catch (EOFException e9) {
            e9.getStackTrace();
        } catch (Exception e10) {
            e10.getStackTrace();
        }
        return false;
    }

    public static void c(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("modeRecordCalls", i);
        edit.apply();
    }

    public static void d(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("sizeCallLimit", i);
        edit.apply();
    }

    public static void e(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("sourceAudioRecordCalls", i);
        edit.apply();
    }

    public static void f(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("typeConfigRecordCalls", i);
        edit.apply();
    }

    public static int a(Context context) {
        return context.getSharedPreferences("user", 0).getInt("formatAudioRecordCalls", 1);
    }

    public static void a(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("formatAudioRecordCalls", i);
        edit.apply();
    }

    public static int c(Context context) {
        return context.getSharedPreferences("user", 0).getInt("outgoingDelayRecordCalls", b(false));
    }

    public static void d(Context context) {
        new Thread(new C0000a(context)).start();
    }

    public static boolean a(String str, HashMap<String, RequestBody> hashMap, Part part) {
        try {
            if (e.e(MyApp.b().getApplicationContext()) > 0) {
                hashMap.put("tokenSecurity", com.app.retrofit.a.a(e.w(MyApp.b().getApplicationContext())));
                Response execute = com.app.retrofit.a.b().a().postFile(str, hashMap, part).execute();
                if (execute != null && execute.isSuccessful() && execute.body() != null && ((String) execute.body()).equals("ok")) {
                    return true;
                }
            }
        } catch (ConnectException e2) {
            e2.getStackTrace();
        } catch (SocketTimeoutException e3) {
            e3.getStackTrace();
        } catch (UnknownHostException e4) {
            e4.getStackTrace();
        } catch (SocketException e5) {
            e5.getStackTrace();
        } catch (MalformedJsonException e6) {
            e6.getStackTrace();
        } catch (SSLException e7) {
            e7.getStackTrace();
        } catch (com.google.gson.stream.MalformedJsonException e8) {
            e8.getStackTrace();
        } catch (EOFException e9) {
            e9.getStackTrace();
        } catch (Exception e10) {
            e10.getStackTrace();
        }
        return false;
    }

    public static void b(Context context, int i) {
        Editor edit = context.getSharedPreferences("user", 0).edit();
        edit.putInt("increaseSoundRecordCalls", i);
        edit.apply();
    }

    public static int b(Context context) {
        return context.getSharedPreferences("user", 0).getInt("incomingDelayRecordCalls", b(true));
    }

    private static int b(boolean z) {
        try {
            boolean z2 = Build.MODEL.toLowerCase().contains("gt-i9500") || Build.MODEL.toLowerCase().contains("gt-i9505");
            if (z) {
                if (z2) {
                    return 1;
                }
            } else if (z2) {
                return 10;
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
        return 1;
    }

    public static int a(boolean z) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b("x10", null, 3));
        arrayList.add(new b("hero", null, 2));
        arrayList.add(new b("dell streak", null, 2));
        arrayList.add(new b("incredible", null, 3));
        arrayList.add(new b("vivow", null, 3));
        arrayList.add(new b("evo", null, 3));
        arrayList.add(new b("desirec", null, 3));
        arrayList.add(new b("shift", null, 3));
        arrayList.add(new b("g1", null, 3));
        arrayList.add(new b("dream", null, 3));
        arrayList.add(new b("dstl1", null, 3));
        arrayList.add(new b("mk16i", null, 3));
        arrayList.add(new b("m110s", null, 3));
        arrayList.add(new b("captivate", null, 3));
        arrayList.add(new b("mytouch", null, 3));
        arrayList.add(new b("sapphire", null, 3));
        arrayList.add(new b("xt701", null, 3));
        arrayList.add(new b("milestone2", null, 3));
        arrayList.add(new b("meizu", null, 3));
        arrayList.add(new b("charm", null, 3));
        arrayList.add(new b("umts_basil", null, 3));
        arrayList.add(new b("defy", null, 3));
        String str = "jordan";
        arrayList.add(new b(str, null, 3));
        arrayList.add(new b("gt540", null, 3));
        arrayList.add(new b("gw620", null, 3));
        arrayList.add(new b("u8150", null, 3));
        arrayList.add(new b("comet", null, 3));
        arrayList.add(new b("wildfire", null, 3));
        arrayList.add(new b("marvel", null, 3));
        arrayList.add(new b("sensation", null, 3));
        arrayList.add(new b("pyramid", null, 3));
        arrayList.add(new b("tattoo", null, 3));
        arrayList.add(new b("magic", null, 3));
        arrayList.add(new b("desire", null, 3));
        arrayList.add(new b("s2", "samsung", 2));
        arrayList.add(new b("i9100", null, 2));
        arrayList.add(new b("m250k", null, 2));
        arrayList.add(new b("m250l", null, 2));
        arrayList.add(new b("02c", null, 2));
        arrayList.add(new b("i9103", null, 2));
        arrayList.add(new b("i9100t", null, 2));
        arrayList.add(new b("galaxys2", null, 2));
        arrayList.add(new b("tab", null, 2));
        arrayList.add(new b("gt-s6102", null, 2));
        arrayList.add(new b("p500", null, 2));
        arrayList.add(new b("pb76100", null, 3));
        arrayList.add(new b("s5360", null, 2));
        arrayList.add(new b("sgh-i717", null, 2));
        arrayList.add(new b("gt-n7000", null, 2));
        arrayList.add(new b("gt-n7003", null, 2));
        arrayList.add(new b("p6800", null, 2));
        arrayList.add(new b("i9220", null, 2));
        arrayList.add(new b("i9250", null, 2));
        arrayList.add(new b("lt25", null, 4));
        arrayList.add(new b("gt-b5512", null, 2));
        String str2 = "lg";
        arrayList.add(new b("e973", str2, 3));
        arrayList.add(new b("f180", str2, 3));
        arrayList.add(new b("GT-I9295", null, 1));
        if (z) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                boolean z3 = bVar.f560b == null || Build.MANUFACTURER.toLowerCase().contains(bVar.f560b);
                if (!Build.MODEL.toLowerCase().contains(bVar.f559a) || !z3) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    return bVar.a();
                }
            }
            return 1;
        }
        String str3 = Build.DEVICE;
        if (str3 != null) {
            String lowerCase = str3.toLowerCase();
            for (String contains : new String[]{"falcon", "osprey", "titan", "peregrine", "thea", "condor", "otus", "surnia", "edison", "olympus", "mb886", "motus", "morrison", "zepplin", str, "jordan_plus", "sholes", "droid2", "droid2we", "cdma_droid2we", "solana", "maserati", "targa", "spyder", "xt926", "xt907", "obake", "shadow", "quark", "ghost", "xt1058", "xt1053", "xt1060", "victara", "moto_msm8960", "moto_msm8960_jbbl", "sunfire", "zt897", "xt897c", "utms_spyder", "xt925", "xt925_jbbl", "moto_msm8960dt", "everest", "stringray", "wingray", "clark", "kltespr"}) {
                if (contains.contains(lowerCase)) {
                    return 1;
                }
            }
        }
        return 2;
    }

    public static JSONObject a(String str, Map<String, String> map) {
        try {
            Response execute = com.app.retrofit.a.b().a().getDataUser(str, map).execute();
            if (execute == null || !execute.isSuccessful() || execute.body() == null) {
                return null;
            }
            try {
                return new JSONObject(((ResponseBody) execute.body()).string());
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (UnknownHostException e3) {
            e3.getStackTrace();
            try {
                if (!c.e(MyApp.b().getApplicationContext())) {
                    return null;
                }
                e.s(MyApp.b().getApplicationContext(), true);
                return null;
            } catch (Exception e4) {
                e4.getStackTrace();
                return null;
            }
        } catch (SocketException e5) {
            e5.getStackTrace();
            try {
                if (!c.e(MyApp.b().getApplicationContext())) {
                    return null;
                }
                e.s(MyApp.b().getApplicationContext(), true);
                return null;
            } catch (Exception e6) {
                e6.getStackTrace();
                return null;
            }
        } catch (Exception e7) {
            e7.getStackTrace();
            return null;
        }
    }
}
