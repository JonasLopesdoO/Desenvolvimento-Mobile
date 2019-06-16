package br.ufc.quixada.dadm.trabalho1;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class TocarSomActivity extends AppCompatActivity{
    LinearLayout layout;
    MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tocar_som);

        media = MediaPlayer.create(this, R.raw.sweetchildomine);

        layout = findViewById(R.id.layout);

    }

    public void tocarMusica (View view){
        media.start();
        layout.setBackgroundResource(R.drawable.guns);
    }

    @Override
    protected void onPause() {
        super.onPause();
        media.release();
    }
}
