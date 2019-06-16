package br.com.ufc.trabalho3.ServiceBroadcast;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class ServiceMusicaQuestao3 extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "Service criado!", Toast.LENGTH_SHORT).show();
        mediaPlayer = (MediaPlayer) MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        Log.d("Script", "OnCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Script", "OnStarCommand");

        Toast.makeText(this, "Service iniciado", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service destruído", Toast.LENGTH_SHORT).show();
        mediaPlayer.release();
        
        super.onDestroy();

    }
}
