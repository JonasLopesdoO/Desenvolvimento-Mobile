package br.com.ufc.trabalho3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.ufc.trabalho3.ServiceBroadcast.ServiceMusicaQuestao3;

public class MusicaServiceActivity extends AppCompatActivity {

    Button btnPlay;
    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica_service);

        btnPlay = findViewById(R.id.btnTocar);
        btnStop = findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicaServiceActivity.this, ServiceMusicaQuestao3.class);
                startService(intent);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicaServiceActivity.this, ServiceMusicaQuestao3.class);
                stopService(intent);
            }
        });
    }
}
