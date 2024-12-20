package com.example.multimediavideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.net.Uri;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button playButton, pauseButton, stopButton;
    private SeekBar seekBarVideo;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        playButton = findViewById(R.id.buttonPlay);
        pauseButton = findViewById(R.id.buttonPause);
        stopButton = findViewById(R.id.buttonStop);
        seekBarVideo = findViewById(R.id.seekBarVideo);

        // Set video URI (Replace R.raw.your_video with your actual video file)
        Uri	videoUri = Uri.parse("android.resource://"	+ getPackageName() + "/" + R.raw.videofile);
        videoView.setVideoURI(videoUri);

        playButton.setOnClickListener(v -> videoView.start());
        pauseButton.setOnClickListener(v -> videoView.pause());
        stopButton.setOnClickListener(v	-> {
            videoView.stopPlayback();
            updateSeekBar();
        });

        videoView.setOnPreparedListener(mp -> {
            seekBarVideo.setMax(videoView.getDuration());
            updateSeekBar();
        });

        seekBarVideo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    videoView.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Implementation not necessary for this example
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Implementation not necessary for this example
            }
        });

    }

    private void updateSeekBar() {
        seekBarVideo.setProgress(videoView.getCurrentPosition());
        if (videoView.isPlaying()) {
            Runnable updater = this::updateSeekBar;
            handler.postDelayed(updater, 1000); // Delay 1 second
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }

}
