package br.ufc.quixada.dadm.trabalho1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;


public class DropDownPopupActivity extends AppCompatActivity {


    private Button btnMenu;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_popup);


        layout = findViewById(R.id.layout);
        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criando a instancia do popup menu
                PopupMenu popup = new PopupMenu(DropDownPopupActivity.this, btnMenu);
                //Inflar o menu acionado pelo botão
                popup.getMenuInflater().inflate(R.menu.drop_down_menu, popup.getMenu());

                //registrando o popup com o evento OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("WrongConstant")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String imagem = (String) item.getTitle();
                        imagem.toLowerCase();

                        if(imagem.equalsIgnoreCase("goku")){
                            layout.setBackgroundResource(R.drawable.goku);
                        }else if(imagem.equalsIgnoreCase("vegeta")){
                            layout.setBackgroundResource(R.drawable.vegeta);
                        }

                        Toast.makeText(DropDownPopupActivity.this, "Você selecionou " + item.getTitle(), 400).show();
                        return true;
                    }
                });
                popup.show();
            }
        });

        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                layout.setBackgroundResource(R.drawable.layout);
                Toast.makeText(DropDownPopupActivity.this, "Imagem apagada", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
