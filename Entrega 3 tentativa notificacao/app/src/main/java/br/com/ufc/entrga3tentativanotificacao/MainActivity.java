package br.com.ufc.entrga3tentativanotificacao;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {

    TextView conditionView;
    Button buttonSunny, buttonFoggy;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = databaseReference.child("condition");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conditionView = findViewById(R.id.condicao);
        buttonFoggy = findViewById(R.id.foggy);
        buttonSunny= findViewById(R.id.sunny);
    }

    @Override
    protected void onStart() {
        super.onStart();

        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                conditionView.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        buttonSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditionRef.setValue("Sunny");
            }
        });

        buttonFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditionRef.setValue("Foggy");
            }
        });
    }
}
