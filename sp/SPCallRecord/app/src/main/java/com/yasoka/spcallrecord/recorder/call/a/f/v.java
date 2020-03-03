package com.yasoka.spcallrecord.recorder.call.a.f;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.Nullable;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.CalledByNative;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.DataChannel.Buffer;
import org.webrtc.DataChannel.Init;
import org.webrtc.DefaultVideoDecoderFactory;
import org.webrtc.DefaultVideoEncoderFactory;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.L;
import org.webrtc.Logging;
import org.webrtc.Logging.Severity;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaConstraints.KeyValuePair;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.BundlePolicy;
import org.webrtc.PeerConnection.ContinualGatheringPolicy;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.KeyType;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.PeerConnectionState;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnection.RtcpMuxPolicy;
import org.webrtc.PeerConnection.SdpSemantics;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.PeerConnection.TcpCandidatePolicy;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.PeerConnectionFactory.InitializationOptions;
import org.webrtc.PeerConnectionFactory.Options;
import org.webrtc.RtpParameters;
import org.webrtc.RtpParameters.Encoding;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SoftwareVideoDecoderFactory;
import org.webrtc.SoftwareVideoEncoderFactory;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoDecoderFactory;
import org.webrtc.VideoEncoderFactory;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;

/* compiled from: PeerConnectionClient */
public class v {
    /* access modifiers changed from: private */
    public static final ExecutorService I = Executors.newSingleThreadExecutor();
    @Nullable
    private VideoCapturer A;
    private boolean B = true;
    @Nullable
    private VideoTrack C;
    @Nullable
    private VideoTrack D;
    @Nullable
    private RtpSender E;
    private boolean F = true;
    @Nullable
    private AudioTrack G;
    @Nullable
    private DataChannel H;

    /* renamed from: a reason: collision with root package name */
    private final b f638a = new b(null);
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final e f639b = new e(null);

    /* renamed from: c reason: collision with root package name */
    private final EglBase f640c;

    /* renamed from: d reason: collision with root package name */
    private final Context f641d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final d f642e;
    /* access modifiers changed from: private */
    public final c f;
    /* access modifiers changed from: private */
    public final boolean g;
    @Nullable
    private PeerConnectionFactory h;
    /* access modifiers changed from: private */
    @Nullable
    public PeerConnection i;
    @Nullable
    private AudioSource j;
    @Nullable
    private SurfaceTextureHelper k;
    /* access modifiers changed from: private */
    public boolean l;
    private boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    @Nullable
    private VideoSource o;
    @Nullable
    private VideoSink p;
    private a.f.r.b q;
    private int r;
    private int s;
    private int t;
    private MediaConstraints u;
    private MediaConstraints v;
    @Nullable
    private List<VideoSink> w;
    /* access modifiers changed from: private */
    public boolean x;
    @Nullable
    private List<IceCandidate> y;
    /* access modifiers changed from: private */
    @Nullable
    public SessionDescription z;

    /* compiled from: PeerConnectionClient */
    public static class a {
    }

    /* compiled from: PeerConnectionClient */
    private class b implements Observer {

        /* compiled from: PeerConnectionClient */
        class a implements DataChannel.Observer {

            /* renamed from: a reason: collision with root package name */
            final /* synthetic */ DataChannel f644a;

            a(b bVar, DataChannel dataChannel) {
                this.f644a = dataChannel;
            }

            public void onBufferedAmountChange(long j) {
                StringBuilder a2 = a.b.a.a.a.a("Data channel buffered amount changed: ");
                a2.append(this.f644a.label());
                a2.append(": ");
                a2.append(this.f644a.state());
                a2.toString();
            }

            public void onMessage(Buffer buffer) {
                if (buffer.binary) {
                    StringBuilder a2 = a.b.a.a.a.a("Received binary msg over ");
                    a2.append(this.f644a);
                    a2.toString();
                    return;
                }
                ByteBuffer byteBuffer = buffer.data;
                byte[] bArr = new byte[byteBuffer.capacity()];
                byteBuffer.get(bArr);
                String str = new String(bArr, Charset.forName("UTF-8"));
                StringBuilder sb = new StringBuilder();
                sb.append("Got msg: ");
                sb.append(str);
                sb.append(" over ");
                sb.append(this.f644a);
                sb.toString();
            }

