package br.ufc.quixada.dadm.trabalho1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ToggleButton toggleButton;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        toggleButton = findViewById(R.id.toggleButton);
        layout = findViewById(R.id.layout);

        toggleButton.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonToggle, boolean isChecked) {
        if(isChecked){
            Log.d("ToggleButtonActivity", "mudou a cor do background para preto");
            layout.setBackgroundColor(Color.BLACK);
        }else{
            Log.d("ToggleButtonActivity", "mudou a cor do background para branco");
            layout.setBackgroundColor(Color.WHITE);
        }
    }

}
