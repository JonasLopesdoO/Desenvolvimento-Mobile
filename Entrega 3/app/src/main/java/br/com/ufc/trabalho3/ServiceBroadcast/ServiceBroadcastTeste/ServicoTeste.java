package br.com.ufc.trabalho3.ServiceBroadcast.ServiceBroadcastTeste;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

public class ServicoTeste extends Service {

    public ArrayList<Worker> threads = new ArrayList<>();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("Script", "OnCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Script", "OnStarCommand");

        Worker worker = new Worker(startId);
        worker.start();
        threads.add(worker);

        return super.onStartCommand(intent, flags, startId);
    }

    public class Worker extends Thread {
         int count = 0;
         int startId;
         boolean ativo = true;

        public Worker(int startId){
            this.startId = startId;
        }

        public void run(){
            while(ativo && count < 1000){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count++;
                Log.d("Script", "COUNT" + count);
            }
            stopSelf(startId);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        for(int i = 0, tam = threads.size(); i < tam; i++){
            threads.get(i).ativo = false;
        }
    }

}
