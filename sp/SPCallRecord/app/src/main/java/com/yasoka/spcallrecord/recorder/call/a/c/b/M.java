package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Clipboard */
public class M extends SQLiteOpenHelper {
    public M(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CLIPBOARD (id INTEGER PRIMARY KEY AUTOINCREMENT, textCopied TEXT NOT NULL, date TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_CLIPBOARD;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_CLIPBOARD (id INTEGER PRIMARY KEY AUTOINCREMENT, textCopied TEXT NOT NULL, date TEXT NOT NULL);");
    }
}
