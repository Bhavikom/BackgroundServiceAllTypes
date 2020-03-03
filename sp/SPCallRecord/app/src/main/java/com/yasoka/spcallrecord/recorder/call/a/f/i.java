package com.yasoka.spcallrecord.recorder.call.a.f;

import org.webrtc.PeerConnection.IceConnectionState;

/* compiled from: lambda */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ b f590a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ IceConnectionState f591b;

    public /* synthetic */ i(b bVar, IceConnectionState iceConnectionState) {
        this.f590a = bVar;
        this.f591b = iceConnectionState;
    }

    public final void run() {
        this.f590a.a(this.f591b);
    }
}
