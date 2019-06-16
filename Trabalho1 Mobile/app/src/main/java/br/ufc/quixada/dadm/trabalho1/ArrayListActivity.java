package br.ufc.quixada.dadm.trabalho1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.ufc.quixada.dadm.trabalho1.transactions.Constants;
import br.ufc.quixada.dadm.trabalho1.transactions.Qualidade;

public class ArrayListActivity extends AppCompatActivity {

    int selected;

    ArrayList<Qualidade> listaQualidades;
    ArrayAdapter<Qualidade> adapter;
    ListView listViewQualidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);

        selected = -1;

        listaQualidades = new ArrayList<Qualidade>();

        adapter = new ArrayAdapter<Qualidade>(this, android.R.layout.simple_list_item_1, listaQualidades);

        listViewQualidades = findViewById(R.id.listViewQualidades);
        listViewQualidades.setAdapter(adapter);
        listViewQualidades.setSelector(android.R.color.holo_blue_light);

        listViewQualidades.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                Toast.makeText(ArrayListActivity.this, "" + listaQualidades.get( position ).toString(), Toast.LENGTH_SHORT).show();
                selected = position;
            }
        } );
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_main_activity, menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add:
                adicionarQualidade();
                break;
            case R.id.edit:
                editarQualidade();
                break;
            case R.id.delete:
                deletarQualidade();
                break;
            case R.id.settings:
                break;
            case R.id.about:
                break;
        }
        return true;
    }

    public void adicionarQualidade(){
        Log.d("AttayListActivity", "Clicando no botao adicionar do menu popup");
        Intent intent = new Intent(this, QualidadeActivity.class);
        startActivityForResult(intent, Constants.REQUEST_ADD);
    }

    public void editarQualidade(){
        Log.d("AttayListActivity", "Clicando no botao editar do menu popup");
        if(listaQualidades.size() > 0){
            Intent intent = new Intent(this, QualidadeActivity.class);

            Qualidade qualidade = listaQualidades.get(selected);

            intent.putExtra("id", qualidade.getId());
            intent.putExtra("nome", qualidade.getNome());
            intent.putExtra("descricao", qualidade.getDescricao());

            startActivityForResult(intent, Constants.REQUEST_EDIT);
        }
    }

    public void deletarQualidade(){
        Log.d("AttayListActivity", "Clicando no botao deletar do menu popup");
        if(listaQualidades.size() > 0){
            listaQualidades.remove(selected);
            adapter.notifyDataSetChanged();

        }else{
            selected = -1;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Constants.REQUEST_ADD && resultCode == Constants.RESULT_ADD){

            assert data != null;
            String nome = ( String )data.getExtras().get( "nome" );
            String descricao = ( String )data.getExtras().get( "descricao" );

            Qualidade qualidade = new Qualidade(nome, descricao);

            Log.d("AttayListActivity", "Adicionando nova qualidade na lista");

            listaQualidades.add(qualidade);
            adapter.notifyDataSetChanged();

        } else if(requestCode == Constants.REQUEST_EDIT && resultCode == Constants.RESULT_ADD){

            String nome = ( String )data.getExtras().get( "nome" );
            String descricao = ( String )data.getExtras().get( "descricao" );

            int idEditar = (int) data.getExtras().get("id");

            for( Qualidade qualidade : listaQualidades){

                if(qualidade.getId() == idEditar){
                    qualidade.setNome(nome);
                    qualidade.setDescricao(descricao);
                    break;
                }
            }

            adapter.notifyDataSetChanged();

        } //Retorno da tela de contatos com um conteudo para ser adicionado
        //Na segunda tela, o usuario clicou no botão ADD
        else if( resultCode == Constants.RESULT_CANCEL ){
            Toast.makeText( this,"Cancelado",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
