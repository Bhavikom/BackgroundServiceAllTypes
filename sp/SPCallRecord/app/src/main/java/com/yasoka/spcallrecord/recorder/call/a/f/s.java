package com.yasoka.spcallrecord.recorder.call.a.f;

import c.a.b.a.C0011a;
import com.crashlytics.android.Crashlytics;
import java.net.URISyntaxException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection.IceServer;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;

/* compiled from: DirectRTCClient */
public class s implements r {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final a.f.r.a f609a;

    /* renamed from: b reason: collision with root package name */
    private final String f610b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public io.socket.client.g f611c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public String f612d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public h f613e = h.NEW;

    /* compiled from: DirectRTCClient */
    class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ String f614a;

        a(String str) {
            this.f614a = str;
        }

        public void run() {
            try {
                if (s.this.f613e != h.ERROR) {
                    s.this.f613e = h.ERROR;
                    s.this.f609a.a(this.f614a);
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
    }

    /* compiled from: DirectRTCClient */
    class b implements Runnable {
        b() {
        }

        public void run() {
            s.this.c();
        }
    }

    /* compiled from: DirectRTCClient */
    class c implements Runnable {
        c() {
        }

        public void run() {
            s.this.d();
        }
    }

    /* compiled from: DirectRTCClient */
    class d implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ SessionDescription f618a;

        d(SessionDescription sessionDescription) {
            this.f618a = sessionDescription;
        }

        public void run() {
            try {
                if (s.this.f613e != h.CONNECTED) {
                    s.this.a("Sending offer SDP in non connected state.");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", this.f618a.type.canonicalForm());
                    jSONObject.put("sdp", this.f618a.description);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                s.this.b(jSONObject);
            } catch (Exception e3) {
                e3.getStackTrace();
                try {
                    e3.getStackTrace();
                    Crashlytics.logException(e3);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: DirectRTCClient */
    class e implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ SessionDescription f620a;

        e(SessionDescription sessionDescription) {
            this.f620a = sessionDescription;
        }

        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", this.f620a.type.canonicalForm());
                    jSONObject.put("sdp", this.f620a.description);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                s.this.b(jSONObject);
            } catch (Exception e3) {
                e3.getStackTrace();
                try {
                    e3.getStackTrace();
                    Crashlytics.logException(e3);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: DirectRTCClient */
    class f implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ IceCandidate f622a;

        f(IceCandidate iceCandidate) {
            this.f622a = iceCandidate;
        }

        public void run() {
            String str = "candidate";
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
                jSONObject.put("id", this.f622a.sdpMid);
                jSONObject.put(str, this.f622a.sdp);
                jSONObject.put("label", this.f622a.sdpMLineIndex);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (s.this.f613e != h.CONNECTED) {
                s.this.a("Sending ICE candidate in non connected state.");
            } else {
                s.this.b(jSONObject);
            }
        }
    }

    /* compiled from: DirectRTCClient */
    class g implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final /* synthetic */ IceCandidate[] f624a;

        g(IceCandidate[] iceCandidateArr) {
            this.f624a = iceCandidateArr;
        }

        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "remove-candidates");
                jSONObject.put("candidates", this.f624a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (s.this.f613e != h.CONNECTED) {
                s.this.a("Sending ICE candidate removals in non connected state.");
            } else {
                s.this.b(jSONObject);
            }
        }
    }

    /* compiled from: DirectRTCClient */
    private enum h {
        NEW,
        CONNECTED,
        CLOSED,
        ERROR
    }

    /* compiled from: DirectRTCClient */
    private class i {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public C0011a f631a = new a();
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public C0011a f632b = new b();

        /* compiled from: DirectRTCClient */
        class a implements C0011a {
            a() {
            }

            public void a(Object... objArr) {
                String str = "init";
                try {
                    JSONObject jSONObject = objArr[0];
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new IceServer("turn:turn-server-mobile.com:80", "my_username", "my_password"));
                    s.this.f612d = jSONObject.getString("from");
                    String string = jSONObject.getString("type");
                    JSONObject jSONObject2 = !string.equals(str) ? jSONObject.getJSONObject("payload") : null;
                    if (string.equals("candidate")) {
                        s.this.f609a.a(s.a(jSONObject2));
                    } else if (string.equals("remove-candidates")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("candidates");
                        IceCandidate[] iceCandidateArr = new IceCandidate[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            iceCandidateArr[i] = s.a(jSONArray.getJSONObject(i));
                        }
                        s.this.f609a.a(iceCandidateArr);
                    } else {
                        String str2 = "sdp";
                        if (string.equals("answer")) {
                            s.this.f609a.b(new SessionDescription(Type.fromCanonicalForm(string), jSONObject2.getString(str2)));
                        } else if (string.equals("offer")) {
                            SessionDescription sessionDescription = new SessionDescription(Type.fromCanonicalForm(string), jSONObject2.getString(str2));
                            a.f.r.b bVar = new a.f.r.b(linkedList, false, null, null, null, sessionDescription, null);
                            s.this.f613e = h.CONNECTED;
                            s.this.f609a.b(sessionDescription);
                            s.this.f609a.a(bVar);
                        } else if (string.equals(str)) {
                            s.this.f613e = h.CONNECTED;
                            a.f.r.b bVar2 = new a.f.r.b(linkedList, true, null, null, null, null, null);
                            s.this.f609a.a(bVar2);
                        } else {
                            s sVar = s.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unexpected TCP message: ");
                            sb.append(jSONObject);
                            sVar.a(sb.toString());
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    try {
                        e2.getStackTrace();
                        Crashlytics.logException(e2);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* compiled from: DirectRTCClient */
        class b implements C0011a {
            b() {
            }

            public void a(Object... objArr) {
                try {
                    String str = objArr[0];
                    if (s.this.f613e.equals(h.NEW)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", str);
                        s.this.f611c.a("readyToStream", jSONObject);
                        s.this.f609a.c(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* synthetic */ i(a aVar) {
        }
    }

    public s(a.f.r.a aVar, String str) {
        this.f609a = aVar;
        this.f610b = str;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
    public void c() {
        try {
            this.f613e = h.NEW;
            i iVar = new i(null);
            try {
                this.f611c = io.socket.client.b.a(this.f610b);
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
                e2.getStackTrace();
                Crashlytics.logException(e2);
            }
            this.f611c.b("id", iVar.f632b);
            this.f611c.b("message", iVar.f631a);
            this.f611c.c();
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            this.f613e = h.CLOSED;
            this.f609a.a();
            if (this.f611c != null) {
                this.f611c.b();
                this.f611c.a();
                this.f611c.b();
                this.f611c = null;
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
    public void b(JSONObject jSONObject) {
        String str = "type";
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("to", this.f612d);
                jSONObject2.put(str, jSONObject.get(str));
                jSONObject2.put("payload", jSONObject);
                this.f611c.a("message", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.getStackTrace();
            try {
                e3.getStackTrace();
                Crashlytics.logException(e3);
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ IceCandidate a(JSONObject jSONObject) throws JSONException {
        return new IceCandidate(jSONObject.getString("id"), jSONObject.getInt("label"), jSONObject.getString("candidate"));
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        new Thread(new a(str)).start();
    }

    public void a() {
        new Thread(new b()).start();
    }

    public void a(SessionDescription sessionDescription) {
        new Thread(new e(sessionDescription)).start();
    }

    public void b() {
        new Thread(new c()).start();
    }

    public void a(IceCandidate iceCandidate) {
        new Thread(new f(iceCandidate)).start();
    }

    public void b(SessionDescription sessionDescription) {
        new Thread(new d(sessionDescription)).start();
    }

    public void a(IceCandidate[] iceCandidateArr) {
        new Thread(new g(iceCandidateArr)).start();
    }
}
