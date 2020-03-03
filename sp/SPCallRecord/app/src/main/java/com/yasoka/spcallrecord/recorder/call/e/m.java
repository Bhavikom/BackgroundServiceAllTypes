package com.yasoka.spcallrecord.recorder.call.e;

import a.b.a.a.a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio */
final class m extends a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Socket f3422a;

    m(Socket socket) {
        this.f3422a = socket;
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
        String str = "Failed to close timed out socket ";
        try {
            this.f3422a.close();
        } catch (Exception e2) {
            Logger logger = l.f3417a;
            Level level = Level.WARNING;
            StringBuilder a2 = a.a(str);
            a2.append(this.f3422a);
            logger.log(level, a2.toString(), e2);
        } catch (AssertionError e3) {
            if (l.a(e3)) {
                Logger logger2 = l.f3417a;
                Level level2 = Level.WARNING;
                StringBuilder a3 = a.a(str);
                a3.append(this.f3422a);
                logger2.log(level2, a3.toString(), e3);
                return;
            }
            throw e3;
        }
    }
}
