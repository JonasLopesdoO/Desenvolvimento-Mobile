package br.com.ufc.trabalho3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnServiceDownload;
    Button btnIntentServiceDownload;
    Button btnMusicaComService;
    Button btnBroadcastServiceBoot;


    Button btnExplicacao1e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnServiceDownload = findViewById(R.id.btnServiceDownload);
        btnIntentServiceDownload = findViewById(R.id.btnIntentServiceDownload);
        btnMusicaComService = findViewById(R.id.btnMusicaComService);
        btnMusicaComService = findViewById(R.id.btnMusicaComService);

        btnBroadcastServiceBoot = findViewById(R.id.btnBroadcastServiceBoot);

        btnExplicacao1e2 = findViewById(R.id.btnExplicacao1e2);

        btnServiceDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DownloadServiceActivity.class);
                startActivity(intent);
            }
        });

        btnIntentServiceDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DownloadIntentServiceActivity.class);
                startActivity(intent);
            }
        });

        btnMusicaComService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicaServiceActivity.class);
                startActivity(intent);
            }
        });

        btnBroadcastServiceBoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BroadcastServiceActivity.class);
                startActivity(intent);
            }
        });



        btnExplicacao1e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Explicacao1e2Activity.class);
                startActivity(intent);
            }
        });
    }


}
