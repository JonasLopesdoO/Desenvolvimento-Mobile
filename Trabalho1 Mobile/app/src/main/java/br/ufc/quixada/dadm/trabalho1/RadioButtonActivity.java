package br.ufc.quixada.dadm.trabalho1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup1 = findViewById(R.id.radioGroup);
        radioGroup1.clearCheck();

        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup2.clearCheck();

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);

                if(radioButton != null && checkedId > -1){
                    Log.d("RadioButtonActivity", "Escolheu uma das opções de time");
                    Toast.makeText(RadioButtonActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);

                if(radioButton != null && checkedId > -1){
                    Log.d("RadioButtonActivity", "Escolheu uma das opções de premios");
                    Toast.makeText(RadioButtonActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClear(View view){
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
    }

    public void onSubmit(View view){
        RadioButton radioButton1 = radioGroup1.findViewById(radioGroup1.getCheckedRadioButtonId());
        RadioButton radioButton2 = radioGroup2.findViewById(radioGroup2.getCheckedRadioButtonId());

        Toast.makeText(RadioButtonActivity.this, "Você escolheu o time " + radioButton1.getText() +
                                                        ", seu time possui " + radioButton2.getText() + " títulos", Toast.LENGTH_SHORT).show();

    }
}
