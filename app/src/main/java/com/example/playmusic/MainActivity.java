package com.example.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

private Button button;
private Button button2;
private SeekBar seekBar;
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // for playing songs of local devic
          mediaPlayer=MediaPlayer.create(this,R.raw.yar);//yar is the mmusic name
        mediaPlayer.start();



        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        seekBar=findViewById(R.id.seekBar);

        // for remote playing snogs
//        mediaPlayer=new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource("https://gaana.com/song/tum-bin-11");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.start();
             seekBar.setMax(mediaPlayer.getDuration());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    mediaPlayer.seekTo(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
           // }

       // });
        //mediaPlayer.prepareAsync();

button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

    }
}