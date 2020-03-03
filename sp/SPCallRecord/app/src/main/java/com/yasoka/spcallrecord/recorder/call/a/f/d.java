package com.yasoka.spcallrecord.recorder.call.a.f;

import org.webrtc.IceCandidate;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ v f582a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ IceCandidate f583b;

    public /* synthetic */ d(v vVar, IceCandidate iceCandidate) {
        this.f582a = vVar;
        this.f583b = iceCandidate;
    }

    public final void run() {
        this.f582a.b(this.f583b);
    }
}
