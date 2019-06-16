package br.ufc.quixada.dadm.trabalho1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtSobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

    }

    public void btnMotivar( View view ){

        edtNome = findViewById( R.id.edtNome );
        edtSobrenome = findViewById( R.id.edtSobrenome );

        String nome = edtNome.getText().toString();
        String sobrenome = edtSobrenome.getText().toString();

        String resultado = "Olá " + nome + " " + sobrenome + "! Você é F#$@ -> Incrível";

        Toast.makeText( this, "" + resultado, Toast.LENGTH_SHORT).show();
        Log.d("EditTextActivity", "mostrou a mensagem em TOAST");
    }
}
