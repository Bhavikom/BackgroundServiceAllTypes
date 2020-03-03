package com.yasoka.spcallrecord.recorder.call.a.e.a.a.a;

import a.c.e.e;
import a.e.a.a.b.a;
import com.app.activity.MyApp;
import java.io.File;

/* compiled from: RecordItem */
public class c {

    /* renamed from: a reason: collision with root package name */
    private a f562a = a.AMR;

    /* renamed from: b reason: collision with root package name */
    private int f563b = -1;

    /* renamed from: c reason: collision with root package name */
    private String f564c;

    public void a(int i) {
        this.f563b = i;
    }

    public File b() {
        return new File(e.b(MyApp.b().getApplicationContext(), this.f564c));
    }

    public File c() {
        return new File(e.c(MyApp.b().getApplicationContext()));
    }

    public int d() {
        return this.f563b;
    }

    public a a() {
        return this.f562a;
    }

    public void a(a aVar) {
        this.f562a = aVar;
    }

    public void a(String str) {
        this.f564c = str;
    }
}
