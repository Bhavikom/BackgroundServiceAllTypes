package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.t.h;

import a.d.a.a.i.f;
import a.d.a.a.i.g;
import a.d.a.a.i.j;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a.C0027a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@WorkerThread
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class y implements C0096c, com.google.android.datatransport.runtime.synchronization.a {

    /* renamed from: e reason: collision with root package name */
    private static final a.d.a.a.b f439e = a.d.a.a.b.a("proto");

    /* renamed from: a reason: collision with root package name */
    private final D f440a;

    /* renamed from: b reason: collision with root package name */
    private final a.d.a.a.i.u.a f441b;

    /* renamed from: c reason: collision with root package name */
    private final a.d.a.a.i.u.a f442c;

    /* renamed from: d reason: collision with root package name */
    private final C0097d f443d;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    interface b<T, U> {
        U apply(T t);
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    private static class c {

        /* renamed from: a reason: collision with root package name */
        final String f444a;

        /* renamed from: b reason: collision with root package name */
        final String f445b;

        /* synthetic */ c(String str, String str2, a aVar) {
            this.f444a = str;
            this.f445b = str2;
        }
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    interface d<T> {
        T a();
    }

    y(a.d.a.a.i.u.a aVar, a.d.a.a.i.u.a aVar2, C0097d dVar, D d2) {
        this.f440a = d2;
        this.f441b = aVar;
        this.f442c = aVar2;
        this.f443d = dVar;
    }

    static /* synthetic */ SQLiteDatabase b(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    private SQLiteDatabase c() {
        D d2 = this.f440a;
        d2.getClass();
        return (SQLiteDatabase) a(q.a(d2), s.a());
    }

    @Nullable
    public g a(j jVar, g gVar) {
        a.d.a.a.i.r.a.a("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", jVar.c(), gVar.f(), jVar.a());
        long longValue = ((Long) a(t.a(this, jVar, gVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return new C0095b(longValue, jVar, gVar);
    }

    public void close() {
        this.f440a.close();
    }

    static /* synthetic */ Long b(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    private static String c(Iterable<g> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((g) it.next()).b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public void b(Iterable<g> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder a2 = a.b.a.a.a.a("DELETE FROM events WHERE _id in ");
            a2.append(c(iterable));
            c().compileStatement(a2.toString()).execute();
        }
    }

    public boolean b(j jVar) {
        return ((Boolean) a(x.a(this, jVar))).booleanValue();
    }

    @Nullable
    private Long a(SQLiteDatabase sQLiteDatabase, j jVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{jVar.a(), String.valueOf(a.d.a.a.i.v.a.a(jVar.c()))}));
        if (jVar.b() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(jVar.b(), 0));
        }
        return (Long) a(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), u.a());
    }

    static /* synthetic */ List b(y yVar, j jVar, SQLiteDatabase sQLiteDatabase) {
        List b2 = yVar.b(sQLiteDatabase, jVar);
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < b2.size(); i++) {
            sb.append(((g) b2.get(i)).b());
            if (i < b2.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        String str = "event_metadata";
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        a(sQLiteDatabase2.query(str, new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), m.a(hashMap));
        ListIterator listIterator = b2.listIterator();
        while (listIterator.hasNext()) {
            g gVar = (g) listIterator.next();
            if (hashMap.containsKey(Long.valueOf(gVar.b()))) {
                a.d.a.a.i.g.a h = gVar.a().h();
                for (c cVar : (Set) hashMap.get(Long.valueOf(gVar.b()))) {
                    h.a(cVar.f444a, cVar.f445b);
                }
                listIterator.set(new C0095b(gVar.b(), gVar.c(), h.a()));
            }
        }
        return b2;
    }

    public Iterable<g> c(j jVar) {
        return (Iterable) a(i.a(this, jVar));
    }

    static /* synthetic */ List c(Cursor cursor) {
        byte[] bArr;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            a.d.a.a.i.j.a d2 = j.d();
            d2.a(cursor.getString(1));
            d2.a(a.d.a.a.i.v.a.a(cursor.getInt(2)));
            String string = cursor.getString(3);
            if (string == null) {
                bArr = null;
            } else {
                bArr = Base64.decode(string, 0);
            }
            d2.a(bArr);
            arrayList.add(d2.a());
        }
        return arrayList;
    }

    public void a(Iterable<g> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder a2 = a.b.a.a.a.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            a2.append(c(iterable));
            a(v.a(a2.toString()));
        }
    }

    static /* synthetic */ Object a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    public long a(j jVar) {
        return ((Long) a(c().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{jVar.a(), String.valueOf(a.d.a.a.i.v.a.a(jVar.c()))}), w.a())).longValue();
    }

    public Iterable<j> b() {
        return (Iterable) a(j.a());
    }

    static /* synthetic */ List b(SQLiteDatabase sQLiteDatabase) {
        return (List) a(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), p.a());
    }

    static /* synthetic */ Long a(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return Long.valueOf(0);
    }

    private List<g> b(SQLiteDatabase sQLiteDatabase, j jVar) {
        ArrayList arrayList = new ArrayList();
        Long a2 = a(sQLiteDatabase, jVar);
        if (a2 == null) {
            return arrayList;
        }
        String str = "events";
        String str2 = "context_id = ?";
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        a(sQLiteDatabase2.query(str, new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code"}, str2, new String[]{a2.toString()}, null, null, null, String.valueOf(this.f443d.c())), l.a(arrayList, jVar));
        return arrayList;
    }

    static /* synthetic */ Boolean a(y yVar, j jVar, SQLiteDatabase sQLiteDatabase) {
        Long a2 = yVar.a(sQLiteDatabase, jVar);
        if (a2 == null) {
            return Boolean.valueOf(false);
        }
        return (Boolean) a(yVar.c().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{a2.toString()}), r.a());
    }

    public void a(j jVar, long j) {
        a(h.a(j, jVar));
    }

    static /* synthetic */ Object a(long j, j jVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        String str = "transport_contexts";
        if (sQLiteDatabase.update(str, contentValues, "backend_name = ? and priority = ?", new String[]{jVar.a(), String.valueOf(a.d.a.a.i.v.a.a(jVar.c()))}) < 1) {
            contentValues.put("backend_name", jVar.a());
            contentValues.put("priority", Integer.valueOf(a.d.a.a.i.v.a.a(jVar.c())));
            sQLiteDatabase.insert(str, null, contentValues);
        }
        return null;
    }

    public int a() {
        return ((Integer) a(k.a(this.f441b.a() - this.f443d.b()))).intValue();
    }

    static /* synthetic */ Object a(List list, j jVar, Cursor cursor) {
        a.d.a.a.b bVar;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            a.d.a.a.i.g.a i = g.i();
            i.a(cursor.getString(1));
            i.a(cursor.getLong(2));
            i.b(cursor.getLong(3));
            String string = cursor.getString(4);
            if (string == null) {
                bVar = f439e;
            } else {
                bVar = a.d.a.a.b.a(string);
            }
            i.a(new f(bVar, cursor.getBlob(5)));
            if (!cursor.isNull(6)) {
                i.a(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(new C0095b(j, jVar, i.a()));
        }
        return null;
    }

    static /* synthetic */ Object a(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2), null));
        }
        return null;
    }

    private <T> T a(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.f442c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f442c.a() >= ((long) this.f443d.a()) + a2) {
                    return bVar.apply(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    static /* synthetic */ Object a(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public <T> T a(C0027a<T> aVar) {
        SQLiteDatabase c2 = c();
        a(n.a(c2), o.a());
        try {
            T execute = aVar.execute();
            c2.setTransactionSuccessful();
            return execute;
        } finally {
            c2.endTransaction();
        }
    }

    private <T> T a(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase c2 = c();
        c2.beginTransaction();
        try {
            T apply = bVar.apply(c2);
            c2.setTransactionSuccessful();
            return apply;
        } finally {
            c2.endTransaction();
        }
    }

    static /* synthetic */ Long a(y yVar, j jVar, g gVar, SQLiteDatabase sQLiteDatabase) {
        long j;
        if (yVar.c().compileStatement("PRAGMA page_size").simpleQueryForLong() * yVar.c().compileStatement("PRAGMA page_count").simpleQueryForLong() >= yVar.f443d.d()) {
            return Long.valueOf(-1);
        }
        Long a2 = yVar.a(sQLiteDatabase, jVar);
        if (a2 != null) {
            j = a2.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", jVar.a());
            contentValues.put("priority", Integer.valueOf(a.d.a.a.i.v.a.a(jVar.c())));
            contentValues.put("next_request_ms", Integer.valueOf(0));
            if (jVar.b() != null) {
                contentValues.put("extras", Base64.encodeToString(jVar.b(), 0));
            }
            j = sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(j));
        contentValues2.put("transport_name", gVar.f());
        contentValues2.put("timestamp_ms", Long.valueOf(gVar.d()));
        contentValues2.put("uptime_ms", Long.valueOf(gVar.g()));
        contentValues2.put("payload_encoding", gVar.c().b().a());
        contentValues2.put("payload", gVar.c().a());
        contentValues2.put("code", gVar.b());
        contentValues2.put("num_attempts", Integer.valueOf(0));
        long insert = sQLiteDatabase.insert("events", null, contentValues2);
        for (Entry entry : gVar.e().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    private static <T> T a(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }
}
