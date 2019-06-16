package br.ufc.quixada.dadm.trabalho1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AutoCompleteActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompletarUniversidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        String universidades[] = {"UFC" , "UFRJ", "UFPI", "UFRO" , "UECE", "UEPI", "USP" , "UNILAB", "URCA", "UFMG" , "CATOLICA", "CISNE",
                                  "UNIQUE", "ESTACIO", "UFMA", "UFRS"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,universidades);
        autoCompletarUniversidades = findViewById(R.id.autoCompleteUniversidade);
        autoCompletarUniversidades.setAdapter(adapter);

    }

    public void escolherUniversidade(View view){
        String universidade = autoCompletarUniversidades.getText().toString();

        if(!universidade.isEmpty()) {
            Toast.makeText(this, "Você escolheu a " + universidade, Toast.LENGTH_SHORT).show();
            Log.d("AutoCompleteActivity", "Mostrou o texto do autocomplete escolhido no TOAST");
        }
    }

}
