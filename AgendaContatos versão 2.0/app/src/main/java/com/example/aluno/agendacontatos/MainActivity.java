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
import android.widget.Toast;

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

    int selected;
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

        selected = -1;

        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEndereco = findViewById(R.id.edtEndereco);

        listView = findViewById(R.id.listView);
        listView.setSelector(android.R.color.holo_green_light);

        iniciarFirebase();
        dispararAtualizacao();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, listaContatos.get(position).getNome(), Toast.LENGTH_SHORT).show();
                contatoSelecionado = (Contato)parent.getItemAtPosition(position);
                edtNome.setText(contatoSelecionado.getNome());
                edtTelefone.setText(contatoSelecionado.getTelefone());
                edtEndereco.setText(contatoSelecionado.getEndereco());

                selected = position;
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
            public void onCancelled(DatabaseError databaseError) {}
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

            if(validaAddEdit(contato)) {
                databaseReference.child("Contato").child(contato.getUid()).setValue(contato);
                Toast.makeText(MainActivity.this, contato.getNome() + " foi adicionado!", Toast.LENGTH_SHORT).show();

                limparCamposTexto();
            }else{
                Toast.makeText(MainActivity.this, "Preencha todos os campos antes de finalizar", Toast.LENGTH_SHORT).show();
            }

        }else if(id == R.id.menu_atualiza){
            contato = new Contato();
            contato.setUid(contatoSelecionado.getUid());
            contato.setNome(edtNome.getText().toString().trim());
            contato.setTelefone(edtTelefone.getText().toString().trim());
            contato.setEndereco(edtEndereco.getText().toString().trim());

            if(validaAddEdit(contato)) {

                databaseReference.child("Contato").child(contato.getUid()).setValue(contato);
                Toast.makeText(MainActivity.this, contato.getNome() + " foi atualizado!", Toast.LENGTH_SHORT).show();

                limparCamposTexto();
            }else{
                Toast.makeText(MainActivity.this, "Preencha todos os campos antes de finalizar", Toast.LENGTH_SHORT).show();
            }

        }else if(id == R.id.menu_deleta){
            contato = new Contato();
            contato.setUid(contatoSelecionado.getUid());
            Toast.makeText(MainActivity.this, "O contato " + contato.getNome() + " foi removido com sucesso!", Toast.LENGTH_SHORT);
            databaseReference.child("Contato").child(contato.getUid()).removeValue();

            limparCamposTexto();
        }
        return true;
    }

    private boolean validaAddEdit(Contato contato) {
        if((contato.getNome() == null || contato.getNome() == "" || contato.getNome().isEmpty())             ||
           (contato.getTelefone() == null || contato.getTelefone() == "" || contato.getTelefone().isEmpty()) ||
           (contato.getEndereco() == null || contato.getEndereco() == "" || contato.getEndereco().isEmpty())){
            return false;
        }
        return true;
    }

    private void limparCamposTexto(){
        edtNome.setText("");
        edtTelefone.setText("");
        edtEndereco.setText("");
    }
}
