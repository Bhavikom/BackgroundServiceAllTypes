package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: SMSAlertKeyword */
public class e0 extends SQLiteOpenHelper {
    public e0(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SMS_ALERT (id INTEGER PRIMARY KEY AUTOINCREMENT, keyword TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_SMS_ALERT;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SMS_ALERT (id INTEGER PRIMARY KEY AUTOINCREMENT, keyword TEXT NOT NULL);");
    }
}
