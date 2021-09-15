package com.example.musikapp;

import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //inisialisasi untuk pemutar video
    private VideoView videoView,videoView2,videoView3;
    private MediaController mediaController,mediaController2,mediaController3;
    private Button playVideo,playVideo2,playVideo3;


    //inisialisasi untuk pemutar musik
    private Button Play, Pause, Stop,Play2,Pause2,Stop2,Play3,Pause3,Stop3;
    private MediaPlayer mediaPlayer,mediaPlayer2,mediaPlayer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi VideoView, MediaController dan Button pada video 1
        videoView = findViewById(R.id.video);
        playVideo = findViewById(R.id.play);
        mediaController = new MediaController(this);


        //Inisialisasi VideoView, MediaController dan Button pada video 2
        videoView2 = findViewById(R.id.video2);
        playVideo2 = findViewById(R.id.play2);
        mediaController2 = new MediaController(this);

        //Inisialisasi VideoView, MediaController dan Button pada video 3
        videoView3 = findViewById(R.id.video3);
        playVideo3 = findViewById(R.id.play3);
        mediaController3 = new MediaController(this);


        //Menjalankan Video saat tombol Play di Klik pada video 1
        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video_1);

                videoView.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);

                //Menjalankan Video
                videoView.start();
            }
        });

        //Menjalankan Video saat tombol Play di Klik pada video 2
        playVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video_2);

                videoView2.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);

                //Menjalankan Video
                videoView2.start();
            }
        });

        //Menjalankan Video saat tombol Play di Klik pada video 3
        playVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video_3);

                videoView3.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);

                //Menjalankan Video
                videoView3.start();
            }
        });

        //inisialisasi pemutar musik

        //Inisialisasi Button
        Play = findViewById(R.id.playMusik);
        Pause = findViewById(R.id.pause);
        Stop = findViewById(R.id.stop);

        //Menambahkan Listener pada Button
        Play.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Stop.setOnClickListener(this);

        Play2 = findViewById(R.id.playMusik2);
        Pause2 = findViewById(R.id.pause2);
        Stop2 = findViewById(R.id.stop2);

        //Menambahkan Listener pada Button
        Play2.setOnClickListener(this);
        Pause2.setOnClickListener(this);
        Stop2.setOnClickListener(this);

        Play3 = findViewById(R.id.playMusik3);
        Pause3 = findViewById(R.id.pause3);
        Stop3 = findViewById(R.id.stop3);

        //Menambahkan Listener pada Button
        Play3.setOnClickListener(this);
        Pause3.setOnClickListener(this);
        Stop3.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){

        Play.setEnabled(true);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play2.setEnabled(true);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play3.setEnabled(true);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

    }

    //Method untuk memainkan musik 1
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this,R.raw.puspa);

        //Kondisi Button setelah tombol play di klik
        Play.setEnabled(false);
        Pause.setEnabled(true);
        Stop.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });

    }

    //Method untuk mengentikan musik
    private void pauseAudio(){
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                Pause.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer != null){
                mediaPlayer.start();
                Pause.setText("Pause");
            }
        }

    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();

    }

    //Method untuk memainkan musik 2
    private void playAudio2(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer2 = MediaPlayer.create(this,R.raw.skj);

        //Kondisi Button setelah tombol play di klik
        Play2.setEnabled(false);
        Pause2.setEnabled(true);
        Stop2.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer2.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer2.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });

    }

    //Method untuk mengentikan musik
    private void pauseAudio2(){
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer2.isPlaying()){
            if(mediaPlayer2 != null){
                mediaPlayer2.pause();
                Pause2.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer2 != null){
                mediaPlayer2.start();
                Pause2.setText("Pause");
            }
        }

    }

    //Method untuk mengakhiri musik
    private void stopAudio2(){
        mediaPlayer2.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer2.prepare();
            mediaPlayer2.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();

    }


    private void playAudio3(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer3 = MediaPlayer.create(this,R.raw.jpb);

        //Kondisi Button setelah tombol play di klik
        Play3.setEnabled(false);
        Pause3.setEnabled(true);
        Stop3.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer3.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer3.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });

    }

    //Method untuk mengentikan musik
    private void pauseAudio3(){
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer3.isPlaying()){
            if(mediaPlayer3 != null){
                mediaPlayer3.pause();
                Pause3.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer3 != null){
                mediaPlayer3.start();
                Pause3.setText("Pause");
            }
        }

    }

    //Method untuk mengakhiri musik
    private void stopAudio3(){
        mediaPlayer3.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer3.prepare();
            mediaPlayer3.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playMusik:
                playAudio();
                break;

            case R.id.pause:
                pauseAudio();
                break;

            case R.id.stop:
                stopAudio();
                break;

            case R.id.playMusik2:
                playAudio2();
                break;

            case R.id.pause2:
                pauseAudio2();
                break;

            case R.id.stop2:
                stopAudio2();
                break;

            case R.id.playMusik3:
                playAudio3();
                break;

            case R.id.pause3:
                pauseAudio3();
                break;

            case R.id.stop3:
                stopAudio3();
                break;
        }
    }
}