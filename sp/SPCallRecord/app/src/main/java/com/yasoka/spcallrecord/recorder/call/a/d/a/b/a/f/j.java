package com.yasoka.spcallrecord.recorder.call.a.d.a.b.a.f;

import a.d.a.b.b.d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;

public class j implements d {

    static abstract class a extends e<a.d.a.b.b.d.b> {
        protected f n = new l(this);

        public a(c cVar) {
            super(cVar);
        }

        /* access modifiers changed from: protected */
        public /* synthetic */ g a(Status status) {
            return new b(status, false);
        }
    }

    static class b implements a.d.a.b.b.d.b {

        /* renamed from: a reason: collision with root package name */
        private Status f505a;

        /* renamed from: b reason: collision with root package name */
        private boolean f506b;

        public b(Status status, boolean z) {
            this.f505a = status;
            this.f506b = z;
        }

        public final Status o() {
            return this.f505a;
        }

        public final boolean p() {
            Status status = this.f505a;
            if (status == null || !status.t()) {
                return false;
            }
            return this.f506b;
        }
    }

    public com.google.android.gms.common.api.d<a.d.a.b.b.d.b> a(c cVar) {
        return cVar.a(new k(cVar));
    }
}
