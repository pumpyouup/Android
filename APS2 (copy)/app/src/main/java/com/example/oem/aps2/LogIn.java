package com.example.oem.aps2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void OnClickCadastrar(View V){
        Intent it = new Intent(LogIn.this, CadastroUsuario.class);
        startActivity(it);
    }

    public void OnClickLogar(View V){
        EditText loginEdit =  (EditText) findViewById(R.id.etLogin);
        EditText senhaEdit =  (EditText) findViewById(R.id.eSenha);
        String login = (String) loginEdit.getText().toString();
        String senha = (String) senhaEdit.getText().toString();
        if(login.equals("") && senha.equals("")){
            Intent it = new Intent(LogIn.this, AdminScreen.class);
            startActivity(it);
        }
        if(login.equals("cliente") && senha.equals("123")){
            Intent it = new Intent(LogIn.this, UserScreen.class);
            startActivity(it);
        }

    }


}
