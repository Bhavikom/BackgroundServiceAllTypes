package com.yasoka.spcallrecord.recorder.call.a.d.a.b.b;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class b extends a {
    public static final Creator<b> CREATOR = new o();

    /* renamed from: a reason: collision with root package name */
    private String f511a;

    /* renamed from: b reason: collision with root package name */
    private DataHolder f512b;

    /* renamed from: c reason: collision with root package name */
    private ParcelFileDescriptor f513c;

    /* renamed from: d reason: collision with root package name */
    private long f514d;

    /* renamed from: e reason: collision with root package name */
    private byte[] f515e;
    private byte[] f;
    private File g;

    static {
        Class<b> cls = b.class;
    }

    public b() {
        this(null, null, null, 0, null);
    }

    public b(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j, byte[] bArr) {
        this.f511a = str;
        this.f512b = dataHolder;
        this.f513c = parcelFileDescriptor;
        this.f514d = j;
        this.f515e = bArr;
    }

    public DataHolder q() {
        return this.f512b;
    }

    public ParcelFileDescriptor r() {
        return this.f513c;
    }

    public long s() {
        return this.f514d;
    }

    public String t() {
        return this.f511a;
    }

    public byte[] u() {
        return this.f515e;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x005f */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0066  */
    public void writeToParcel(Parcel parcel, int i) {
        boolean z;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        File file;
        if (this.f513c == null && this.f != null) {
            File file2 = this.g;
            if (file2 != null) {
                try {
                    file = File.createTempFile("xlb", ".tmp", file2);
                } catch (IOException unused) {
                    file = null;
                    if (file != null) {
                        file.delete();
                    }
                    outputStream = null;
                    if (outputStream != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    o.a(this, parcel, i);
                    this.f513c = null;
                } catch (Throwable th) {
                    th = th;
                    file = null;
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
                try {
                    outputStream = new FileOutputStream(file);
                    this.f513c = ParcelFileDescriptor.open(file, 268435456);
                    if (file != null) {
                        file.delete();
                    }
                } catch (IOException unused2) {
                    if (file != null) {
                    }
                    outputStream = null;
                    if (outputStream != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    o.a(this, parcel, i);
                    this.f513c = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (file != null) {
                    }
                    throw th;
                }
                if (outputStream != null) {
                    dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
                    try {
                        dataOutputStream.writeInt(this.f.length);
                        dataOutputStream.write(this.f);
                        try {
                            dataOutputStream.close();
                        } catch (IOException unused3) {
                        }
                        z = true;
                    } catch (IOException ) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    } catch (Throwable th3) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException unused5) {
                        }
                        throw th3;
                    }
                    if (z) {
                        i |= 1;
                    }
                    o.a(this, parcel, i);
                    this.f513c = null;
                }
            }
            outputStream = null;
            if (outputStream != null) {
            }
        }
        z = false;
        if (z) {
        }
        o.a(this, parcel, i);
        this.f513c = null;
    }
}
