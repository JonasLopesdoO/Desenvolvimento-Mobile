package br.ufc.quixada.dadm.trabalho1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //primeira parte contendo os botoes de 1 a 5 buttons na MainActivity
    public void clicarToggleActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o TOGGLE BUTTON");
        Intent intent = new Intent(this, ToggleButtonActivity.class);
        startActivity(intent);
    }
    public void clicarEditTextActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o EDIT TEXT");
        Intent intent = new Intent(this, EditTextActivity.class);
        startActivity(intent);
    }
    public void clicarArrayListActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o ARRAY LIST");
        Intent intent = new Intent(this, ArrayListActivity.class);
        startActivity(intent);
    }
    public void clicarAutoCompleteActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o AUTO COMPLETE");
        Intent intent = new Intent(this, AutoCompleteActivity.class);
        startActivity(intent);
    }
    public void clicarSpinnerActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o SPINNER");
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }

    //segunda parte contendo os botoes de 6 a 10 da MainActivity
    public void clicarRadioButtonActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o RADIO BUTTON");
        Intent intent = new Intent(this, RadioButtonActivity.class);
        startActivity(intent);
    }

    public void clicarDropPopupActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o DROPDOWN / POPUP");
        Intent intent = new Intent(this, DropDownPopupActivity.class);
        startActivity(intent);
    }

    public void clicarMultiplasabsTActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o MULTIPLAS TABS");
        Intent intent = new Intent(this, MultiplasTabsActivity.class);
        startActivity(intent);
    }

    //quarta parte contendo os botoes de 16 e 17 da MainActivity
    public void clicarGridViewActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o GRID VIEW");
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }
    public void clicarTocarSomActivity(View view){
        Log.d("MainActivity", "Chamou a activity que executa o TOCAR SOM");
        Intent intent = new Intent(this, TocarSomActivity.class);
        startActivity(intent);
    }
}
