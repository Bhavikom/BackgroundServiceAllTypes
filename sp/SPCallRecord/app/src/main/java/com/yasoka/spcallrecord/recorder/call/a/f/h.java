package com.yasoka.spcallrecord.recorder.call.a.f;

import org.webrtc.IceCandidate;

/* compiled from: lambda */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ b f588a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ IceCandidate[] f589b;

    public /* synthetic */ h(b bVar, IceCandidate[] iceCandidateArr) {
        this.f588a = bVar;
        this.f589b = iceCandidateArr;
    }

    public final void run() {
        this.f588a.a(this.f589b);
    }
}
