package com.yasoka.spcallrecord.recorder.call.encoder;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class AMREncoder extends AudioEncoderBase {
    private FileOutputStream fos;

    public enum Mode {
        MR475,
        MR515,
        MR59,
        MR67,
        MR74,
        MR795,
        MR102,
        MR122,
        MRDTX,
        N_MODES
    }

    static {
        System.loadLibrary("amr");
    }

    public AMREncoder(FileOutputStream fileOutputStream) {
        this.fos = fileOutputStream;
    }

    private native void nativeClose();

    private native int nativeEncode(byte[] bArr, byte[] bArr2);

    private native int nativeInit(int i);

    private native void nativeReset();

    public void close() {
        nativeClose();
    }

    public int encode(byte[] bArr, byte[] bArr2) throws Exception {
        int nativeEncode = nativeEncode(bArr, bArr2);
        if (nativeEncode != -1) {
            return nativeEncode;
        }
        throw new Exception("Failed to encode data");
    }

    public void init() throws Exception {
        if (this.fos == null) {
            throw new Exception("No fileOutputStream located");
        } else if (nativeInit(getProfile()) == 0) {
            ByteBuffer allocate = ByteBuffer.allocate(6);
            allocate.put("#!AMR\n".getBytes(Charset.forName("ASCII")));
            this.fos.write(allocate.array(), 0, 6);
        } else {
            throw new Exception("Failed to initialize encoder");
        }
    }
}
