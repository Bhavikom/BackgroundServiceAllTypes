package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class D extends SQLiteOpenHelper {

    /* renamed from: c reason: collision with root package name */
    private static final a f395c = A.a();

    /* renamed from: d reason: collision with root package name */
    private static final a f396d = B.a();

    /* renamed from: e reason: collision with root package name */
    private static final a f397e = C.a();
    private static final List<a> f = Arrays.asList(new a[]{f395c, f396d, f397e});

    /* renamed from: a reason: collision with root package name */
    private final int f398a;

    /* renamed from: b reason: collision with root package name */
    private boolean f399b = false;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    D(Context context, int i) {
        super(context, "com.google.android.datatransport.events", null, i);
        this.f398a = i;
    }

    static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    static /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f399b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        int i = VERSION.SDK_INT;
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!this.f399b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, this.f398a);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        if (!this.f399b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, this.f398a);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.f399b) {
            onConfigure(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.f399b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, i, i2);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= f.size()) {
            while (i < i2) {
                ((a) f.get(i)).a(sQLiteDatabase);
                i++;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Migration from ");
        sb.append(i);
        sb.append(" to ");
        sb.append(i2);
        sb.append(" was requested, but cannot be performed. Only ");
        sb.append(f.size());
        sb.append(" migrations are provided");
        throw new IllegalArgumentException(sb.toString());
    }
}
