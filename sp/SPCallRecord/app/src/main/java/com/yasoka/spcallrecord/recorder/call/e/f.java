package com.yasoka.spcallrecord.recorder.call.e;

import a.b.a.a.a;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: ByteString */
public class f implements Serializable, Comparable<f> {

    /* renamed from: d reason: collision with root package name */
    static final char[] f3402d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e reason: collision with root package name */
    public static final f f3403e = a(new byte[0]);

    /* renamed from: a reason: collision with root package name */
    final byte[] f3404a;

    /* renamed from: b reason: collision with root package name */
    transient int f3405b;

    /* renamed from: c reason: collision with root package name */
    transient String f3406c;

    f(byte[] bArr) {
        this.f3404a = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f3404a));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f d(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(v.f3437a));
            fVar.f3406c = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String b() {
        byte[] bArr = this.f3404a;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f3402d;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 < r1) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (r7 < r8) goto L_0x0027;
     */
    public int compareTo(Object obj) {
        f fVar = (f) obj;
        int g = g();
        int g2 = fVar.g();
        int min = Math.min(g, g2);
        int i = 0;
        while (i < min) {
            byte a2 = a(i) & 255;
            byte a3 = fVar.a(i) & 255;
            if (a2 == a3) {
                i++;
            }
        }
        if (g == g2) {
            return 0;
        }
    }

    public f e() {
        return c("SHA-1");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r6.a(0, r3, 0, r3.length) != false) goto L_0x001d;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int g = fVar.g();
            byte[] bArr = this.f3404a;
            if (g == bArr.length) {
            }
        }
        z = false;
        return z;
    }

    public f f() {
        return c("SHA-256");
    }

    public int g() {
        return this.f3404a.length;
    }

    public f h() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f3404a;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 < 65 || b2 > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
        }
    }

    public int hashCode() {
        int i = this.f3405b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f3404a);
        this.f3405b = hashCode;
        return hashCode;
    }

    public byte[] i() {
        return (byte[]) this.f3404a.clone();
    }

    public String j() {
        String str = this.f3406c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f3404a, v.f3437a);
        this.f3406c = str2;
        return str2;
    }

    public String toString() {
        String str;
        String str2;
        if (this.f3404a.length == 0) {
            return "[size=0]";
        }
        String j = j();
        int length = j.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = j.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = j.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        String str3 = "…]";
        String str4 = "[size=";
        String str5 = "]";
        if (i == -1) {
            if (this.f3404a.length <= 64) {
                StringBuilder a2 = a.a("[hex=");
                a2.append(b());
                a2.append(str5);
                str2 = a2.toString();
            } else {
                StringBuilder a3 = a.a(str4);
                a3.append(this.f3404a.length);
                a3.append(" hex=");
                a3.append(a(0, 64).b());
                a3.append(str3);
                str2 = a3.toString();
            }
            return str2;
        }
        String replace = j.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i < j.length()) {
            StringBuilder a4 = a.a(str4);
            a4.append(this.f3404a.length);
            a4.append(" text=");
            a4.append(replace);
            a4.append(str3);
            str = a4.toString();
        } else {
            str = a.a("[text=", replace, str5);
        }
        return str;
    }

    public static f a(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new f(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    /* access modifiers changed from: 0000 */
    public byte[] c() {
        return this.f3404a;
    }

    public f d() {
        return c("MD5");
    }

    public static f b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
            }
            return a(bArr);
        } else {
            throw new IllegalArgumentException(a.c("Unexpected hex string: ", str));
        }
    }

    public String a() {
        return b.a(this.f3404a);
    }

    public static f a(String str) {
        if (str != null) {
            byte[] a2 = b.a(str);
            if (a2 != null) {
                return new f(a2);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected hex digit: ");
                sb.append(c2);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return (c2 - c3) + 10;
    }

    public f a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f3404a;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f3404a, i, bArr2, 0, i3);
                    return new f(bArr2);
                }
            } else {
                StringBuilder a2 = a.a("endIndex > length(");
                a2.append(this.f3404a.length);
                a2.append(")");
                throw new IllegalArgumentException(a2.toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte a(int i) {
        return this.f3404a[i];
    }

    /* access modifiers changed from: 0000 */
    public void a(c cVar) {
        byte[] bArr = this.f3404a;
        cVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(i2, this.f3404a, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f3404a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && v.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(f fVar) {
        return a(0, fVar, 0, fVar.g());
    }
}
