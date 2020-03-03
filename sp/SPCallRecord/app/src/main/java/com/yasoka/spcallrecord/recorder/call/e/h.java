package com.yasoka.spcallrecord.recorder.call.e;

import java.io.IOException;

/* compiled from: ForwardingSource */
public abstract class h implements t {
    private final t delegate;

    public h(t tVar) {
        if (tVar != null) {
            this.delegate = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final t delegate() {
        return this.delegate;
    }

    public long read(c cVar, long j) throws IOException {
        return this.delegate.read(cVar, j);
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
}
