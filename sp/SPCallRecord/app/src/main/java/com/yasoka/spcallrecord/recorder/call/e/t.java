package com.yasoka.spcallrecord.recorder.call.e;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source */
public interface t extends Closeable {
    void close() throws IOException;

    long read(c cVar, long j) throws IOException;

    u timeout();
}
