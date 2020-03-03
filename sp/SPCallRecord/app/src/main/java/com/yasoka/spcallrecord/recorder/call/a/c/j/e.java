package com.yasoka.spcallrecord.recorder.call.a.c.j;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import mob.protect.children.R;

/* compiled from: UtilActivity */
final class e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f306a;

    e(AppCompatActivity appCompatActivity) {
        this.f306a = appCompatActivity;
    }

    public void run() {
        c.a(this.f306a.getApplicationContext().getString(R.string.error_server), (Context) this.f306a);
    }
}
