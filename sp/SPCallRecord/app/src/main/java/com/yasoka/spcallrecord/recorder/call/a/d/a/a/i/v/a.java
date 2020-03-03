package com.yasoka.spcallrecord.recorder.call.a.d.a.a.i.v;

import a.d.a.a.d;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.EnumMap;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static SparseArray<d> f452a = new SparseArray<>();

    /* renamed from: b reason: collision with root package name */
    private static EnumMap<d, Integer> f453b = new EnumMap<>(d.class);

    static {
        f453b.put(d.DEFAULT, Integer.valueOf(0));
        f453b.put(d.VERY_LOW, Integer.valueOf(1));
        f453b.put(d.HIGHEST, Integer.valueOf(2));
        for (d dVar : f453b.keySet()) {
            f452a.append(((Integer) f453b.get(dVar)).intValue(), dVar);
        }
    }

    @NonNull
    public static d a(int i) {
        d dVar = (d) f452a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(a.b.a.a.a.b("Unknown Priority for value ", i));
    }

    public static int a(@NonNull d dVar) {
        Integer num = (Integer) f453b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PriorityMapping is missing known Priority value ");
        sb.append(dVar);
        throw new IllegalStateException(sb.toString());
    }
}
