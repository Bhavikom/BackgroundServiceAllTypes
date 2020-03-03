package com.yasoka.spcallrecord.recorder.call.encoder;

public class LameEncoder extends AudioEncoderBase {
    static {
        System.loadLibrary("lame");
    }

    private native void nativeClose();

    private native int nativeEncode(byte[] bArr, byte[] bArr2);

    private native int nativeFlush(byte[] bArr);

    private native int nativeGetAudioStartPos();

    private native int nativeGetXingFrame(byte[] bArr);

    private native int nativeInit(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public boolean canFlush() {
        return true;
    }

    public void close() {
        nativeClose();
    }

    public int encode(byte[] bArr, byte[] bArr2) throws Exception {
        int nativeEncode = nativeEncode(bArr, bArr2);
        if (nativeEncode != -1) {
            return nativeEncode;
        }
        throw new Exception("Failed to encode");
    }

    public int flush(byte[] bArr) throws Exception {
        int nativeFlush = nativeFlush(bArr);
        if (nativeFlush != -1) {
            return nativeFlush;
        }
        throw new Exception("Failed to flush buffers");
    }

    public int getSpecialAudioStartPos() {
        return nativeGetAudioStartPos();
    }

    public int getSpecialHeader(byte[] bArr) {
        return nativeGetXingFrame(bArr);
    }

    public boolean hasSpecialHeader() {
        return true;
    }

    public void init() throws Exception {
        if (nativeInit(getChannels(), getSampleRate(), 0, getBitRate(), 0, getQuality(), getVariableBitRate()) != 0) {
            throw new Exception("Failed to initialize encoder");
        }
    }
}
