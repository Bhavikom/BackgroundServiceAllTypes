package com.yasoka.spcallrecord.recorder.call.a.f;

import org.webrtc.IceCandidate;

/* compiled from: lambda */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ v f580a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ IceCandidate[] f581b;

    public /* synthetic */ c(v vVar, IceCandidate[] iceCandidateArr) {
        this.f580a = vVar;
        this.f581b = iceCandidateArr;
    }

    public final void run() {
        this.f580a.a(this.f581b);
    }
}
