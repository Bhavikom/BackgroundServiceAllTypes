package com.yasoka.spcallrecord.recorder.call.c.a.c.a;

import io.socket.utf8.UTF8Exception;
import io.socket.utf8.a.C0068a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Parser */
public class c {

    /* renamed from: a reason: collision with root package name */
    private static final int f672a = String.valueOf(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).length();

    /* renamed from: b reason: collision with root package name */
    private static final Map<String, Integer> f673b = new a();

    /* renamed from: c reason: collision with root package name */
    private static final Map<Integer, String> f674c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    private static b<String> f675d = new b<>("error", "parser error");

    /* renamed from: e reason: collision with root package name */
    private static C0068a f676e = new C0068a();

    /* compiled from: Parser */
    static class a extends HashMap<String, Integer> {
        a() {
            put("open", Integer.valueOf(0));
            put("close", Integer.valueOf(1));
            put("ping", Integer.valueOf(2));
            put("pong", Integer.valueOf(3));
            put("message", Integer.valueOf(4));
            put("upgrade", Integer.valueOf(5));
            put("noop", Integer.valueOf(6));
        }
    }

    /* compiled from: Parser */
    static class b implements d {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ StringBuilder f677a;

        b(StringBuilder sb) {
            this.f677a = sb;
        }

        public void a(Object obj) {
            this.f677a.append(c.a((String) obj));
        }
    }

    /* renamed from: c.a.c.a.c$c reason: collision with other inner class name */
    /* compiled from: Parser */
    public interface C0012c<T> {
        boolean a(b<T> bVar, int i, int i2);
    }

    /* compiled from: Parser */
    public interface d<T> {
        void a(T t);
    }

    static {
        for (Entry entry : f673b.entrySet()) {
            f674c.put(entry.getValue(), entry.getKey());
        }
        f676e.f3887a = false;
    }

    public static void a(b bVar, boolean z, d dVar) throws UTF8Exception {
        T t = bVar.f671b;
        if (t instanceof byte[]) {
            byte[] bArr = (byte[]) t;
            byte[] bArr2 = new byte[(bArr.length + 1)];
            bArr2[0] = ((Integer) f673b.get(bVar.f670a)).byteValue();
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
            dVar.a(bArr2);
            return;
        }
        String valueOf = String.valueOf(f673b.get(bVar.f670a));
        if (bVar.f671b != null) {
            StringBuilder a2 = a.b.a.a.a.a(valueOf);
            String valueOf2 = String.valueOf(bVar.f671b);
            if (z) {
                valueOf2 = io.socket.utf8.a.b(valueOf2, f676e);
            }
            a2.append(valueOf2);
            valueOf = a2.toString();
        }
        dVar.a(valueOf);
    }

    static /* synthetic */ byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) Character.codePointAt(str, i);
        }
        return bArr;
    }

    public static b<String> a(String str, boolean z) {
        int i;
        if (str == null) {
            return f675d;
        }
        try {
            i = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            i = -1;
        }
        if (z) {
            try {
                str = io.socket.utf8.a.a(str, f676e);
            } catch (UTF8Exception unused2) {
                return f675d;
            }
        }
        if (i < 0 || i >= f674c.size()) {
            return f675d;
        }
        if (str.length() > 1) {
            return new b<>((String) f674c.get(Integer.valueOf(i)), str.substring(1));
        }
        return new b<>((String) f674c.get(Integer.valueOf(i)));
    }

    public static b<byte[]> a(byte[] bArr) {
        byte b2 = bArr[0];
        byte[] bArr2 = new byte[(bArr.length - 1)];
        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
        return new b<>((String) f674c.get(Integer.valueOf(b2)), bArr2);
    }

    public static void a(b[] bVarArr, d dVar) throws UTF8Exception {
        for (b bVar : bVarArr) {
            if (bVar.f671b instanceof byte[]) {
                if (bVarArr.length == 0) {
                    dVar.a(new byte[0]);
                } else {
                    ArrayList arrayList = new ArrayList(bVarArr.length);
                    for (b a2 : bVarArr) {
                        a(a2, true, new e(new d(arrayList)));
                    }
                    dVar.a(a.a((byte[][]) arrayList.toArray(new byte[arrayList.size()][])));
                }
                return;
            }
        }
        if (bVarArr.length == 0) {
            dVar.a("0:");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (b a3 : bVarArr) {
            a(a3, false, new b(sb));
        }
        dVar.a(sb.toString());
    }

    static /* synthetic */ String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.length());
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    public static void a(String str, C0012c<String> cVar) {
        if (str == null || str.length() == 0) {
            cVar.a(f675d, 0, 1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        StringBuilder sb2 = sb;
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (':' != charAt) {
                sb2.append(charAt);
            } else {
                try {
                    int parseInt = Integer.parseInt(sb2.toString());
                    int i2 = i + 1;
                    try {
                        String substring = str.substring(i2, i2 + parseInt);
                        if (substring.length() != 0) {
                            b a2 = a(substring, false);
                            if (f675d.f670a.equals(a2.f670a) && ((String) f675d.f671b).equals(a2.f671b)) {
                                cVar.a(f675d, 0, 1);
                                return;
                            } else if (!cVar.a(a2, i + parseInt, length)) {
                                return;
                            }
                        }
                        i += parseInt;
                        sb2 = new StringBuilder();
                    } catch (IndexOutOfBoundsException unused) {
                        cVar.a(f675d, 0, 1);
                        return;
                    }
                } catch (NumberFormatException unused2) {
                    cVar.a(f675d, 0, 1);
                    return;
                }
            }
            i++;
        }
        if (sb2.length() > 0) {
            cVar.a(f675d, 0, 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r10.position(r1.length() + 1);
        r10 = r10.slice();
        r1 = java.lang.Integer.parseInt(r1.toString());
        r10.position(1);
        r1 = r1 + 1;
        r10.limit(r1);
        r3 = new byte[r10.remaining()];
        r10.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r4 == false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        r4 = new java.lang.StringBuilder();
        r6 = r3.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        if (r2 >= r6) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        r4.appendCodePoint(r3[r2] & 255);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        r0.add(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        r0.add(r3);
     */
    public static void a(byte[] bArr, C0012c cVar) {
        ByteBuffer slice;
        int i;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = 0;
            if (wrap.capacity() > 0) {
                StringBuilder sb = new StringBuilder();
                boolean z = (wrap.get(0) & 255) == 0;
                int i3 = 1;
                while (true) {
                    byte b2 = wrap.get(i3) & 255;
                    if (b2 == 255) {
                        break;
                    } else if (sb.length() > f672a) {
                        cVar.a(f675d, 0, 1);
                        return;
                    } else {
                        sb.append(b2);
                        i3++;
                    }
                }
            } else {
                int size = arrayList.size();
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof String) {
                        cVar.a(a((String) obj, true), i2, size);
                    } else if (obj instanceof byte[]) {
                        cVar.a(a((byte[]) obj), i2, size);
                    }
                    i2++;
                }
                return;
            }
            slice.clear();
            slice.position(i);
            wrap = slice.slice();
        }
    }
}
