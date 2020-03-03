package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: SocialNetwork */
public class n0 extends SQLiteOpenHelper {
    public n0(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SOCIAL_NETWORK (id INTEGER PRIMARY KEY AUTOINCREMENT, fullName TEXT NOT NULL, message TEXT NOT NULL, type TEXT NOT NULL, date TEXT NOT NULL, urlScript TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_SOCIAL_NETWORK;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SOCIAL_NETWORK (id INTEGER PRIMARY KEY AUTOINCREMENT, fullName TEXT NOT NULL, message TEXT NOT NULL, type TEXT NOT NULL, date TEXT NOT NULL, urlScript TEXT NOT NULL);");
    }
}
