package com.yasoka.spcallrecord.recorder.call.a.f;

import a.b.a.a.a;
import org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback;
import org.webrtc.audio.JavaAudioDeviceModule.AudioTrackStartErrorCode;

/* compiled from: PeerConnectionClient */
class u implements AudioTrackErrorCallback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ v f637a;

    u(v vVar) {
        this.f637a = vVar;
    }

    public void onWebRtcAudioTrackError(String str) {
        a.b("onWebRtcAudioTrackError: ", str);
        if (this.f637a.f642e.f646b) {
            this.f637a.b(str);
        }
    }

    public void onWebRtcAudioTrackInitError(String str) {
        a.b("onWebRtcAudioTrackInitError: ", str);
        if (this.f637a.f642e.f646b) {
            this.f637a.b(str);
        }
    }

    public void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onWebRtcAudioTrackStartError: ");
        sb.append(audioTrackStartErrorCode);
        sb.append(". ");
        sb.append(str);
        sb.toString();
        if (this.f637a.f642e.f646b) {
            this.f637a.b(str);
        }
    }
}