            public void onStateChange() {
                StringBuilder a2 = a.b.a.a.a.a("Data channel state changed: ");
                a2.append(this.f644a.label());
                a2.append(": ");
                a2.append(this.f644a.state());
                a2.toString();
            }
        }

        /* synthetic */ b(t tVar) {
        }

        public /* synthetic */ void a(IceCandidate iceCandidate) {
            v.this.f.onIceCandidate(iceCandidate);
        }

        public void onAddStream(MediaStream mediaStream) {
        }

        public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
        }

        @CalledByNative("Observer")
        public /* synthetic */ void onConnectionChange(PeerConnectionState peerConnectionState) {
            L.$default$onConnectionChange(this, peerConnectionState);
        }

        public void onDataChannel(DataChannel dataChannel) {
            StringBuilder a2 = a.b.a.a.a.a("New Data channel ");
            a2.append(dataChannel.label());
            a2.toString();
            if (v.this.g) {
                dataChannel.registerObserver(new a(this, dataChannel));
            }
        }

        public void onIceCandidate(IceCandidate iceCandidate) {
            v.I.execute(new j(this, iceCandidate));
        }

        public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
            v.I.execute(new h(this, iceCandidateArr));
        }

        public void onIceConnectionChange(IceConnectionState iceConnectionState) {
            v.I.execute(new i(this, iceConnectionState));
        }

        public void onIceConnectionReceivingChange(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("IceConnectionReceiving changed to ");
            sb.append(z);
            sb.toString();
        }

        public void onIceGatheringChange(IceGatheringState iceGatheringState) {
            StringBuilder sb = new StringBuilder();
            sb.append("IceGatheringState: ");
            sb.append(iceGatheringState);
            sb.toString();
        }

        public void onRemoveStream(MediaStream mediaStream) {
        }

        public void onRenegotiationNeeded() {
        }

        @CalledByNative("Observer")
        public /* synthetic */ void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
            L.$default$onSelectedCandidatePairChanged(this, candidatePairChangeEvent);
        }

        public void onSignalingChange(SignalingState signalingState) {
            StringBuilder sb = new StringBuilder();
            sb.append("SignalingState: ");
            sb.append(signalingState);
            sb.toString();
        }

        @CalledByNative("Observer")
        public /* synthetic */ void onStandardizedIceConnectionChange(IceConnectionState iceConnectionState) {
            L.$default$onStandardizedIceConnectionChange(this, iceConnectionState);
        }

        @CalledByNative("Observer")
        public /* synthetic */ void onTrack(RtpTransceiver rtpTransceiver) {
            L.$default$onTrack(this, rtpTransceiver);
        }

        public /* synthetic */ void a(IceCandidate[] iceCandidateArr) {
            v.this.f.onIceCandidatesRemoved(iceCandidateArr);
        }

        public /* synthetic */ void a(IceConnectionState iceConnectionState) {
            StringBuilder sb = new StringBuilder();
            sb.append("IceConnectionState: ");
            sb.append(iceConnectionState);
            sb.toString();
            if (iceConnectionState == IceConnectionState.CONNECTED) {
                v.this.f.b();
            } else if (iceConnectionState == IceConnectionState.DISCONNECTED) {
                v.this.f.c();
            } else if (iceConnectionState == IceConnectionState.FAILED) {
                v.this.b("ICE connection failed.");
            }
        }
    }

    /* compiled from: PeerConnectionClient */
    public interface c {
        void a(SessionDescription sessionDescription);

        void b();

        void b(String str);

        void c();

        void d();

        void onIceCandidate(IceCandidate iceCandidate);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* compiled from: PeerConnectionClient */
    public static class d {

        /* renamed from: a reason: collision with root package name */
        public final boolean f645a;

        /* renamed from: b reason: collision with root package name */
        public final boolean f646b;

        /* renamed from: c reason: collision with root package name */
        public final boolean f647c;

        /* renamed from: d reason: collision with root package name */
        public final boolean f648d;

        /* renamed from: e reason: collision with root package name */
        public final int f649e;
        public final int f;
        public final int g;
        public final int h;
        public final String i;
        public final boolean j;
        public final boolean k;
        public final int l;
        public final String m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final boolean q;
        public final boolean r;
        public final boolean s;
        /* access modifiers changed from: private */
        public final a t;

        public d(boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, int i5, String str, boolean z5, boolean z6, int i6, String str2, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
            this.f645a = z;
            this.f646b = z2;
            this.f647c = z3;
            this.f648d = z4;
            this.f649e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = str;
            this.k = z6;
            this.j = z5;
            this.l = i6;
            this.m = str2;
            this.n = z7;
            this.o = z8;
            this.p = z10;
            this.q = z11;
            this.r = z13;
            this.s = z14;
        }
    }

    /* compiled from: PeerConnectionClient */
    private class e implements SdpObserver {
        /* synthetic */ e(t tVar) {
        }

        public /* synthetic */ void a(SessionDescription sessionDescription) {
            if (v.this.i != null && !v.this.n) {
                StringBuilder a2 = a.b.a.a.a.a("Set local SDP from ");
                a2.append(sessionDescription.type);
                a2.toString();
                v.this.i.setLocalDescription(v.this.f639b, sessionDescription);
            }
        }

        public void onCreateFailure(String str) {
            v.this.b(a.b.a.a.a.c("createSDP error: ", str));
        }

        public void onCreateSuccess(SessionDescription sessionDescription) {
            if (v.this.z != null) {
                v.this.b("Multiple SDP create.");
                return;
            }
            String str = sessionDescription.description;
            if (v.this.l) {
                str = v.b(str, "ISAC", true);
            }
            if (v.this.n()) {
                str = v.b(str, v.b(v.this.f642e), false);
            }
            SessionDescription sessionDescription2 = new SessionDescription(sessionDescription.type, str);
            v.this.z = sessionDescription2;
            v.I.execute(new k(this, sessionDescription2));
        }

        public void onSetFailure(String str) {
            v.this.b(a.b.a.a.a.c("setSDP error: ", str));
        }

        public void onSetSuccess() {
            v.I.execute(new l(this));
        }

        public /* synthetic */ void a() {
            if (v.this.i != null && !v.this.n) {
                if (v.this.x) {
                    if (v.this.i.getRemoteDescription() == null) {
                        v.this.f.a(v.this.z);
                    } else {
                        v.this.m();
                    }
                } else if (v.this.i.getLocalDescription() != null) {
                    v.this.f.a(v.this.z);
                    v.this.m();
                }
            }
        }
    }

    public v(Context context, EglBase eglBase, d dVar, c cVar) {
        this.f640c = eglBase;
        this.f641d = context;
        this.f = cVar;
        this.f642e = dVar;
        dVar.t;
        this.g = false;
        StringBuilder a2 = a.b.a.a.a.a("Preferred video codec: ");
        a2.append(b(dVar));
        a2.toString();
        String str = "";
        if (dVar.k) {
            str = a.b.a.a.a.c(str, "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/");
        }
        String c2 = a.b.a.a.a.c(str, "WebRTC-IntelVP8/Enabled/");
        if (dVar.s) {
            c2 = a.b.a.a.a.c(c2, "WebRTC-Audio-MinimizeResamplingOnMobile/Enabled/");
        }
        I.execute(new b(c2, dVar, context));
    }

    private void l() {
        try {
            if (this.h != null) {
                if (!this.n) {
                    this.y = new ArrayList();
                    RTCConfiguration rTCConfiguration = new RTCConfiguration(this.q.f605a);
                    rTCConfiguration.tcpCandidatePolicy = TcpCandidatePolicy.DISABLED;
                    rTCConfiguration.bundlePolicy = BundlePolicy.MAXBUNDLE;
                    rTCConfiguration.rtcpMuxPolicy = RtcpMuxPolicy.REQUIRE;
                    rTCConfiguration.continualGatheringPolicy = ContinualGatheringPolicy.GATHER_CONTINUALLY;
                    rTCConfiguration.keyType = KeyType.ECDSA;
                    rTCConfiguration.enableDtlsSrtp = Boolean.valueOf(!this.f642e.f647c);
                    rTCConfiguration.sdpSemantics = SdpSemantics.UNIFIED_PLAN;
                    this.i = this.h.createPeerConnection(rTCConfiguration, (Observer) this.f638a);
                    VideoTrack videoTrack = null;
                    if (!this.g) {
                        this.x = false;
                        Logging.enableLogToDebugOutput(Severity.LS_VERBOSE);
                        List singletonList = Collections.singletonList("ARDAMS");
                        if (n()) {
                            this.i.addTrack(a(this.A), singletonList);
                            Iterator it = this.i.getTransceivers().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                MediaStreamTrack track = ((RtpTransceiver) it.next()).getReceiver().track();
                                if (track instanceof VideoTrack) {
                                    videoTrack = (VideoTrack) track;
                                    break;
                                }
                            }
                            this.D = videoTrack;
                            this.D.setEnabled(this.B);
                            for (VideoSink addSink : this.w) {
                                this.D.addSink(addSink);
                            }
                        }
                        if (this.f642e.f646b) {
                            PeerConnection peerConnection = this.i;
                            this.j = this.h.createAudioSource(this.u);
                            this.G = this.h.createAudioTrack("ARDAMSa0", this.j);
                            this.G.setEnabled(this.F);
                            peerConnection.addTrack(this.G, singletonList);
                        }
                        if (n()) {
                            for (RtpSender rtpSender : this.i.getSenders()) {
                                if (rtpSender.track() != null && rtpSender.track().kind().equals(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                                    this.E = rtpSender;
                                }
                            }
                        }
                        return;
                    }
                    new Init();
                    this.f642e.t;
                    throw null;
                }
            }
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (this.y != null) {
            StringBuilder a2 = a.b.a.a.a.a("Add ");
            a2.append(this.y.size());
            a2.append(" remote candidates");
            a2.toString();
            for (IceCandidate addIceCandidate : this.y) {
                this.i.addIceCandidate(addIceCandidate);
            }
            this.y = null;
        }
    }

    /* access modifiers changed from: private */
    public boolean n() {
        return this.f642e.f645a && this.A != null;
    }

    /* access modifiers changed from: private */
    public static String b(d dVar) {
        char c2;
        String str = dVar.i;
        String str2 = "VP9";
        String str3 = "VP8";
        switch (str.hashCode()) {
            case -2140422726:
                if (str.equals("H264 High")) {
                    c2 = 2;
                    break;
                }
            case -1031013795:
                if (str.equals("H264 Baseline")) {
                    c2 = 3;
                    break;
                }
            case 85182:
                if (str.equals(str3)) {
                    c2 = 0;
                    break;
                }
            case 85183:
                if (str.equals(str2)) {
                    c2 = 1;
                    break;
                }
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            return str3;
        }
        if (c2 != 1) {
            return (c2 == 2 || c2 == 3) ? "H264" : str3;
        }
        return str2;
    }

    /* access modifiers changed from: private */
    public void j() {
        try {
            if (this.h != null && this.f642e.o) {
                this.h.stopAecDump();
            }
        } catch (Exception e2) {
            try {
                e2.getStackTrace();
            } catch (Exception e3) {
                e3.getStackTrace();
                return;
            }
        }
        try {
            if (this.H != null) {
                this.H.dispose();
                this.H = null;
            }
        } catch (Exception e4) {
            e4.getStackTrace();
        }
        try {
            if (this.i != null) {
                this.i.dispose();
                this.i = null;
            }
        } catch (Exception e5) {
            e5.getStackTrace();
        }
        try {
            if (this.j != null) {
                this.j.dispose();
                this.j = null;
            }
        } catch (Exception e6) {
            e6.getStackTrace();
        }
        try {
            if (this.A != null) {
                this.A.stopCapture();
                this.m = true;
                this.A.dispose();
                this.A = null;
            }
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        } catch (Exception e8) {
            e8.getStackTrace();
        }
        try {
            if (this.o != null) {
                this.o.dispose();
                this.o = null;
            }
        } catch (Exception e9) {
            e9.getStackTrace();
        }
        try {
            if (this.k != null) {
                this.k.dispose();
                this.k = null;
            }
        } catch (Exception e10) {
            e10.getStackTrace();
        }
        this.p = null;
        this.w = null;
        try {
            if (this.h != null) {
                this.h.dispose();
                this.h = null;
            }
        } catch (Exception e11) {
            e11.getStackTrace();
        }
        try {
            this.f640c.release();
        } catch (Exception e12) {
            e12.getStackTrace();
        }
        try {
            this.f.d();
        } catch (Exception e13) {
            e13.getStackTrace();
        }
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private void k() {
        String str = "false";
        try {
            if (n()) {
                this.r = this.f642e.f649e;
                this.s = this.f642e.f;
                this.t = this.f642e.g;
                if (this.r == 0 || this.s == 0) {
                    this.r = 1280;
                    this.s = 720;
                }
                if (this.t == 0) {
                    this.t = 30;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Capturing format: ");
                sb.append(this.r);
                sb.append("x");
                sb.append(this.s);
                sb.append("@");
                sb.append(this.t);
                Logging.d("PCRTCClient", sb.toString());
            }
            this.u = new MediaConstraints();
            if (this.f642e.n) {
                this.u.mandatory.add(new KeyValuePair("googEchoCancellation", str));
                this.u.mandatory.add(new KeyValuePair("googAutoGainControl", str));
                this.u.mandatory.add(new KeyValuePair("googHighpassFilter", str));
                this.u.mandatory.add(new KeyValuePair("googNoiseSuppression", str));
            }
            this.v = new MediaConstraints();
            this.v.mandatory.add(new KeyValuePair("OfferToReceiveAudio", "true"));
            this.v.mandatory.add(new KeyValuePair("OfferToReceiveVideo", Boolean.toString(n())));
        } catch (Exception e2) {
            e2.getStackTrace();
            try {
                e2.getStackTrace();
                Crashlytics.logException(e2);
            } catch (Exception unused) {
            }
        }
    }

    public void c() {
        I.execute(new m(this));
    }

    public /* synthetic */ void d() {
        PeerConnection peerConnection = this.i;
        if (peerConnection != null && !this.n) {
            this.x = false;
            peerConnection.createAnswer(this.f639b, this.v);
        }
    }

    public /* synthetic */ void e() {
        PeerConnection peerConnection = this.i;
        if (peerConnection != null && !this.n) {
            this.x = true;
            peerConnection.createOffer(this.f639b, this.v);
        }
    }

    public /* synthetic */ void f() {
        try {
            k();
            l();
        } catch (Exception e2) {
            StringBuilder a2 = a.b.a.a.a.a("Failed to create peer connection: ");
            a2.append(e2.getMessage());
            b(a2.toString());
            throw e2;
        }
    }

    public /* synthetic */ void g() {
        VideoCapturer videoCapturer = this.A;
        if (videoCapturer != null && this.m) {
            videoCapturer.startCapture(this.r, this.s, this.t);
            this.m = false;
        }
    }

    public void h() {
        I.execute(new f(this));
    }

    /* access modifiers changed from: private */
    public static String b(String str, String str2, boolean z2) {
        String str3;
        String str4 = "\r\n";
        String[] split = str.split(str4);
        String str5 = z2 ? "m=audio " : "m=video ";
        int i2 = 0;
        while (true) {
            if (i2 >= split.length) {
                i2 = -1;
                break;
            } else if (split[i2].startsWith(str5)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1) {
            a.b.a.a.a.b("No mediaDescription line, so can't prefer ", str2);
            return str;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("^a=rtpmap:(\\d+) ");
        sb.append(str2);
        sb.append("(/\\d+)+[\r]?$");
        Pattern compile = Pattern.compile(sb.toString());
        for (String matcher : split) {
            Matcher matcher2 = compile.matcher(matcher);
            if (matcher2.matches()) {
                arrayList.add(matcher2.group(1));
            }
        }
        if (arrayList.isEmpty()) {
            a.b.a.a.a.b("No payload types with name ", str2);
            return str;
        }
        String str6 = split[i2];
        String str7 = " ";
        List asList = Arrays.asList(str6.split(str7));
        if (asList.size() <= 3) {
            a.b.a.a.a.b("Wrong SDP media description format: ", str6);
            str3 = null;
        } else {
            List subList = asList.subList(0, 3);
            ArrayList arrayList2 = new ArrayList(asList.subList(3, asList.size()));
            arrayList2.removeAll(arrayList);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(subList);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            str3 = a((Iterable<? extends CharSequence>) arrayList3, str7, false);
        }
        if (str3 == null) {
            return str;
        }
        StringBuilder a2 = a.b.a.a.a.a("Change media description from: ");
        a2.append(split[i2]);
        a2.append(" to ");
        a2.append(str3);
        a2.toString();
        split[i2] = str3;
        return a((Iterable<? extends CharSequence>) Arrays.asList(split), str4, true);
    }

    static /* synthetic */ void a(String str, d dVar, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Initialize WebRTC. Field trials: ");
        sb.append(str);
        sb.append(" Enable video HW acceleration: ");
        sb.append(dVar.j);
        sb.toString();
        PeerConnectionFactory.initialize(InitializationOptions.builder(context).setFieldTrials(str).setEnableInternalTracer(false).createInitializationOptions());
    }

    private static String a(Iterable<? extends CharSequence> iterable, String str, boolean z2) {
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder((CharSequence) it.next());
        while (it.hasNext()) {
            sb.append(str);
            sb.append((CharSequence) it.next());
        }
        if (z2) {
            sb.append(str);
        }
        return sb.toString();
    }

    public void a(Options options) {
        if (this.h == null) {
            I.execute(new n(this, options));
            return;
        }
        throw new IllegalStateException("PeerConnectionFactory has already been constructed");
    }

    public void a(VideoSink videoSink, List<VideoSink> list, VideoCapturer videoCapturer, a.f.r.b bVar) {
        if (this.f642e != null) {
            this.p = videoSink;
            this.w = list;
            this.A = videoCapturer;
            this.q = bVar;
            I.execute(new a(this));
        }
    }

    public void a() {
        I.execute(new g(this));
    }

    public void a(IceCandidate iceCandidate) {
        I.execute(new d(this, iceCandidate));
    }

    public /* synthetic */ void a(IceCandidate[] iceCandidateArr) {
        if (this.i != null && !this.n) {
            m();
            this.i.removeIceCandidates(iceCandidateArr);
        }
    }

    public /* synthetic */ void b(Options options) {
        VideoEncoderFactory videoEncoderFactory;
        VideoDecoderFactory videoDecoderFactory;
        boolean z2 = false;
        this.n = false;
        if (this.f642e.f648d) {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb.append(File.separator);
            sb.append("webrtc-trace.txt");
            PeerConnectionFactory.startInternalTracingCapture(sb.toString());
        }
        String str = this.f642e.m;
        if (str != null && str.equals("ISAC")) {
            z2 = true;
        }
        this.l = z2;
        boolean z3 = this.f642e.p;
        t tVar = new t(this);
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.f641d).setUseHardwareAcousticEchoCanceler(!this.f642e.q).setUseHardwareNoiseSuppressor(!this.f642e.r).setAudioRecordErrorCallback(tVar).setAudioTrackErrorCallback(new u(this)).createAudioDeviceModule();
        if (options != null) {
            StringBuilder a2 = a.b.a.a.a.a("Factory networkIgnoreMask option: ");
            a2.append(options.networkIgnoreMask);
            a2.toString();
        }
        boolean equals = "H264 High".equals(this.f642e.i);
        if (this.f642e.j) {
            videoEncoderFactory = new DefaultVideoEncoderFactory(this.f640c.getEglBaseContext(), true, equals);
            videoDecoderFactory = new DefaultVideoDecoderFactory(this.f640c.getEglBaseContext());
        } else {
            videoEncoderFactory = new SoftwareVideoEncoderFactory();
            videoDecoderFactory = new SoftwareVideoDecoderFactory();
        }
        this.h = PeerConnectionFactory.builder().setOptions(options).setAudioDeviceModule(createAudioDeviceModule).setVideoEncoderFactory(videoEncoderFactory).setVideoDecoderFactory(videoDecoderFactory).createPeerConnectionFactory();
    }

    public /* synthetic */ void a(SessionDescription sessionDescription) {
        String str;
        String str2;
        if (this.i != null && !this.n) {
            String str3 = sessionDescription.description;
            boolean z2 = true;
            if (this.l) {
                str3 = b(str3, "ISAC", true);
            }
            if (n()) {
                str3 = b(str3, b(this.f642e), false);
            }
            int i2 = this.f642e.l;
            if (i2 > 0) {
                String str4 = "opus";
                String str5 = "\r\n";
                String[] split = str3.split(str5);
                StringBuilder sb = new StringBuilder();
                sb.append("^a=rtpmap:(\\d+) ");
                sb.append(str4);
                sb.append("(/\\d+)+[\r]?$");
                Pattern compile = Pattern.compile(sb.toString());
                int i3 = 0;
                while (true) {
                    if (i3 >= split.length) {
                        i3 = -1;
                        str = null;
                        break;
                    }
                    Matcher matcher = compile.matcher(split[i3]);
                    if (matcher.matches()) {
                        str = matcher.group(1);
                        break;
                    }
                    i3++;
                }
                if (str == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("No rtpmap for ");
                    sb2.append(str4);
                    sb2.append(" codec");
                    sb2.toString();
                } else {
                    String str6 = "Found ";
                    StringBuilder a2 = a.b.a.a.a.a(str6, str4, " rtpmap ", str, " at ");
                    a2.append(split[i3]);
                    a2.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("^a=fmtp:");
                    sb3.append(str);
                    sb3.append(" \\w+=\\d+.*[\r]?$");
                    Pattern compile2 = Pattern.compile(sb3.toString());
                    int i4 = 0;
                    while (true) {
                        str2 = " ";
                        if (i4 >= split.length) {
                            z2 = false;
                            break;
                        } else if (compile2.matcher(split[i4]).matches()) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str6);
                            sb4.append(str4);
                            sb4.append(str2);
                            sb4.append(split[i4]);
                            sb4.toString();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(split[i4]);
                            sb5.append("; maxaveragebitrate=");
                            sb5.append(i2 * 1000);
                            split[i4] = sb5.toString();
                            StringBuilder a3 = a.b.a.a.a.a("Update remote SDP line: ");
                            a3.append(split[i4]);
                            a3.toString();
                            break;
                        } else {
                            i4++;
                        }
                    }
                    StringBuilder sb6 = new StringBuilder();
                    for (int i5 = 0; i5 < split.length; i5++) {
                        sb6.append(split[i5]);
                        sb6.append(str5);
                        if (!z2 && i5 == i3) {
                            StringBuilder a4 = a.b.a.a.a.a("a=fmtp:", str, str2, "maxaveragebitrate", "=");
                            a4.append(i2 * 1000);
                            String sb7 = a4.toString();
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("Add remote SDP line: ");
                            sb8.append(sb7);
                            sb8.toString();
                            sb6.append(sb7);
                            sb6.append(str5);
                        }
                    }
                    str3 = sb6.toString();
                }
            }
            this.i.setRemoteDescription(this.f639b, new SessionDescription(sessionDescription.type, str3));
        }
    }

    public void b() {
        I.execute(new q(this));
    }

    public /* synthetic */ void b(IceCandidate iceCandidate) {
        PeerConnection peerConnection = this.i;
        if (peerConnection != null && !this.n) {
            List<IceCandidate> list = this.y;
            if (list != null) {
                list.add(iceCandidate);
            } else {
                peerConnection.addIceCandidate(iceCandidate);
            }
        }
    }

    public /* synthetic */ void a(Integer num) {
        Integer num2;
        if (!(this.i == null || this.E == null || this.n)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested max video bitrate: ");
            sb.append(num);
            sb.toString();
            RtpSender rtpSender = this.E;
            if (rtpSender != null) {
                RtpParameters parameters = rtpSender.getParameters();
                if (parameters.encodings.size() != 0) {
                    for (Encoding encoding : parameters.encodings) {
                        if (num == null) {
                            num2 = null;
                        } else {
                            num2 = Integer.valueOf(num.intValue() * 1000);
                        }
                        encoding.maxBitrateBps = num2;
                    }
                    boolean parameters2 = this.E.setParameters(parameters);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Configured max video bitrate to: ");
                    sb2.append(num);
                    sb2.toString();
                }
            }
        }
    }

    public void b(IceCandidate[] iceCandidateArr) {
        I.execute(new c(this, iceCandidateArr));
    }

    public void b(SessionDescription sessionDescription) {
        I.execute(new p(this, sessionDescription));
    }

    public void b(@Nullable Integer num) {
        I.execute(new e(this, num));
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        a.b.a.a.a.b("Peerconnection error: ", str);
        I.execute(new o(this, str));
    }

    public /* synthetic */ void a(String str) {
        if (!this.n) {
            this.f.b(str);
            this.n = true;
        }
    }

    @Nullable
    private VideoTrack a(VideoCapturer videoCapturer) {
        this.k = SurfaceTextureHelper.create("CaptureThread", this.f640c.getEglBaseContext());
        this.o = this.h.createVideoSource(videoCapturer.isScreencast());
        videoCapturer.initialize(this.k, this.f641d, this.o.getCapturerObserver());
        videoCapturer.startCapture(this.r, this.s, this.t);
        this.C = this.h.createVideoTrack("ARDAMSv0", this.o);
        this.C.setEnabled(this.B);
        this.C.addSink(this.p);
        return this.C;
    }
}
