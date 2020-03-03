package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: FileExplorer */
class Q extends SQLiteOpenHelper {
    public Q(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_FILE_EXPLORER (id INTEGER PRIMARY KEY AUTOINCREMENT, nameFile TEXT NOT NULL, pathFile TEXT NOT NULL, pathFileSave TEXT NOT NULL, date TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_FILE_EXPLORER;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_FILE_EXPLORER (id INTEGER PRIMARY KEY AUTOINCREMENT, nameFile TEXT NOT NULL, pathFile TEXT NOT NULL, pathFileSave TEXT NOT NULL, date TEXT NOT NULL);");
    }
}
