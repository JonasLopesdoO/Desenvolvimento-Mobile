package br.com.ufc.trabalho3.ServiceBroadcast;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class IntentServiceDownloadQuestao2 extends IntentService {

    DownloadManager downloadManager;

    private boolean ativo;
    private boolean stopAll;
    private int count;


    public IntentServiceDownloadQuestao2() {
        super("IntentServiceDownloadQuestao2Thread");
        ativo = true;
        stopAll = true;

        count = 0;
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
        while(stopAll && ativo && count < 1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse("https://images4.alphacoders.com/848/848876.png");
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            Long reference = downloadManager.enqueue(request);

            Log.d("Script", "BAIXANDO ARQUIVO");

            Cursor c = downloadManager.query(new DownloadManager.Query().setFilterById(reference));
            if (c.moveToFirst()) {
                int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                if (status == DownloadManager.STATUS_SUCCESSFUL) {
                    Log.d("Script", "STATUS  - baixado");
                }
            }
            count++;
        }
        ativo = true;
        count = 0;
    }

}
