package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.d;

import java.io.PrintStream;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public final class j {

    /* renamed from: a reason: collision with root package name */
    private static final l f464a;

    /* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
    static final class a extends l {
        a() {
        }

        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    static {
        l lVar;
        Integer num = null;
        try {
            num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = a.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            lVar = new a();
        }
        if (num == null || num.intValue() < 19) {
            if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                lVar = new m();
            } else {
                lVar = new a();
            }
            f464a = lVar;
            if (num == null) {
                num.intValue();
                return;
            }
            return;
        }
        lVar = new o();
        f464a = lVar;
        if (num == null) {
        }
    }

    public static void a(Throwable th, Throwable th2) {
        f464a.a(th, th2);
    }
}
