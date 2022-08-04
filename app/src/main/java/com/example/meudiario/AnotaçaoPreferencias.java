package com.example.meudiario;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotaçaoPreferencias {
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private  final String NOME_ARQUIVO =  "Anotaçao.preferencias";
    private  final String CHAVE_NOME = "nome";
    public AnotaçaoPreferencias(Context c){
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String Anotaçao){
   editor.putString(CHAVE_NOME, Anotaçao);
   editor.commit();

    }

    public String recuperarAnotaçao(){
        return preferences.getString(CHAVE_NOME, "");
    }
}
