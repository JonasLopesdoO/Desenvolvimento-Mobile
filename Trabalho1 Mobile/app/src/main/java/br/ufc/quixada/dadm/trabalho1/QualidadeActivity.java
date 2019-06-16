package br.ufc.quixada.dadm.trabalho1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.ufc.quixada.dadm.trabalho1.transactions.Constants;


public class QualidadeActivity extends AppCompatActivity {
    EditText edtNome;
    EditText edtDescricao;

    boolean edit;
    int idQualidadeEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualidade);

        edtNome = findViewById(R.id.edtNome);
        edtDescricao = findViewById(R.id.edtDescricao);

        edit = false;

        if(getIntent().getExtras() != null){
            String nome = (String)getIntent().getExtras().get("nome");
            String descricao = (String)getIntent().getExtras().get("descricao");
            idQualidadeEditar = (int)getIntent().getExtras().get("id");

            edtNome.setText(nome);
            edtDescricao.setText(descricao);

            edit = true;
        }
    }

    public void cancelar(View view){
        setResult(Constants.RESULT_CANCEL);
        finish();
    }

    public void adicionar(View view){
        Intent intent = new Intent();

        String nome = edtNome.getText().toString();
        String descricao = edtDescricao.getText().toString();

        intent.putExtra("nome", nome);
        intent.putExtra("descricao", descricao);

        if(edit){
            intent.putExtra("id", idQualidadeEditar);
        }

        setResult(Constants.RESULT_ADD, intent);
        finish();
    }

}
