package com.yasoka.spcallrecord.recorder.call.e;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink */
public interface s extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    u timeout();

    void write(c cVar, long j) throws IOException;
}
