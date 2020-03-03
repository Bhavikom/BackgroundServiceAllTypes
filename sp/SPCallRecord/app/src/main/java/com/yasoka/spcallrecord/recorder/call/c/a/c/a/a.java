package com.yasoka.spcallrecord.recorder.call.c.a.c.a;

import java.nio.ByteBuffer;

/* compiled from: Parser */
class a {
    public static byte[] a(byte[][] bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        for (byte[] put : bArr) {
            allocate.put(put);
        }
        return allocate.array();
    }
}
