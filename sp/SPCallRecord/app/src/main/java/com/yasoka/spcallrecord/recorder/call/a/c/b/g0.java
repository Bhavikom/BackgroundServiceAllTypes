package com.yasoka.spcallrecord.recorder.call.a.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: SMSAlertSend */
public class g0 extends SQLiteOpenHelper {
    public g0(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SMS_ALERT_SEND (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, message TEXT NOT NULL, type INTEGER, date TEXT NOT NULL, keyword TEXT NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE TABLE_CONFIG_SMS_ALERT_SEND;");
        sQLiteDatabase.execSQL("CREATE TABLE TABLE_CONFIG_SMS_ALERT_SEND (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, number TEXT NOT NULL, message TEXT NOT NULL, type INTEGER, date TEXT NOT NULL, keyword TEXT NOT NULL);");
    }
}
