package com.example.multimediaaudioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button playPauseButton, stopButton;
    private SeekBar seekBarAudio;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPauseButton = findViewById(R.id.buttonPlayPause);
        stopButton = findViewById(R.id.buttonStop);
        seekBarAudio = findViewById(R.id.seekBarAudio);

        mediaPlayer = MediaPlayer.create(this, R.raw.androidringtone);

        playPauseButton.setOnClickListener(v -> {
            if(!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                updateSeekBar();
            }else{
                mediaPlayer.pause();
            }
        });

        stopButton.setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer	= MediaPlayer.create(getApplicationContext(), R.raw.androidringtone); // Reinitialize MediaPlayer
            updateSeekBar();
        });

        seekBarAudio.setMax(mediaPlayer.getDuration());
        seekBarAudio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Implementation not needed for this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Implementation not needed for this example
            }
        });

    }

    private void updateSeekBar() {
        seekBarAudio.setProgress(mediaPlayer.getCurrentPosition());
        if (mediaPlayer.isPlaying()) {
            Runnable updater = this::updateSeekBar;
            handler.postDelayed(updater, 1000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        }
    }
}
