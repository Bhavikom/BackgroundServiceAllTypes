package com.yasoka.spcallrecord.recorder.call.a.c.f;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DBAdapter */
public class a {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final String f202a;

    /* renamed from: b reason: collision with root package name */
    private final Context f203b;

    /* renamed from: c reason: collision with root package name */
    private C0005a f204c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public SQLiteDatabase f205d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public String f206e = null;

    /* renamed from: a.c.f.a$a reason: collision with other inner class name */
    /* compiled from: DBAdapter */
    public class C0005a extends SQLiteOpenHelper {

        /* renamed from: a reason: collision with root package name */
        Context f207a;

        C0005a(Context context) {
            super(context, a.this.f202a, null, 3);
            this.f207a = context;
        }

        public void a() throws IOException {
            boolean z = true;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.f206e);
                sb.append(a.this.f202a);
                sQLiteDatabase = SQLiteDatabase.openDatabase(sb.toString(), null, 1);
            } catch (SQLiteException unused) {
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            if (sQLiteDatabase == null) {
                z = false;
            }
            if (!z) {
                getReadableDatabase();
                InputStream open = this.f207a.getAssets().open(a.this.f202a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a.this.f206e);
                sb2.append(a.this.f202a);
                FileOutputStream fileOutputStream = new FileOutputStream(sb2.toString());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        open.close();
                        return;
                    }
                }
            }
        }

        public synchronized void close() {
            if (a.this.f205d != null) {
                a.this.f205d.close();
            }
            super.close();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public a(Context context, String str, String str2) {
        this.f203b = context;
        this.f206e = str;
        this.f202a = str2;
    }

    public Cursor d(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`timestamp` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor e(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`timestamp` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`timestamp` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor f(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`timestamp` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor g(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`timestamp` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor h(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`msg_date` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`msg_date` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor i(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`timestamp` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`timestamp` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor j(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`nsp_data` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor k(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`date` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor l(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`msg_date` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor m(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`date` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor n(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`timestamp` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public a b() throws Exception {
        this.f204c = new C0005a(this.f203b);
        this.f204c.a();
        C0005a aVar = this.f204c;
        StringBuilder sb = new StringBuilder();
        sb.append(a.this.f206e);
        sb.append(a.this.f202a);
        a.this.f205d = SQLiteDatabase.openDatabase(sb.toString(), null, 0);
        return this;
    }

    public Cursor c(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`timestamp_ms` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`timestamp_ms` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor d(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`timestamp` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`timestamp` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor e(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`timestamp` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor f(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`timestamp` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`timestamp` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor g(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`created_time` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`created_time` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor h(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`msg_date` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor i(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`timestamp` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor c(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`dateSentMs` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`dateSentMs` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor a(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`timestamp` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`timestamp` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`timestamp` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor e(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`dateSentMs` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`timestamp` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor g(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`created_time` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor h(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`timestamp` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor i(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`created_time` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`dateSentMs` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT uri FROM ");
        sb.append(str);
        sb.append(" WHERE id LIKE ");
        sb.append(str2);
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor b(String str, long j) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str, ".`timestamp_ms` > ");
        a2.append(j);
        a2.append(" ORDER BY ");
        a2.append(str);
        a2.append(".`timestamp_ms` ASC");
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor a(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`call_time` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public Cursor b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" ORDER BY ");
        sb.append(str);
        sb.append(".`timestamp` DESC LIMIT 30");
        return this.f205d.rawQuery(sb.toString(), null);
    }

    public Cursor a(String str, String str2, String str3) {
        return this.f205d.rawQuery(a.b.a.a.a.b(a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str2, " LIKE '"), str3, "'"), null);
    }

    public Cursor b(String str, int i) {
        StringBuilder a2 = a.b.a.a.a.a("SELECT * FROM ", str, " ORDER BY ", str, ".`nsp_data` DESC LIMIT ");
        a2.append(i);
        return this.f205d.rawQuery(a2.toString(), null);
    }

    public void a() {
        this.f204c.close();
    }

    public Cursor b(String str, String str2, String str3) {
        return this.f205d.rawQuery(a.b.a.a.a.b(a.b.a.a.a.a("SELECT * FROM ", str, " WHERE ", str2, " LIKE '%"), str3, "%'"), null);
    }
}
