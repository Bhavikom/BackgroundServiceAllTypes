package com.yasoka.spcallrecord.recorder.call.e;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink */
public interface d extends s, WritableByteChannel {
    long a(t tVar) throws IOException;

    d a(long j) throws IOException;

    d a(f fVar) throws IOException;

    d a(String str) throws IOException;

    c b();

    d b(long j) throws IOException;

    d c() throws IOException;

    d d() throws IOException;

    void flush() throws IOException;

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i, int i2) throws IOException;

    d writeByte(int i) throws IOException;

    d writeInt(int i) throws IOException;

    d writeShort(int i) throws IOException;
}
