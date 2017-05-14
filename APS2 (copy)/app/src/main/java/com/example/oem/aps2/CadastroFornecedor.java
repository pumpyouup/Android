package com.example.oem.aps2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroFornecedor extends AppCompatActivity {
    Button bCadastrar, bDeletar, bAtualizar;
    EditText eNome, eDescricao, eEmail;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_fornecedor);

        crud = new BancoController(getBaseContext());
        eNome = (EditText)findViewById(R.id.eNome);
        eDescricao = (EditText)findViewById(R.id.eDescricao);
        eEmail = (EditText)findViewById(R.id.eEmail);
        bCadastrar = (Button)findViewById(R.id.bCadastrar);
        bAtualizar = (Button)findViewById(R.id.bAtualizar);
        bDeletar = (Button)findViewById(R.id.bDeletar);

        if(this.getIntent().getStringExtra("codigo") == null){
            bDeletar.setClickable(false);
            bAtualizar.setClickable(false);
            bCadastrar.setClickable(true);
            bCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nome = (String) eNome.getText().toString();
                    String email = (String) eEmail.getText().toString();
                    String descricao = (String) eDescricao.getText().toString();

                    String resultado;
                    resultado = crud.AddFornecedor(nome, email, descricao);

                    Intent intent = new Intent(CadastroFornecedor.this, CRUD.class);
                    intent.putExtra("IDbotao", 3);
                    intent.putExtra("resultado", resultado);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else{
            bCadastrar.setClickable(false);
            bDeletar.setClickable(true);
            bAtualizar.setClickable(true);
            codigo = this.getIntent().getStringExtra("codigo");
            crud = new BancoController(getBaseContext());
            cursor = crud.CarregaDadoByIdFornecedor(Integer.parseInt(codigo));
            eNome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_NOME)));
            eEmail.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_EMAIL)));
            eDescricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_DESCRICAO)));

            bAtualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crud.AlteraRegistroFornecedor(Integer.parseInt(codigo), eNome.getText().toString(),
                            eEmail.getText().toString(), eDescricao.getText().toString());
                    Intent intent = new Intent(CadastroFornecedor.this, CRUD.class);
                    intent.putExtra("IDbotao", 3);
                    startActivity(intent);
                    finish();
                }
            });
            bDeletar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crud.DeletaRegistroFornecedor(Integer.parseInt(codigo));
                    Intent intent = new Intent(CadastroFornecedor.this, CRUD.class);
                    intent.putExtra("IDbotao", 3);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
