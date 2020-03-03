package com.yasoka.spcallrecord.recorder.call.a.f;

import a.b.a.a.a;
import org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback;
import org.webrtc.audio.JavaAudioDeviceModule.AudioRecordStartErrorCode;

/* compiled from: PeerConnectionClient */
class t implements AudioRecordErrorCallback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ v f636a;

    t(v vVar) {
        this.f636a = vVar;
    }

    public void onWebRtcAudioRecordError(String str) {
        a.b("onWebRtcAudioRecordError: ", str);
        if (
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: IGET  (r0v3 boolean) = (wrap: a.f.v$d
              0x0007: INVOKE  (r0v2 a.f.v$d) = (wrap: a.f.v
              0x0005: IGET  (r0v1 a.f.v) = (r1v0 'this' a.f.t A[THIS]) a.f.t.a a.f.v) a.f.v.g(a.f.v):a.f.v$d type: STATIC) a.f.v.d.b boolean in method: a.f.t.onWebRtcAudioRecordError(java.lang.String):void, dex: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:115)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:316)
            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:76)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: INVOKE  (r0v2 a.f.v$d) = (wrap: a.f.v
              0x0005: IGET  (r0v1 a.f.v) = (r1v0 'this' a.f.t A[THIS]) a.f.t.a a.f.v) a.f.v.g(a.f.v):a.f.v$d type: STATIC in method: a.f.t.onWebRtcAudioRecordError(java.lang.String):void, dex: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:88)
            	at jadx.core.codegen.InsnGen.instanceField(InsnGen.java:164)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:411)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
            	... 24 more
            Caused by: java.util.ConcurrentModificationException
            	at java.util.ArrayList.removeIf(Unknown Source)
            	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:86)
            	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:90)
            	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:130)
            	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:134)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:892)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:669)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
            	... 29 more
            */
        /*
            this = this;
            java.lang.String r0 = "onWebRtcAudioRecordError: "
            a.b.a.a.a.b(r0, r2)
            a.f.v r0 = r1.f636a
            a.f.v$d r0 = r0.f642e
            boolean r0 = r0.f646b
            if (r0 == 0) goto L_0x0014
            a.f.v r0 = r1.f636a
            r0.b(r2)
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.t.onWebRtcAudioRecordError(java.lang.String):void");
    }

    public void onWebRtcAudioRecordInitError(String str) {
        a.b("onWebRtcAudioRecordInitError: ", str);
        if (this.f636a.f642e.f646b) {
            this.f636a.b(str);
        }
    }

    public void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onWebRtcAudioRecordStartError: ");
        sb.append(audioRecordStartErrorCode);
        sb.append(". ");
        sb.append(str);
        sb.toString();
        if (this.f636a.f642e.f646b) {
            this.f636a.b(str);
        }
    }
}
