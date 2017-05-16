package com.example.oem.aps2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {
    private static final int VERSAO_BANCO = 1;
    private static final String NOME_BANCO = "BANCO";

    protected static final String TABELA_USUARIO = "usuarios";
    protected static final String TABELA_ITEM = "itens";
    protected static final String TABELA_FORNECEDOR = "fornecedores";
    protected static final String COLUNA_CODIGO = "_id";
    protected static final String COLUNA_NOME = "nome";
    protected static final String COLUNA_SENHA = "senha";
    protected static final String COLUNA_EMAIL = "email";
    protected static final String COLUNA_NICK = "nick";
    protected static final String COLUNA_DESCRICAO = "descricao";

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA_USUARIO+"("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUNA_NOME + " TEXT, "
                + COLUNA_SENHA + " TEXT, "
                + COLUNA_NICK + " TEXT, "
                + COLUNA_EMAIL + " TEXT "
                +")";
        db.execSQL(sql);

        String sql2 = "CREATE TABLE "+TABELA_FORNECEDOR+"("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUNA_NOME + " TEXT, "
                + COLUNA_EMAIL + " TEXT, "
                + COLUNA_DESCRICAO + " TEXT "
                +")";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE "+TABELA_ITEM+"("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUNA_NOME + " TEXT, "
                + COLUNA_DESCRICAO + " TEXT "
                +")";
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_FORNECEDOR);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_ITEM);
        onCreate(db);
    }
}