package com.example.adzanapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.audiofx.Visualizer;
import android.util.AttributeSet;
import android.view.View;

public class AudioVisualizerView extends View {

    private Visualizer visualizer;
    private byte[] waveform;
    private Paint paint = new Paint();

    public AudioVisualizerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint.setColor(0xFF1E88E5); // biru
        paint.setStrokeWidth(4f);
        paint.setAntiAlias(true);
    }

    // ===== INI YANG DIPANGGIL DARI MAINACTIVITY =====
    public void setAudioSessionId(int audioSessionId) {
        release();

        visualizer = new Visualizer(audioSessionId);
        visualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
        visualizer.setDataCaptureListener(
                new Visualizer.OnDataCaptureListener() {
                    @Override
                    public void onWaveFormDataCapture(
                            Visualizer visualizer,
                            byte[] waveform,
                            int samplingRate) {
                        AudioVisualizerView.this.waveform = waveform;
                        invalidate();
                    }

                    @Override
                    public void onFftDataCapture(
                            Visualizer visualizer,
                            byte[] fft,
                            int samplingRate) {
                    }
                },
                Visualizer.getMaxCaptureRate() / 2,
                true,
                false
        );

        visualizer.setEnabled(true);
    }

    // ===== DIPANGGIL SAAT STOP =====
    public void release() {
        if (visualizer != null) {
            visualizer.release();
            visualizer = null;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (waveform == null) return;

        float width = getWidth();
        float height = getHeight();
        float centerY = height / 2f;

        float gap = width / (float) waveform.length;

        for (int i = 0; i < waveform.length - 1; i++) {
            float x1 = i * gap;
            float y1 = centerY + ((byte) (waveform[i] + 128)) * (centerY / 128);
            float x2 = (i + 1) * gap;
            float y2 = centerY + ((byte) (waveform[i + 1] + 128)) * (centerY / 128);
            canvas.drawLine(x1, y1, x2, y2, paint);
        }
    }
}


