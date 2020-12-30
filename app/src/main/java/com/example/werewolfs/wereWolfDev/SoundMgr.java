package com.example.werewolfs.wereWolfDev;
/** 用途 : 語音*/

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.PowerManager;
import android.util.Log;

import com.example.werewolfs.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class SoundMgr implements MediaPlayer.OnCompletionListener{

    private static final String TAG = "Sound";
    private final Context mContext;
    public MediaPlayer mediaPlayer; //播放中
    public MediaPlayer cd;
    private SoundPool sp;
    private HashMap<Integer, Integer> soundID = new HashMap<Integer, Integer>();
    private ArrayBlockingQueue<MediaPlayer> queue = new ArrayBlockingQueue<>(5);

    public SoundMgr(Context context){
        mContext = context;
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setWakeMode(context, PowerManager.PARTIAL_WAKE_LOCK);
    }

    public void playSound(int _id){
        Log.d(TAG, "play -> " + _id);

        if(mediaPlayer.isPlaying()){
            cd = MediaPlayer.create(mContext, _id);
            cd.setOnCompletionListener(this);
            queue.offer(cd);
        }else{
            mediaPlayer = MediaPlayer.create(mContext, _id);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.start();
        }
    }

    public void cancelSound() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    public void preLoadSoundResource(Context context){
        sp = new SoundPool(50, AudioManager.STREAM_MUSIC, 5);
        soundID.put(1 , sp.load(context, R.raw.bear_close, 1));
        soundID.put(2 , sp.load(context, R.raw.bear_open, 1));
        soundID.put(3 , sp.load(context, R.raw.bomb_skill, 1));
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        //只要完成播放 檢查queue 有聲音在排隊的話 拿出來播放
        if(queue.peek() != null){
            mediaPlayer = queue.poll(); //mediaPlayer指向新的參照 舊的會自動被回收(?)
            mediaPlayer.start();
        }
    }
}
