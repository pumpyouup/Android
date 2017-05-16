package com.example.oem.aps2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void OnClickCadastrar(View V){
        Intent it = new Intent(LogIn.this, CadastroUsuario.class);
        it.putExtra("origem", 1);
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
        else{
            BancoController crud = new BancoController(getBaseContext());
            int logar = crud.CarregaDadoByNickUsuario(login, senha);
            if(logar == 1){
                Intent it = new Intent(LogIn.this, UserScreen.class);
                startActivity(it);
            }else
                Toast.makeText(this, "Erro de login", Toast.LENGTH_LONG).show();
        }


    }

    public void OnClickPDF(View V){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("/lexing.pdf"));
        intent.setType("application/pdf");
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
        if (activities.size() > 0) {
                startActivity(intent);
            } else {
                // Do something else here. Maybe pop up a Dialog or Toast
            }
    }


}
