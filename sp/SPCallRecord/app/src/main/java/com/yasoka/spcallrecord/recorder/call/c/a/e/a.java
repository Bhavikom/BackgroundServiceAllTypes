package com.yasoka.spcallrecord.recorder.call.c.a.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Binary */
public class a {

    /* renamed from: a reason: collision with root package name */
    private static final Logger f681a = Logger.getLogger(a.class.getName());

    /* renamed from: c.a.e.a$a reason: collision with other inner class name */
    /* compiled from: Binary */
    public static class C0013a {

        /* renamed from: a reason: collision with root package name */
        public c f682a;

        /* renamed from: b reason: collision with root package name */
        public byte[][] f683b;
    }

    public static C0013a a(c cVar) {
        ArrayList arrayList = new ArrayList();
        cVar.f692d = a((Object) cVar.f692d, (List<byte[]>) arrayList);
        cVar.f693e = arrayList.size();
        C0013a aVar = new C0013a();
        aVar.f682a = cVar;
        aVar.f683b = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
        return aVar;
    }

    private static Object a(Object obj, List<byte[]> list) {
        if (obj == null) {
            return null;
        }
        String str = "An error occured while putting data to JSONObject";
        if (obj instanceof byte[]) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_placeholder", true);
                jSONObject.put("num", list.size());
                list.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e2) {
                f681a.log(Level.WARNING, str, e2);
                return null;
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            int i = 0;
            while (i < length) {
                try {
                    jSONArray.put(i, a(jSONArray2.get(i), list));
                    i++;
                } catch (JSONException e3) {
                    f681a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", e3);
                    return null;
                }
            }
            return jSONArray;
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = (JSONObject) obj;
            Iterator keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                try {
                    jSONObject2.put(str2, a(jSONObject3.get(str2), list));
                } catch (JSONException e4) {
                    f681a.log(Level.WARNING, str, e4);
                    return null;
                }
            }
            return jSONObject2;
        }
    }

    public static c a(c cVar, byte[][] bArr) {
        cVar.f692d = a((Object) cVar.f692d, bArr);
        cVar.f693e = -1;
        return cVar;
    }

    private static Object a(Object obj, byte[][] bArr) {
        byte[] bArr2 = null;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    jSONArray.put(i, a(jSONArray.get(i), bArr));
                    i++;
                } catch (JSONException e2) {
                    f681a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", e2);
                    return null;
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            r4 = (JSONObject) obj;
            if (r4.optBoolean("_placeholder")) {
                int optInt = r4.optInt("num", -1);
                if (optInt >= 0 && optInt < bArr.length) {
                    bArr2 = bArr[optInt];
                }
                return bArr2;
            }
            Iterator keys = r4.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    r4.put(str, a(r4.get(str), bArr));
                } catch (JSONException e3) {
                    f681a.log(Level.WARNING, "An error occured while putting data to JSONObject", e3);
                    return null;
                }
            }
            obj = r4;
        }
        return obj;
    }
}
