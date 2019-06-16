package br.com.ufc.trabalho3.ServiceBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastQuestao6 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Script", "onReceive()");
        intent = new Intent("SERVICO_BROADCAST");
        context.startService(intent);
    }
}
