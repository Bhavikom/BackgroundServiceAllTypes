package com.yasoka.spcallrecord.recorder.call.a.f;

import java.util.List;
import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection.IceServer;
import org.webrtc.SessionDescription;

/* compiled from: AppRTCClient */
public interface r {

    /* compiled from: AppRTCClient */
    public interface a {
        void a();

        void a(b bVar);

        void a(String str);

        void a(IceCandidate iceCandidate);

        void a(IceCandidate[] iceCandidateArr);

        void b(SessionDescription sessionDescription);

        void c(String str);
    }

    /* compiled from: AppRTCClient */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public final List<IceServer> f605a;

        /* renamed from: b reason: collision with root package name */
        public final boolean f606b;

        /* renamed from: c reason: collision with root package name */
        public final SessionDescription f607c;

        /* renamed from: d reason: collision with root package name */
        public final List<IceCandidate> f608d;

        public b(List<IceServer> list, boolean z, String str, String str2, String str3, SessionDescription sessionDescription, List<IceCandidate> list2) {
            this.f605a = list;
            this.f606b = z;
            this.f607c = sessionDescription;
            this.f608d = list2;
        }
    }
}
