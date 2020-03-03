package com.yasoka.spcallrecord.recorder.call.c.a.a;

import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: Backoff */
public class a {

    /* renamed from: a reason: collision with root package name */
    private long f661a = 100;

    /* renamed from: b reason: collision with root package name */
    private long f662b = 10000;

    /* renamed from: c reason: collision with root package name */
    private int f663c = 2;

    /* renamed from: d reason: collision with root package name */
    private double f664d;

    /* renamed from: e reason: collision with root package name */
    private int f665e;

    public long a() {
        BigInteger valueOf = BigInteger.valueOf(this.f661a);
        BigInteger valueOf2 = BigInteger.valueOf((long) this.f663c);
        int i = this.f665e;
        this.f665e = i + 1;
        BigInteger multiply = valueOf.multiply(valueOf2.pow(i));
        if (this.f664d != 0.0d) {
            double random = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(random).multiply(BigDecimal.valueOf(this.f664d)).multiply(new BigDecimal(multiply)).toBigInteger();
            multiply = (((int) Math.floor(random * 10.0d)) & 1) == 0 ? multiply.subtract(bigInteger) : multiply.add(bigInteger);
        }
        return multiply.min(BigInteger.valueOf(this.f662b)).longValue();
    }

    public a b(long j) {
        this.f661a = j;
        return this;
    }

    public void c() {
        this.f665e = 0;
    }

    public int b() {
        return this.f665e;
    }

    public a a(long j) {
        this.f662b = j;
        return this;
    }

    public a a(double d2) {
        this.f664d = d2;
        return this;
    }
}
