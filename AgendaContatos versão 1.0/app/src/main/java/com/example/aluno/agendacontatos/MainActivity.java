package com.example.aluno.agendacontatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.aluno.agendacontatos.Model.Contato;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtTelefone, edtEndereco;
    ListView listView;

    FirebaseDatabase fireBaseDatabase;
    DatabaseReference databaseReference;

    private ArrayList<Contato> listaContatos = new ArrayList<>();
    private ArrayAdapter<Contato> arrayAdapterContato;

    Contato contatoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEndereco = findViewById(R.id.edtEndereco);
        listView = findViewById(R.id.listView);

        iniciarFirebase();
        dispararAtualizacao();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contatoSelecionado = (Contato)parent.getItemAtPosition(position);
                edtNome.setText(contatoSelecionado.getNome());
                edtTelefone.setText(contatoSelecionado.getTelefone());
                edtEndereco.setText(contatoSelecionado.getEndereco());
            }
        });
    }

    private void dispararAtualizacao() {
        databaseReference.child("Contato").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaContatos.clear();
                for(DataSnapshot objSnap : dataSnapshot.getChildren()){
                    Contato contato = objSnap.getValue(Contato.class);

                    listaContatos.add(contato);
                }
                arrayAdapterContato = new ArrayAdapter<Contato>(MainActivity.this, android.R.layout.simple_list_item_1, listaContatos);
                listView.setAdapter(arrayAdapterContato);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void iniciarFirebase(){
        FirebaseApp.initializeApp(MainActivity.this);
        fireBaseDatabase = FirebaseDatabase.getInstance();
        fireBaseDatabase.setPersistenceEnabled(true);
        databaseReference = fireBaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Contato contato;

        if(id == R.id.menu_novo){
            contato = new Contato();
            contato.setUid(UUID.randomUUID().toString());
            contato.setNome(edtNome.getText().toString());
            contato.setTelefone(edtTelefone.getText().toString());
            contato.setEndereco(edtEndereco.getText().toString());

            databaseReference.child("Contato").child(contato.getUid()).setValue(contato);

            limparCamposTexto();
        }else if(id == R.id.menu_atualiza){
            contato = new Contato();
            contato.setUid(contatoSelecionado.getUid());
            contato.setNome(edtNome.getText().toString().trim());
            contato.setTelefone(edtTelefone.getText().toString().trim());
            contato.setEndereco(edtEndereco.getText().toString().trim());

            databaseReference.child("Contato").child(contato.getUid()).setValue(contato);
            limparCamposTexto();
        }else if(id == R.id.menu_deleta){
            contato = new Contato();
            contato.setUid(contatoSelecionado.getUid());
            databaseReference.child("Contato").child(contato.getUid()).removeValue();
            limparCamposTexto();
        }

        return true;
    }

    private void limparCamposTexto(){
        edtNome.setText("");
        edtTelefone.setText("");
        edtEndereco.setText("");
    }

}
