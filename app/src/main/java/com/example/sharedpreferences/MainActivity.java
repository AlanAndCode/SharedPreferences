package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
 private Button buttonSalvar;
 private TextView textDefinirUsuario;
 private TextInputEditText Editnome;
 private static final  String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        textDefinirUsuario = findViewById(R.id.textDefinirUsuario);
        Editnome = findViewById(R.id.Editnome);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                //Validar o nome
                if( Editnome.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_LONG).show();
                }else {
                    String nome = Editnome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textDefinirUsuario.setText("olá, " + nome);
                }
            }
        });

        //recuperar dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        //valida nome preferencias
        if( preferences.contains("nome")){
            String nome = preferences.getString("nome", "Olá, usuario nao definido");
            textDefinirUsuario.setText("Ola, " + nome);
        }else {
            textDefinirUsuario.setText("Olá, usuario nao definido");
        }
    }
}