package br.com.ufc.trabalho3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.ufc.trabalho3.ServiceBroadcast.IntentServiceDownloadQuestao2;

public class DownloadIntentServiceActivity extends AppCompatActivity {

    Button btnStartDownload;
//    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_intent_service);

        btnStartDownload = findViewById(R.id.btnIntentService);
//        btnStop = findViewById(R.id.btnStopIntentService);

        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadIntentServiceActivity.this, IntentServiceDownloadQuestao2.class);
                startService(intent);
            }
        });

//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DownloadIntentServiceActivity.this, IntentServiceTeste.class);
//                //foi usado um putextras e não somente o stopService, porque no intentService não estava dando stop.
//                intent.putExtra("desligar", 1);
//                startService(intent);
//            }
//        });
    }
}
