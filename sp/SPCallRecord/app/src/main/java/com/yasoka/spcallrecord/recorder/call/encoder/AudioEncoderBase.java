package com.yasoka.spcallrecord.recorder.call.encoder;

//import io.fabric.sdk.android.o.c.b;

public abstract class AudioEncoderBase {
    private int bitrate = 128000;
    private int channels = 1;
    private int profile = 2;
    private int quality = 2;
    private int sampleRate = 1022; //todo
    private int sbr = 0;
    private int vbr = 1;

    public boolean canFlush() {
        return false;
    }

    public abstract void close();

    public abstract int encode(byte[] bArr, byte[] bArr2) throws Exception;

    public int flush(byte[] bArr) throws Exception {
        throw new Exception("Not implemented");
    }

    public int getBitRate() {
        return this.bitrate;
    }

    public int getChannels() {
        return this.channels;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getQuality() {
        return this.quality;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getSpecialAudioStartPos() {
        return -1;
    }

    public int getSpecialHeader(byte[] bArr) {
        return -1;
    }

    public int getSpectralBandReplication() {
        return this.sbr;
    }

    public int getVariableBitRate() {
        return this.vbr;
    }

    public boolean hasSpecialHeader() {
        return false;
    }

    public abstract void init() throws Exception;

    public void setBitRate(int i) {
        this.bitrate = i;
    }

    public void setChannels(int i) {
        this.channels = i;
    }

    public void setProfile(int i) {
        this.profile = i;
    }

    public void setQuality(int i) {
        this.quality = i;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setSpectralBandReplication(int i) {
        this.sbr = i;
    }

    public void setVariableBitRate(int i) {
        this.vbr = i;
    }
}
