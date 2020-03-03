package com.yasoka.spcallrecord.recorder.call.a.f;

import org.webrtc.IceCandidate;

/* compiled from: lambda */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ b f592a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ IceCandidate f593b;

    public /* synthetic */ j(b bVar, IceCandidate iceCandidate) {
        this.f592a = bVar;
        this.f593b = iceCandidate;
    }

    public final void run() {
        this.f592a.a(this.f593b);
    }
}
