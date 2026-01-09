package com.example.adzanapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();

    private TextView txtArab, txtLatin, txtNegara, txtMuadzin;
    private ListView listAdzan;
    private Button btnPlay, btnPause, btnStop;
    private AudioVisualizerView visualizer;

    private int indexTeks = 0;
    private boolean isPaused = false;

    private List<AdzanModel> adzanList;
    private AdzanModel currentAdzan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtArab = findViewById(R.id.txtArab);
        txtLatin = findViewById(R.id.txtLatin);
        txtNegara = findViewById(R.id.txtNegara);
        txtMuadzin = findViewById(R.id.txtMuadzin);
        listAdzan = findViewById(R.id.listAdzan);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);
        visualizer = findViewById(R.id.audioVisualizer);

        txtArab.setSelected(true); // marquee

        adzanList = AdzanData.getList();
        AdzanAdapter adapter = new AdzanAdapter(this, adzanList);
        listAdzan.setAdapter(adapter);

        listAdzan.setOnItemClickListener((parent, view, position, id) -> {
            stopAdzan();
            currentAdzan = adzanList.get(position);
            txtNegara.setText(currentAdzan.getNegara());
            txtMuadzin.setText(currentAdzan.getMuadzin());
            playAdzan();
        });

        btnPlay.setOnClickListener(v -> playAdzan());
        btnPause.setOnClickListener(v -> pauseAdzan());
        btnStop.setOnClickListener(v -> stopAdzan());
    }

    // ================= PLAY =================
    private void playAdzan() {
        if (currentAdzan == null) return;

        // Cegah dobel
        if (mediaPlayer != null && mediaPlayer.isPlaying()) return;

        // Lanjut dari pause
        if (mediaPlayer != null && isPaused) {
            mediaPlayer.start();
            visualizer.setAudioSessionId(mediaPlayer.getAudioSessionId());
            isPaused = false;
            tampilkanTeks();
            return;
        }

        // Play baru
        indexTeks = 0;
        isPaused = false;

        mediaPlayer = MediaPlayer.create(this, currentAdzan.getAudioRes());
        mediaPlayer.start();
        visualizer.setAudioSessionId(mediaPlayer.getAudioSessionId());

        tampilkanTeks();
    }

    // ================= PAUSE =================
    private void pauseAdzan() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            handler.removeCallbacksAndMessages(null);
            isPaused = true;
        }
    }

    // ================= STOP =================
    private void stopAdzan() {
        handler.removeCallbacksAndMessages(null);
        indexTeks = 0;
        isPaused = false;

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        if (visualizer != null) {
            visualizer.release();
        }

        txtArab.setText("");
        txtLatin.setText("");
    }

    // ================= TEKS SYNC =================
    private void tampilkanTeks() {
        if (currentAdzan == null) return;
        if (indexTeks >= currentAdzan.getArab().length) return;

        txtArab.setText(currentAdzan.getArab()[indexTeks]);
        txtLatin.setText(currentAdzan.getLatin()[indexTeks]);

        handler.postDelayed(() -> {
            indexTeks++;
            tampilkanTeks();
        }, currentAdzan.getDurations()[indexTeks]);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAdzan();
    }
}










