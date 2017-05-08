package com.example.oem.aps2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CRUD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        TextView txt = (TextView) findViewById(R.id.tvIdentficacao);
        Intent it = getIntent();


        int idBoatao = it.getIntExtra("IDbotao", -1);

        if (idBoatao == 1) {
            String texto = String.format("Usuarios");
            txt.setText(texto);
        } else if (idBoatao == 2){
            String texto = String.format("Itens");
            txt.setText(texto);
        } else {
            String texto = String.format("Fornecedores");
            txt.setText(texto);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CRUD", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CRUD", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CRUD", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("CRUD", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CRUD", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CRUD", "onDestroy");
    }
}
