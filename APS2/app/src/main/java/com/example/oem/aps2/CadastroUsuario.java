package com.example.oem.aps2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CadastroUsuario extends AppCompatActivity {
    Button bCadastrar, bDeletar, bAtualizar;
    EditText eNome, eSenha, eNick, eEmail;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        crud = new BancoController(getBaseContext());
        eNome = (EditText)findViewById(R.id.eNome);
        eSenha = (EditText)findViewById(R.id.eSenha);
        eNick = (EditText)findViewById(R.id.eUsuario);
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
                    String senha = (String) eSenha.getText().toString();
                    String nick = (String) eNick.getText().toString();
                    String email = (String) eEmail.getText().toString();

                    String resultado;
                    resultado = crud.AddUsuario(nome, senha, nick, email);

                    Intent it = getIntent();
                    int origem = it.getIntExtra("origem", -1);

                    if(origem == 1){
                        Intent intent = new Intent(CadastroUsuario.this, LogIn.class);
                        startActivity(intent);
                        finish();
                    }

                    Intent intent = new Intent(CadastroUsuario.this, CRUD.class);
                    intent.putExtra("IDbotao", 1);
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
            cursor = crud.CarregaDadoByIdUsuario(Integer.parseInt(codigo));
            eNome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_NOME)));
            eSenha.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_SENHA)));
            eNick.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_NICK)));
            eEmail.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.COLUNA_EMAIL)));

            bAtualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crud.AlteraRegistroUsuario(Integer.parseInt(codigo), eNome.getText().toString(),eSenha.getText().toString(),
                            eNick.getText().toString(), eEmail.getText().toString());
                    Intent intent = new Intent(CadastroUsuario.this, CRUD.class);
                    intent.putExtra("IDbotao", 1);
                    startActivity(intent);
                    finish();
                }
            });
            bDeletar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crud.DeletaRegistroUsuario(Integer.parseInt(codigo));
                    Intent intent = new Intent(CadastroUsuario.this, CRUD.class);
                    intent.putExtra("IDbotao", 1);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
