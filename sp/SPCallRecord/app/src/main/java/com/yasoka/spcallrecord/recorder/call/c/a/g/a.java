package com.yasoka.spcallrecord.recorder.call.c.a.g;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Yeast */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static char[] f701a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();

    /* renamed from: b reason: collision with root package name */
    private static int f702b = f701a.length;

    /* renamed from: c reason: collision with root package name */
    private static int f703c = 0;

    /* renamed from: d reason: collision with root package name */
    private static String f704d;

    /* renamed from: e reason: collision with root package name */
    private static Map<Character, Integer> f705e = new HashMap(f702b);

    static {
        for (int i = 0; i < f702b; i++) {
            f705e.put(Character.valueOf(f701a[i]), Integer.valueOf(i));
        }
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, f701a[(int) (j % ((long) f702b))]);
            j /= (long) f702b;
        } while (j > 0);
        return sb.toString();
    }

    public static String a() {
        String a2 = a(new Date().getTime());
        if (!a2.equals(f704d)) {
            f703c = 0;
            f704d = a2;
            return a2;
        }
        StringBuilder a3 = a.b.a.a.a.a(a2, ".");
        int i = f703c;
        f703c = i + 1;
        a3.append(a((long) i));
        return a3.toString();
    }
}
