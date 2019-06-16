package br.com.ufc.trabalho3.ServiceBroadcast;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

public class ServiceDownloadQuestao1 extends Service {

    DownloadManager downloadManager;

    public ArrayList<Downloader> threads = new ArrayList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Script", "OnCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Script", "OnStarCommand");

        Downloader worker = new Downloader(startId);
        worker.start();
        threads.add(worker);

        return super.onStartCommand(intent, flags, startId);
    }

    public class Downloader extends Thread {

        int startId;
        boolean ativo = true;

        public Downloader(int startId) {
            this.startId = startId;
        }

        public void run() {

            do {

                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://optclean.com.br/wp-content/uploads/2018/04/fe7c88e53390305442ae1ce3661f27ed.jpg");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);

                Log.d("Script", "BAIXANDO ARQUIVO");

                Cursor c = downloadManager.query(new DownloadManager.Query().setFilterById(reference));
                if (c.moveToFirst()) {
                    int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                    if (status == DownloadManager.STATUS_SUCCESSFUL) {
                        Log.d("Script", "STATUS  - baixado");
                        stopSelf(startId);
                    }
                }

                stopSelf(startId);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (ativo);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        for (int i = 0, tam = threads.size(); i < tam; i++) {
            threads.get(i).ativo = false;
        }
    }
}
