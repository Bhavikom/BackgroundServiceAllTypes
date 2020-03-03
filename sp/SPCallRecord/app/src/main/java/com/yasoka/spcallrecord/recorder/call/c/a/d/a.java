package com.yasoka.spcallrecord.recorder.call.c.a.d;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HasBinary */
public class a {

    /* renamed from: a reason: collision with root package name */
    private static final Logger f680a = Logger.getLogger(a.class.getName());

    private a() {
    }

    private static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    if (a(jSONArray.isNull(i) ? null : jSONArray.get(i))) {
                        return true;
                    }
                    i++;
                } catch (JSONException e2) {
                    f680a.log(Level.WARNING, "An error occured while retrieving data from JSONArray", e2);
                    return false;
                }
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    if (a(jSONObject.get((String) keys.next()))) {
                        return true;
                    }
                } catch (JSONException e3) {
                    f680a.log(Level.WARNING, "An error occured while retrieving data from JSONObject", e3);
                }
            }
        }
        return false;
    }

    public static boolean b(Object obj) {
        return a(obj);
    }
}
