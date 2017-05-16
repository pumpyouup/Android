package com.example.oem.aps2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CRUD extends AppCompatActivity {
    int idBotao;
    ListView lista;
    Button bAdicionar, bDeletar, bAtualizar;
    Cursor cursor;
    String codigo;
    BancoController crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        TextView txt = (TextView) findViewById(R.id.tvIdentficacao);
        Intent it = getIntent();
        idBotao = it.getIntExtra("IDbotao", -1);
        if(it.getStringExtra("resultado") != null){
            Toast.makeText(this, it.getStringExtra("resultado"), Toast.LENGTH_LONG).show();
        }


        if (idBotao == 1) {
            String texto = String.format("Usuarios");
            txt.setText(texto);

            crud = new BancoController(getBaseContext());
            cursor = crud.CarregaDadosUsuario();

            String[] nomeCampos = new String[] {CriaBanco.COLUNA_CODIGO, CriaBanco.COLUNA_NICK};
            int[] idViews = new int[] {R.id.codigoUsuario, R.id.nickUsuario};

            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.layout_lista,
                    cursor,nomeCampos,idViews, 0);
            lista = (ListView)findViewById(R.id.lista);
            lista.setAdapter(adaptador);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    cursor.moveToPosition(position);
                    codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_CODIGO));
                    Intent intent = new Intent(CRUD.this, CadastroUsuario.class);
                    intent.putExtra("codigo", codigo);
                    startActivity(intent);
                    finish();
                }
            });
        }

        else if (idBotao == 2){
            String texto = String.format("Itens");
            txt.setText(texto);

            crud = new BancoController(getBaseContext());
            cursor = crud.CarregaDadosItem();

            String[] nomeCampos = new String[] {CriaBanco.COLUNA_CODIGO, CriaBanco.COLUNA_NOME};
            int[] idViews = new int[] {R.id.codigoUsuario, R.id.nickUsuario};

            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.layout_lista,
                    cursor,nomeCampos,idViews, 0);
            lista = (ListView)findViewById(R.id.lista);
            lista.setAdapter(adaptador);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    cursor.moveToPosition(position);
                    codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_CODIGO));
                    Intent intent = new Intent(CRUD.this, CadastroItem.class);
                    intent.putExtra("codigo", codigo);
                    startActivity(intent);
                    finish();
                }
            });

        } else if (idBotao == 3) {
            String texto = String.format("Fornecedores");
            txt.setText(texto);

            crud = new BancoController(getBaseContext());
            cursor = crud.CarregaDadosFornecedor();

            String[] nomeCampos = new String[] {CriaBanco.COLUNA_CODIGO, CriaBanco.COLUNA_NOME};
            int[] idViews = new int[] {R.id.codigoUsuario, R.id.nickUsuario};

            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.layout_lista,
                    cursor,nomeCampos,idViews, 0);
            lista = (ListView)findViewById(R.id.lista);
            lista.setAdapter(adaptador);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    cursor.moveToPosition(position);
                    codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_CODIGO));
                    Intent intent = new Intent(CRUD.this, CadastroFornecedor.class);
                    intent.putExtra("codigo", codigo);
                    startActivity(intent);
                    finish();
                }
            });
        }


    }

    public void OnClickCrudDAdd(View V){
        if (idBotao == 1){
            Intent it = new Intent(CRUD.this, CadastroUsuario.class);
            startActivity(it);
        }
        else if (idBotao == 2){
            Intent it = new Intent(CRUD.this, CadastroItem.class);
            startActivity(it);
        }
        else if (idBotao == 3){
            Intent it = new Intent(CRUD.this, CadastroFornecedor.class);
            startActivity(it);
        }
        finish();
    }
}
