package com.yasoka.spcallrecord.recorder.call.encoder;

import com.yasoka.spcallrecord.recorder.call.a.b.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class WaveHeader {
    public static final short FORMAT_ALAW = 6;
    public static final short FORMAT_IGNORE = -1;
    public static final short FORMAT_PCM = 1;
    public static final short FORMAT_ULAW = 7;
    public static final int HEADER_LENGTH = 44;
    private short mBitsPerSample;
    private short mFormat;
    private int mNumBytes;
    private short mNumChannels;
    private int mSampleRate;

    public WaveHeader() {
    }

    private static void readId(InputStream inputStream, String str) throws IOException {
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == inputStream.read()) {
                i++;
            } else {
                throw new IOException(a.c(str, " tag not present"));
            }
        }
    }

    private static int readInt(InputStream inputStream) throws IOException {
        return (inputStream.read() << 24) | inputStream.read() | (inputStream.read() << 8) | (inputStream.read() << 16);
    }

    private static short readShort(InputStream inputStream) throws IOException {
        return (short) ((inputStream.read() << 8) | inputStream.read());
    }

    private static void writeId(OutputStream outputStream, String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            outputStream.write(str.charAt(i));
        }
    }

    private static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i >> 0);
        outputStream.write(i >> 8);
        outputStream.write(i >> 16);
        outputStream.write(i >> 24);
    }

    private static void writeShort(OutputStream outputStream, short s) throws IOException {
        outputStream.write(s >> 0);
        outputStream.write(s >> 8);
    }

    public short getBitsPerSample() {
        return this.mBitsPerSample;
    }

    public short getFormat() {
        return this.mFormat;
    }

    public int getNumBytes() {
        return this.mNumBytes;
    }

    public short getNumChannels() {
        return this.mNumChannels;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int read(InputStream inputStream) throws IOException {
        readId(inputStream, "RIFF");
        readInt(inputStream);
        readId(inputStream, "WAVE");
        readId(inputStream, "fmt ");
        if (16 == readInt(inputStream)) {
            this.mFormat = readShort(inputStream);
            this.mNumChannels = readShort(inputStream);
            this.mSampleRate = readInt(inputStream);
            int readInt = readInt(inputStream);
            short readShort = readShort(inputStream);
            this.mBitsPerSample = readShort(inputStream);
            short s = this.mNumChannels;
            int i = this.mSampleRate * s;
            short s2 = this.mBitsPerSample;
            if (readInt != (i * s2) / 8) {
                throw new IOException("fmt.ByteRate field inconsistent");
            } else if (readShort == (s * s2) / 8) {
                readId(inputStream, "data");
                this.mNumBytes = readInt(inputStream);
                return 44;
            } else {
                throw new IOException("fmt.BlockAlign field inconsistent");
            }
        } else {
            throw new IOException("fmt chunk length not 16");
        }
    }

    public WaveHeader setBitsPerSample(short s) {
        this.mBitsPerSample = s;
        return this;
    }

    public WaveHeader setFormat(short s) {
        this.mFormat = s;
        return this;
    }

    public WaveHeader setNumBytes(int i) {
        this.mNumBytes = i;
        return this;
    }

    public WaveHeader setNumChannels(short s) {
        this.mNumChannels = s;
        return this;
    }

    public WaveHeader setSampleRate(int i) {
        this.mSampleRate = i;
        return this;
    }

    public String toString() {
        return String.format("WaveHeader format=%d numChannels=%d sampleRate=%d bitsPerSample=%d numBytes=%d", new Object[]{Short.valueOf(this.mFormat), Short.valueOf(this.mNumChannels), Integer.valueOf(this.mSampleRate), Short.valueOf(this.mBitsPerSample), Integer.valueOf(this.mNumBytes)});
    }

    public int write(OutputStream outputStream) throws IOException {
        writeId(outputStream, "RIFF");
        writeInt(outputStream, this.mNumBytes + 36);
        writeId(outputStream, "WAVE");
        writeId(outputStream, "fmt ");
        writeInt(outputStream, 16);
        writeShort(outputStream, this.mFormat);
        writeShort(outputStream, this.mNumChannels);
        writeInt(outputStream, this.mSampleRate);
        writeInt(outputStream, ((this.mNumChannels * this.mSampleRate) * this.mBitsPerSample) / 8);
        writeShort(outputStream, (short) ((this.mNumChannels * this.mBitsPerSample) / 8));
        writeShort(outputStream, this.mBitsPerSample);
        writeId(outputStream, "data");
        writeInt(outputStream, this.mNumBytes);
        return 44;
    }

    public void writeHeader(RandomAccessFile randomAccessFile) throws Exception {
        ByteBuffer allocate = ByteBuffer.allocate(44);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        String str = "ASCII";
        allocate.put("RIFF".getBytes(Charset.forName(str)));
        allocate.putInt(this.mNumBytes + 36);
        allocate.put("WAVE".getBytes(Charset.forName(str)));
        allocate.put("fmt ".getBytes(Charset.forName(str)));
        allocate.putInt(16);
        allocate.putShort(this.mFormat);
        allocate.putShort(this.mNumChannels);
        allocate.putInt(this.mSampleRate);
        allocate.putInt(((this.mNumChannels * this.mSampleRate) * this.mBitsPerSample) / 8);
        allocate.putShort((short) ((this.mNumChannels * this.mBitsPerSample) / 8));
        allocate.putShort(this.mBitsPerSample);
        allocate.put("data".getBytes(Charset.forName(str)));
        allocate.putInt(this.mNumBytes);
        randomAccessFile.write(allocate.array(), 0, allocate.array().length);
    }

    public WaveHeader(short s, short s2, int i, short s3, int i2) {
        this.mFormat = s;
        this.mSampleRate = i;
        this.mNumChannels = s2;
        this.mBitsPerSample = s3;
        this.mNumBytes = i2;
    }
}
