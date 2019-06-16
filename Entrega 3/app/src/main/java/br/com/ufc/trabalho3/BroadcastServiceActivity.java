package br.com.ufc.trabalho3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import br.com.ufc.trabalho3.ServiceBroadcast.ServiceQuestao6;

public class BroadcastServiceActivity extends AppCompatActivity {

    Button btnBroadcastService;
    Button btnParar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_service);

        btnBroadcastService = findViewById(R.id.btnBroadcastService);
        btnParar = findViewById(R.id.btnParar);

        btnBroadcastService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BroadcastServiceActivity.this, "Reinicie o celular/avd e teste no logcat", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BroadcastServiceActivity.this, ServiceQuestao6.class);
                startService(intent);
            }
        });

        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastServiceActivity.this, ServiceQuestao6.class);
                stopService(intent);
            }
        });
    }
}
