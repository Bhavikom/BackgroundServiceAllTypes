package com.yasoka.spcallrecord.recorder.call.a.f;

import org.webrtc.SessionDescription;

/* compiled from: lambda */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ e f594a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ SessionDescription f595b;

    public /* synthetic */ k(e eVar, SessionDescription sessionDescription) {
        this.f594a = eVar;
        this.f595b = sessionDescription;
    }

    public final void run() {
        this.f594a.a(this.f595b);
    }
}
