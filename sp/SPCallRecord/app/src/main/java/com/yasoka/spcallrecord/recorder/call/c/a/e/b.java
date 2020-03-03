package com.yasoka.spcallrecord.recorder.call.c.a.e;

import c.a.e.a.C0013a;
import c.a.e.d.a.C0015a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IOParser */
public final class b implements d {
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public static final Logger f684b = Logger.getLogger(b.class.getName());

    /* compiled from: IOParser */
    static class a {

        /* renamed from: a reason: collision with root package name */
        public c f685a;

        /* renamed from: b reason: collision with root package name */
        List<byte[]> f686b = new ArrayList();

        a(c cVar) {
            this.f685a = cVar;
        }

        public void a() {
            this.f685a = null;
            this.f686b = new ArrayList();
        }
    }

    /* renamed from: c.a.e.b$b reason: collision with other inner class name */
    /* compiled from: IOParser */
    public static final class C0014b implements c.a.e.d.a {

        /* renamed from: a reason: collision with root package name */
        a f687a = null;

        /* renamed from: b reason: collision with root package name */
        private C0015a f688b;

        public void a(byte[] bArr) {
            a aVar = this.f687a;
            if (aVar != null) {
                aVar.f686b.add(bArr);
                int size = aVar.f686b.size();
                c cVar = aVar.f685a;
                if (size == cVar.f693e) {
                    List<byte[]> list = aVar.f686b;
                    a.a(cVar, (byte[][]) list.toArray(new byte[list.size()][]));
                    aVar.a();
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    this.f687a = null;
                    C0015a aVar2 = this.f688b;
                    if (aVar2 != null) {
                        aVar2.a(cVar);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("got binary data when not reconstructing a packet");
        }

        /*  JADX ERROR: IF instruction can be used only in fallback mode
            jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
            	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:568)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:474)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:239)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:193)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:138)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:148)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:316)
            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
            	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:237)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:76)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
            */
        public void a(String r11) {
            /*
                r10 = this;
                int r0 = r11.length()
                c.a.e.c r1 = new c.a.e.c
                r2 = 0
                char r3 = r11.charAt(r2)
                int r3 = java.lang.Character.getNumericValue(r3)
                r1.<init>(r3)
                int r3 = r1.f689a
                r4 = 6
                r5 = 5
                if (r3 < 0) goto L_0x0110
                java.lang.String[] r6 = c.a.e.d.f694a
                int r6 = r6.length
                r7 = 1
                int r6 = r6 - r7
                if (r3 <= r6) goto L_0x0021
                goto L_0x0110
            L_0x0021:
                if (r5 == r3) goto L_0x0028
                if (r4 != r3) goto L_0x0026
                goto L_0x0028
            L_0x0026:
                r6 = 0
                goto L_0x0055
            L_0x0028:
                java.lang.String r3 = "-"
                boolean r3 = r11.contains(r3)
                if (r3 == 0) goto L_0x010b
                if (r0 > r7) goto L_0x0034
                goto L_0x010b
            L_0x0034:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r6 = 0
            L_0x003a:
                int r6 = r6 + r7
                char r8 = r11.charAt(r6)
                r9 = 45
                if (r8 == r9) goto L_0x004b
                char r8 = r11.charAt(r6)
                r3.append(r8)
                goto L_0x003a
            L_0x004b:
                java.lang.String r3 = r3.toString()
                int r3 = java.lang.Integer.parseInt(r3)
                r1.f693e = r3
            L_0x0055:
                int r3 = r6 + 1
                if (r0 <= r3) goto L_0x007e
                r8 = 47
                char r3 = r11.charAt(r3)
                if (r8 != r3) goto L_0x007e
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
            L_0x0066:
                int r6 = r6 + r7
                char r8 = r11.charAt(r6)
                r9 = 44
                if (r9 != r8) goto L_0x0070
                goto L_0x0077
            L_0x0070:
                r3.append(r8)
                int r8 = r6 + 1
                if (r8 != r0) goto L_0x0066
            L_0x0077:
                java.lang.String r3 = r3.toString()
                r1.f691c = r3
                goto L_0x0082
            L_0x007e:
                java.lang.String r3 = "/"
                r1.f691c = r3
            L_0x0082:
                int r3 = r6 + 1
                if (r0 <= r3) goto L_0x00c3
                char r3 = r11.charAt(r3)
                java.lang.Character r3 = java.lang.Character.valueOf(r3)
                char r3 = r3.charValue()
                int r3 = java.lang.Character.getNumericValue(r3)
                r8 = -1
                if (r3 <= r8) goto L_0x00c3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
            L_0x009e:
                int r6 = r6 + r7
                char r8 = r11.charAt(r6)
                int r9 = java.lang.Character.getNumericValue(r8)
                if (r9 >= 0) goto L_0x00ac
                int r6 = r6 + -1
                goto L_0x00b3
            L_0x00ac:
                r3.append(r8)
                int r8 = r6 + 1
                if (r8 != r0) goto L_0x009e
            L_0x00b3:
                java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x00be }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00be }
                r1.f690b = r3     // Catch:{ NumberFormatException -> 0x00be }
                goto L_0x00c3
            L_0x00be:
                c.a.e.c r1 = c.a.e.b.b()
                goto L_0x0114
            L_0x00c3:
                int r6 = r6 + r7
                if (r0 <= r6) goto L_0x00ea
                r11.charAt(r6)     // Catch:{ JSONException -> 0x00d9 }
                org.json.JSONTokener r0 = new org.json.JSONTokener     // Catch:{ JSONException -> 0x00d9 }
                java.lang.String r3 = r11.substring(r6)     // Catch:{ JSONException -> 0x00d9 }
                r0.<init>(r3)     // Catch:{ JSONException -> 0x00d9 }
                java.lang.Object r0 = r0.nextValue()     // Catch:{ JSONException -> 0x00d9 }
                r1.f692d = r0     // Catch:{ JSONException -> 0x00d9 }
                goto L_0x00ea
            L_0x00d9:
                r11 = move-exception
                java.util.logging.Logger r0 = c.a.e.b.f684b
                java.util.logging.Level r1 = java.util.logging.Level.WARNING
                java.lang.String r2 = "An error occured while retrieving data from JSONTokener"
                r0.log(r1, r2, r11)
                c.a.e.c r1 = c.a.e.b.b()
                goto L_0x0114
            L_0x00ea:
                java.util.logging.Logger r0 = c.a.e.b.f684b
                java.util.logging.Level r3 = java.util.logging.Level.FINE
                boolean r0 = r0.isLoggable(r3)
                if (r0 == 0) goto L_0x0114
                java.util.logging.Logger r0 = c.a.e.b.f684b
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r3[r2] = r11
                r3[r7] = r1
                java.lang.String r11 = "decoded %s as %s"
                java.lang.String r11 = java.lang.String.format(r11, r3)
                r0.fine(r11)
                goto L_0x0114
            L_0x010b:
                c.a.e.c r1 = c.a.e.b.b()
                goto L_0x0114
            L_0x0110:
                c.a.e.c r1 = c.a.e.b.b()
            L_0x0114:
                int r11 = r1.f689a
                if (r5 == r11) goto L_0x0123
                if (r4 != r11) goto L_0x011b
                goto L_0x0123
            L_0x011b:
                c.a.e.d$a$a r11 = r10.f688b
                if (r11 == 0) goto L_0x0139
                r11.a(r1)
                goto L_0x0139
            L_0x0123:
                c.a.e.b$a r11 = new c.a.e.b$a
                r11.<init>(r1)
                r10.f687a = r11
                c.a.e.b$a r11 = r10.f687a
                c.a.e.c r11 = r11.f685a
                int r11 = r11.f693e
                if (r11 != 0) goto L_0x0139
                c.a.e.d$a$a r11 = r10.f688b
                if (r11 == 0) goto L_0x0139
                r11.a(r1)
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.a.e.b.C0014b.a(java.lang.String):void");
        }

        public void a() {
            a aVar = this.f687a;
            if (aVar != null) {
                aVar.f685a = null;
                aVar.f686b = new ArrayList();
            }
            this.f688b = null;
        }

        public void a(C0015a aVar) {
            this.f688b = aVar;
        }
    }

    /* compiled from: IOParser */
    public static final class c implements c.a.e.d.b {
        public void a(c cVar, c.a.e.d.b.a aVar) {
            int i = cVar.f689a;
            if ((i == 2 || i == 3) && c.a.d.a.b(cVar.f692d)) {
                cVar.f689a = cVar.f689a == 2 ? 5 : 6;
            }
            if (b.f684b.isLoggable(Level.FINE)) {
                b.f684b.fine(String.format("encoding packet %s", new Object[]{cVar}));
            }
            int i2 = cVar.f689a;
            if (5 == i2 || 6 == i2) {
                C0013a a2 = a.a(cVar);
                String a3 = a(a2.f682a);
                ArrayList arrayList = new ArrayList(Arrays.asList(a2.f683b));
                arrayList.add(0, a3);
                aVar.a(arrayList.toArray());
                return;
            }
            aVar.a(new String[]{a(cVar)});
        }

        private String a(c cVar) {
            StringBuilder a2 = a.b.a.a.a.a("");
            a2.append(cVar.f689a);
            StringBuilder sb = new StringBuilder(a2.toString());
            int i = cVar.f689a;
            if (5 == i || 6 == i) {
                sb.append(cVar.f693e);
                sb.append("-");
            }
            String str = cVar.f691c;
            if (!(str == null || str.length() == 0)) {
                if (!"/".equals(cVar.f691c)) {
                    sb.append(cVar.f691c);
                    sb.append(",");
                }
            }
            int i2 = cVar.f690b;
            if (i2 >= 0) {
                sb.append(i2);
            }
            T t = cVar.f692d;
            if (t != null) {
                sb.append(t);
            }
            if (b.f684b.isLoggable(Level.FINE)) {
                b.f684b.fine(String.format("encoded %s as %s", new Object[]{cVar, sb}));
            }
            return sb.toString();
        }
    }

    private b() {
    }

    static /* synthetic */ c b() {
        return new c(4, "parser error");
    }
}
