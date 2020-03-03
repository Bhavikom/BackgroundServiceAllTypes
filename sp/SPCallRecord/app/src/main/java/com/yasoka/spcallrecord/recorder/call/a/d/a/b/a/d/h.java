package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.d;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.0 */
public final class h {

    /* renamed from: a reason: collision with root package name */
    private static final Logger f461a = Logger.getLogger(h.class.getName());

    private h() {
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                try {
                    f461a.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", e2);
                } catch (IOException e3) {
                    throw new AssertionError(e3);
                }
            }
        }
    }
}
