package com.yasoka.spcallrecord.recorder.call.e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* compiled from: Okio */
public final class l {

    /* renamed from: a reason: collision with root package name */
    static final Logger f3417a = Logger.getLogger(l.class.getName());

    /* compiled from: Okio */
    class a implements s {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ u f3418a;

        /* renamed from: b reason: collision with root package name */
        final /* synthetic */ OutputStream f3419b;

        a(u uVar, OutputStream outputStream) {
            this.f3418a = uVar;
            this.f3419b = outputStream;
        }

        public void close() throws IOException {
            this.f3419b.close();
        }

        public void flush() throws IOException {
            this.f3419b.flush();
        }

        public u timeout() {
            return this.f3418a;
        }

        public String toString() {
            StringBuilder a2 = a.b.a.a.a.a("sink(");
            a2.append(this.f3419b);
            a2.append(")");
            return a2.toString();
        }

        public void write(c cVar, long j) throws IOException {
            v.a(cVar.f3394b, 0, j);
            while (j > 0) {
                this.f3418a.throwIfReached();
                p pVar = cVar.f3393a;
                int min = (int) Math.min(j, (long) (pVar.f3432c - pVar.f3431b));
                this.f3419b.write(pVar.f3430a, pVar.f3431b, min);
                pVar.f3431b += min;
                long j2 = (long) min;
                j -= j2;
                cVar.f3394b -= j2;
                if (pVar.f3431b == pVar.f3432c) {
                    cVar.f3393a = pVar.a();
                    q.a(pVar);
                }
            }
        }
    }

    /* compiled from: Okio */
    class b implements t {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ u f3420a;

        /* renamed from: b reason: collision with root package name */
        final /* synthetic */ InputStream f3421b;

        b(u uVar, InputStream inputStream) {
            this.f3420a = uVar;
            this.f3421b = inputStream;
        }

        public void close() throws IOException {
            this.f3421b.close();
        }

        public long read(c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException(a.b.a.a.a.a("byteCount < 0: ", j));
            } else if (j == 0) {
                return 0;
            } else {
                try {
                    this.f3420a.throwIfReached();
                    p a2 = cVar.a(1);
                    int read = this.f3421b.read(a2.f3430a, a2.f3432c, (int) Math.min(j, (long) (8192 - a2.f3432c)));
                    if (read == -1) {
                        return -1;
                    }
                    a2.f3432c += read;
                    long j2 = (long) read;
                    cVar.f3394b += j2;
                    return j2;
                } catch (AssertionError e2) {
                    if (l.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public u timeout() {
            return this.f3420a;
        }

        public String toString() {
            StringBuilder a2 = a.b.a.a.a.a("source(");
            a2.append(this.f3421b);
            a2.append(")");
            return a2.toString();
        }
    }

    /* compiled from: Okio */
    class c implements s {
        c() {
        }

        public void close() throws IOException {
        }

        public void flush() throws IOException {
        }

        public u timeout() {
            return u.NONE;
        }

        public void write(c cVar, long j) throws IOException {
            cVar.skip(j);
        }
    }

    private l() {
    }

    public static e a(t tVar) {
        return new o(tVar);
    }

    public static s b(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file), new u());
        }
        throw new IllegalArgumentException("file == null");
    }

    public static t c(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static d a(s sVar) {
        return new n(sVar);
    }

    private static s a(OutputStream outputStream, u uVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (uVar != null) {
            return new a(uVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static t b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            m mVar = new m(socket);
            return mVar.source(a(socket.getInputStream(), (u) mVar));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    public static s a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            m mVar = new m(socket);
            return mVar.sink(a(socket.getOutputStream(), (u) mVar));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static t a(InputStream inputStream) {
        return a(inputStream, new u());
    }

    private static t a(InputStream inputStream, u uVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (uVar != null) {
            return new b(uVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static s a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file, true), new u());
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s a() {
        return new c();
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
