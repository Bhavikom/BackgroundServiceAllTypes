package com.yasoka.spcallrecord.recorder.call.e;

import java.io.IOException;

/* compiled from: ForwardingSink */
public abstract class g implements s {
    private final s delegate;

    public g(s sVar) {
        if (sVar != null) {
            this.delegate = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final s delegate() {
        return this.delegate;
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public u timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.delegate.toString());
        sb.append(")");
        return sb.toString();
    }

    public void write(c cVar, long j) throws IOException {
        this.delegate.write(cVar, j);
    }
}
