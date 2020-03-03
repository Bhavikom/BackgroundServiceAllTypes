package com.yasoka.spcallrecord.recorder.call.a.c.j;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import mob.protect.children.R;

/* compiled from: UtilActivity */
final class f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f307a;

    f(AppCompatActivity appCompatActivity) {
        this.f307a = appCompatActivity;
    }

    public void run() {
        c.a(this.f307a.getApplicationContext().getString(R.string.error_network), (Context) this.f307a);
    }
}
