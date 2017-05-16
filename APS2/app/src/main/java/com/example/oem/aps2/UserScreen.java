package com.example.oem.aps2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class UserScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.CarregaDadosItem();

        String[] nomeCampos = new String[] {CriaBanco.COLUNA_CODIGO, CriaBanco.COLUNA_NOME};
        int[] idViews = new int[] {R.id.codigoUsuario, R.id.nickUsuario};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.layout_lista,
                cursor,nomeCampos,idViews, 0);
        ListView lista = (ListView)findViewById(R.id.lista);
        lista.setAdapter(adaptador);
    }
}
