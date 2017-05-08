package com.example.oem.aps2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
    }
    public void OnClickCrudUsuario(View V){
        int idBotao = 1;
        Intent it = new Intent(AdminScreen.this, CRUD.class);
        it.putExtra("IDbotao", idBotao);
        startActivity(it);
    }
    public void OnClickCrudItem(View V){
        int idBotao = 2;
        Intent it = new Intent(AdminScreen.this, CRUD.class);
        it.putExtra("IDbotao", idBotao);
        startActivity(it);
    }
    public void OnClickCrudFornecedor(View V){
        int idBotao = 3;
        Intent it = new Intent(AdminScreen.this, CRUD.class);
        it.putExtra("IDbotao", idBotao);
        startActivity(it);
    }
}
