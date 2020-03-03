package com.yasoka.spcallrecord.recorder.call.c.a.c.a;

import c.a.c.a.c.d;

/* compiled from: Parser */
final class e implements d {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f679a;

    e(d dVar) {
        this.f679a = dVar;
    }

    public void a(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            String valueOf = String.valueOf(str.length());
            byte[] bArr = new byte[(valueOf.length() + 2)];
            bArr[0] = 0;
            int i = 0;
            while (i < valueOf.length()) {
                int i2 = i + 1;
                bArr[i2] = (byte) Character.getNumericValue(valueOf.charAt(i));
                i = i2;
            }
            bArr[bArr.length - 1] = -1;
            this.f679a.a(a.a(new byte[][]{bArr, c.b(str)}));
            return;
        }
        byte[] bArr2 = (byte[]) obj;
        String valueOf2 = String.valueOf(bArr2.length);
        byte[] bArr3 = new byte[(valueOf2.length() + 2)];
        bArr3[0] = 1;
        int i3 = 0;
        while (i3 < valueOf2.length()) {
            int i4 = i3 + 1;
            bArr3[i4] = (byte) Character.getNumericValue(valueOf2.charAt(i3));
            i3 = i4;
        }
        bArr3[bArr3.length - 1] = -1;
        this.f679a.a(a.a(new byte[][]{bArr3, bArr2}));
    }
}
