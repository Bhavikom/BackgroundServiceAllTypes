package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.d;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.0 */
public final class g {
    static {
        new f();
    }

    private static byte[] a(Deque<byte[]> deque, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            byte[] bArr2 = (byte[]) deque.removeFirst();
            int min = Math.min(i2, bArr2.length);
            System.arraycopy(bArr2, 0, bArr, i - i2, min);
            i2 -= min;
        }
        return bArr;
    }

    /* renamed from: a reason: collision with other method in class */
    public static byte[] m1a(InputStream inputStream) throws IOException {
        int i;
        if (inputStream != null) {
            ArrayDeque arrayDeque = new ArrayDeque(20);
            int i2 = 8192;
            for (int i3 = 0; i3 < 2147483639; i3 = i) {
                byte[] bArr = new byte[Math.min(i2, 2147483639 - i3)];
                arrayDeque.add(bArr);
                i = i3;
                int i4 = 0;
                while (i4 < bArr.length) {
                    int read = inputStream.read(bArr, i4, bArr.length - i4);
                    if (read == -1) {
                        return a(arrayDeque, i);
                    }
                    i4 += read;
                    i += read;
                }
                long j = ((long) i2) << 1;
                i2 = j > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : j < -2147483648L ? Integer.MIN_VALUE : (int) j;
            }
            if (inputStream.read() == -1) {
                return a(arrayDeque, 2147483639);
            }
            throw new OutOfMemoryError("input is too large to fit in a byte array");
        }
        throw new NullPointerException();
    }

    public static InputStream a(InputStream inputStream) {
        return new i(inputStream);
    }
}
