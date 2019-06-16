package br.com.ufc.trabalho3.ServiceBroadcast.ServiceBroadcastTeste;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class IntentServiceTeste extends IntentService {

    DownloadManager downloadManager;
    private int count;
    private boolean ativo;
    private boolean stopAll;

    public IntentServiceTeste() {
        super("IntentServiceDownloadQuestao2Thread");
        count = 0;
        ativo = true;
        stopAll = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int starId){
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            int desligar = bundle.getInt("desligar");
            if(desligar == 1){
                stopAll = false;
            }
        }
        return super.onStartCommand(intent, flags, starId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        while(stopAll && ativo && count < 5){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count++;
            Log.d("Script", "COUNT " + count);
        }
        ativo = true;
        count = 0;
    }
}
