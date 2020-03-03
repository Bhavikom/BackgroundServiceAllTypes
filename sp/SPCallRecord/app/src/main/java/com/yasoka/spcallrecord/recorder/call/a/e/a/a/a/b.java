package com.yasoka.spcallrecord.recorder.call.a.e.a.a.a;

/* compiled from: DeviceObject */
public class b {

    /* renamed from: a reason: collision with root package name */
    public String f559a;

    /* renamed from: b reason: collision with root package name */
    public String f560b;

    /* renamed from: c reason: collision with root package name */
    private int f561c;

    public b(String str, String str2, int i) {
        this.f559a = str.toLowerCase();
        this.f560b = str2 != null ? str2.toLowerCase() : null;
        this.f561c = i;
    }

    public int a() {
        switch (this.f561c) {
            case 1:
                return 1;
            case 2:
                return 4;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 5;
            default:
                return 1;
        }
    }
}
