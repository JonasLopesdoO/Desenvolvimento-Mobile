package br.com.ufc.trabalho3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.ufc.trabalho3.ServiceBroadcast.ServiceDownloadQuestao1;

public class DownloadServiceActivity extends AppCompatActivity {

    Button btnStartDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_service);

        btnStartDownload = findViewById(R.id.button1);

        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadServiceActivity.this, ServiceDownloadQuestao1.class);
                startService(intent);
            }
        });
    }

}
