package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Logs */
public class V extends SQLiteOpenHelper {
    public V(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_LOGS (id INTEGER PRIMARY KEY AUTOINCREMENT, idPhone INTEGER NOT NULL, dateConnexion DATETIME NOT NULL, type TEXT NOT NULL, idLog INTEGER NOT NULL, data TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_LOGS;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_LOGS (id INTEGER PRIMARY KEY AUTOINCREMENT, idPhone INTEGER NOT NULL, dateConnexion DATETIME NOT NULL, type TEXT NOT NULL, idLog INTEGER NOT NULL, data TEXT NOT NULL);");
    }
}
