package com.yasoka.spcallrecord.recorder.call.encoder;

//import io.fabric.sdk.android.o.c.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WavEncoder extends AudioEncoderBase {
    private static final String TAG = "WavEncoder";
    private File file;
    private FileOutputStream fos;
    private int totalBytesWritten = 0;

    public WavEncoder(FileOutputStream fileOutputStream, File file2) {
        this.fos = fileOutputStream;
        this.file = file2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[SYNTHETIC, Splitter:B:17:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048 A[SYNTHETIC, Splitter:B:22:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public void close() {
        WaveHeader waveHeader = new WaveHeader(1, 1, 1024, 16, this.totalBytesWritten);
        RandomAccessFile randomAccessFile = null;
        try {
            this.fos.close();
            this.fos = null;
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.file, "rws");
            try {
                randomAccessFile2.seek(0);
                waveHeader.writeHeader(randomAccessFile2);
                try {
                    randomAccessFile2.close();
                } catch (IOException e2) {
                    e2.getStackTrace();
                }
            } catch (Exception e3) {
                RandomAccessFile randomAccessFile3 = randomAccessFile2;
                //e = e3;
                randomAccessFile = randomAccessFile3;
                try {
                    //e.getStackTrace();
                    if (randomAccessFile == null) {
                        randomAccessFile.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            e4.getStackTrace();
                        }
                    }
                    //throw th;
                }
            } catch (Throwable th2) {
                RandomAccessFile randomAccessFile4 = randomAccessFile2;
                //th = th2;
                randomAccessFile = randomAccessFile4;
                if (randomAccessFile != null) {
                }
                //throw th;
            }
        } catch (Exception e5) {
            //e = e5;
            //e.getStackTrace();
            if (randomAccessFile == null) {
            }
        }
    }

    public int encode(byte[] bArr, byte[] bArr2) throws Exception {
        if (bArr2.length >= bArr.length) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.totalBytesWritten += bArr.length;
            return bArr.length;
        }
        throw new Exception("Output buffer is smaller than the input buffer");
    }

    public void init() throws Exception {
        FileOutputStream fileOutputStream = this.fos;
        if (fileOutputStream == null || this.file == null) {
            throw new Exception("No outputstream /file specified");
        }
        fileOutputStream.write(new byte[44], 0, 44);
    }
}
