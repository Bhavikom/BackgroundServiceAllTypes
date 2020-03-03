package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Contacts */
public class O extends SQLiteOpenHelper {
    public O(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CONTACTS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, idcontact TEXT NOT NULL, date TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_CONTACTS;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CONTACTS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, idcontact TEXT NOT NULL, date TEXT NOT NULL);");
    }
}
