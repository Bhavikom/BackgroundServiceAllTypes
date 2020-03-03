package com.yasoka.spcallrecord.recorder.call.e;

import com.recorder.call.encoder.WaveHeader;
import java.nio.charset.Charset;

/* compiled from: Util */
final class v {

    /* renamed from: a reason: collision with root package name */
    public static final Charset f3437a = Charset.forName("UTF-8");

    public static int a(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static short a(short s) {
        short s2 = s & WaveHeader.FORMAT_IGNORE;
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static void a(Throwable th) {
        throw th;
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}