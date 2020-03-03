package com.yasoka.spcallrecord.recorder.call.a.c.c;

import a.c.b.C0076h;
import a.c.b.C0087t;
import a.c.b.F;
import a.c.b.c0;
import android.content.Context;
import android.database.Cursor;
import com.crashlytics.android.Crashlytics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: UtilBDD */
public class b {
    public static synchronized ArrayList<String> a(Context context) {
        ArrayList<String> arrayList;
        synchronized (b.class) {
            try {
                c0 c0Var = new c0(context);
                c0Var.b();
                Cursor c2 = c0Var.c();
                if (c2 == null) {
                    return null;
                }
                if (c2.getCount() == 0) {
                    c2.close();
                    c0Var.a();
                    return null;
                }
                while (c2.moveToNext()) {
                    arrayList = new ArrayList<>();
                    String string = c2.getString(1);
                    String string2 = c2.getString(2);
                    String string3 = c2.getString(3);
                    String string4 = c2.getString(4);
                    Calendar instance = Calendar.getInstance();
                    Calendar instance2 = Calendar.getInstance();
                    int parseInt = Integer.parseInt(string.split(":")[0]);
                    int parseInt2 = Integer.parseInt(string.split(":")[1]);
                    instance2.set(11, parseInt);
                    instance2.set(12, parseInt2);
                    Calendar instance3 = Calendar.getInstance();
                    int parseInt3 = Integer.parseInt(string2.split(":")[0]);
                    int parseInt4 = Integer.parseInt(string2.split(":")[1]);
                    instance3.set(11, parseInt3);
                    instance3.set(12, parseInt4);
                    if (a(string3) && instance.getTimeInMillis() >= instance2.getTimeInMillis() && instance.getTimeInMillis() <= instance3.getTimeInMillis()) {
                        c0Var.a();
                        c2.close();
                        arrayList.add(string4);
                        arrayList.add(new SimpleDateFormat("HH:mm", Locale.US).format(instance3.getTime()));
                    }
                }
                c2.close();
                c0Var.a();
            } catch (Exception e2) {
                e2.getStackTrace();
                try {
                    e2.getStackTrace();
                    Crashlytics.logException(e2);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th.getStackTrace();
                try {
                    th.getStackTrace();
                    Crashlytics.logException(th);
                } catch (Exception unused2) {
                }
            }
        }
        return arrayList;
        return null;
    }

    public static synchronized boolean b(int i, Context context) {
        synchronized (b.class) {
            try {
                c0 c0Var = new c0(context);
                c0Var.b();
                Cursor c2 = c0Var.c();
                if (c2 == null) {
                    return true;
                }
                if (c2.getCount() == 0) {
                    c2.close();
                    c0Var.a();
                    return true;
                } else if (c0Var.a(i)) {
                    c0Var.a();
                    return true;
                } else {
                    c0Var.a();
                    return false;
                }
            } catch (Throwable th) {
                th.getStackTrace();
                try {
                    th.getStackTrace();
                    Crashlytics.logException(th);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static boolean a(String str) {
        ArrayList arrayList = new ArrayList();
        for (String parseInt : str.split(",")) {
            switch (Integer.parseInt(parseInt)) {
                case 1:
                    arrayList.add(Integer.valueOf(2));
                    break;
                case 2:
                    arrayList.add(Integer.valueOf(3));
                    break;
                case 3:
                    arrayList.add(Integer.valueOf(4));
                    break;
                case 4:
                    arrayList.add(Integer.valueOf(5));
                    break;
                case 5:
                    arrayList.add(Integer.valueOf(6));
                    break;
                case 6:
                    arrayList.add(Integer.valueOf(7));
                    break;
                case 7:
                    arrayList.add(Integer.valueOf(1));
                    break;
            }
        }
        return arrayList.contains(Integer.valueOf(Calendar.getInstance().get(7)));
    }

    public static synchronized long a(String str, String str2, String str3, String str4, Context context) {
        long j;
        synchronized (b.class) {
            j = -1;
            try {
                c0 c0Var = new c0(context);
                F f = new F(str, str2, str3, str4);
                c0Var.b();
                j = c0Var.a(f);
                c0Var.a();
            } catch (Throwable th) {
                th.getStackTrace();
                try {
                    th.getStackTrace();
                    Crashlytics.logException(th);
                } catch (Exception unused) {
                }
            }
        }
        return j;
    }

    public static synchronized long a(String str, String str2, String str3, String str4, String str5, Context context) {
        long j;
        synchronized (b.class) {
            j = -1;
            try {
                C0076h hVar = new C0076h(context);
                C0087t tVar = new C0087t(str, str2, str3, str4, str5);
                hVar.b();
                j = hVar.a(tVar);
                hVar.a();
            } catch (Throwable th) {
                th.getStackTrace();
                try {
                    th.getStackTrace();
                    Crashlytics.logException(th);
                } catch (Exception unused) {
                }
            }
        }
        return j;
    }

    public static synchronized boolean a(int i, Context context) {
        synchronized (b.class) {
            try {
                C0076h hVar = new C0076h(context);
                hVar.b();
                if (hVar.a(i)) {
                    hVar.a();
                    return true;
                }
                hVar.a();
                return false;
            } catch (Throwable th) {
                th.getStackTrace();
                try {
                    th.getStackTrace();
                    Crashlytics.logException(th);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static synchronized ArrayList<String> a(String str, Context context) {
        ArrayList<String> arrayList;
        synchronized (b.class) {
            try {
                C0076h hVar = new C0076h(context);
                hVar.b();
                Cursor a2 = hVar.a(str);
                if (!(a2 == null || a2.getCount() == 0)) {
                    while (a2.moveToNext()) {
                        arrayList = new ArrayList<>();
                        String string = a2.getString(2);
                        String string2 = a2.getString(3);
                        String string3 = a2.getString(4);
                        String string4 = a2.getString(5);
                        Calendar instance = Calendar.getInstance();
                        Calendar instance2 = Calendar.getInstance();
                        int parseInt = Integer.parseInt(string.split(":")[0]);
                        int parseInt2 = Integer.parseInt(string.split(":")[1]);
                        instance2.set(11, parseInt);
                        instance2.set(12, parseInt2);
                        Calendar instance3 = Calendar.getInstance();
                        int parseInt3 = Integer.parseInt(string2.split(":")[0]);
                        int parseInt4 = Integer.parseInt(string2.split(":")[1]);
                        instance3.set(11, parseInt3);
                        instance3.set(12, parseInt4);
                        if (a(string3) && instance.getTimeInMillis() >= instance2.getTimeInMillis() && instance.getTimeInMillis() <= instance3.getTimeInMillis()) {
                            hVar.a();
                            a2.close();
                            arrayList.add(string4);
                            arrayList.add(new SimpleDateFormat("HH:mm", Locale.US).format(instance3.getTime()));
                        }
                    }
                }
                if (a2 != null) {
                    a2.close();
                }
                hVar.a();
            } catch (Exception e2) {
                e2.getStackTrace();
                try {
                    e2.getStackTrace();
                    Crashlytics.logException(e2);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th.getStackTrace();
                try {
                    th.getStackTrace();
                    Crashlytics.logException(th);
                } catch (Exception unused2) {
                }
            }
            return null;
        }
        return arrayList;
    }
}
