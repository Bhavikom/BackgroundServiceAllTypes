package com.yasoka.spcallrecord.recorder.call.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource */
public interface e extends t, ReadableByteChannel {
    long a(byte b2) throws IOException;

    long a(s sVar) throws IOException;

    String a(Charset charset) throws IOException;

    void a(c cVar, long j) throws IOException;

    boolean a(long j, f fVar) throws IOException;

    c b();

    f c(long j) throws IOException;

    boolean d(long j) throws IOException;

    String e() throws IOException;

    byte[] e(long j) throws IOException;

    String f(long j) throws IOException;

    byte[] f() throws IOException;

    int g() throws IOException;

    void g(long j) throws IOException;

    boolean h() throws IOException;

    short i() throws IOException;

    long j() throws IOException;

    long k() throws IOException;

    InputStream l();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    void skip(long j) throws IOException;
}
