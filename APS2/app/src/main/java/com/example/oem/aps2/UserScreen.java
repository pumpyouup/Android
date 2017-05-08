package com.example.oem.aps2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);


        TextView txt = (TextView) findViewById(R.id.tvIdentficacao);
        Intent it = getIntent();

        Usuario usuario = it.getParcelableExtra("usuario");
        if (usuario != null) {
            String texto = String.format("Bem vindo: %s!", usuario.nome);
            txt.setText(texto);
        }
    }
}
