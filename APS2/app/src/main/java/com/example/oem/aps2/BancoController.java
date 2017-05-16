package com.example.oem.aps2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String AddUsuario(String nome, String senha, String nick, String email){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.COLUNA_NOME, nome);
        valores.put(CriaBanco.COLUNA_SENHA, senha);
        valores.put(CriaBanco.COLUNA_NICK, nick);
        valores.put(CriaBanco.COLUNA_EMAIL, email);

        resultado = db.insert(CriaBanco.TABELA_USUARIO, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public Cursor CarregaDadosUsuario(){
        Cursor cursor;
        String[] campos =  {banco.COLUNA_CODIGO, banco.COLUNA_NICK};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_USUARIO, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor CarregaDadoByIdUsuario(int id){
        Cursor cursor;
        String[] campos =  {banco.COLUNA_CODIGO,banco.COLUNA_NOME,banco.COLUNA_SENHA,banco.COLUNA_NICK,banco.COLUNA_EMAIL};
        String where = CriaBanco.COLUNA_CODIGO + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_USUARIO,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor _CarregaDadoByNickUsuario(String nick){
        Cursor cursor;
        String[] campos =  {banco.COLUNA_NICK, banco.COLUNA_SENHA};

            String where = CriaBanco.COLUNA_NICK + "=" + nick;
            db = banco.getReadableDatabase();
            cursor = db.query(CriaBanco.TABELA_USUARIO,campos,where, null, null, null, null, null);


        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
    // Se  return 1, entao usuaio existe, se 0 nao existe.
    public int CarregaDadoByNickUsuario(String nick, String senha){
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE nick = ? AND senha = ?", new String[]{nick, senha});

        if(cursor.moveToFirst()){
            cursor.close();
            db.close();

            return 1;
        }
        cursor.close();
        db.close();
        return 0;
    }
    public void AlteraRegistroUsuario(int id, String nome, String senha, String nick, String email){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.COLUNA_CODIGO + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.COLUNA_NOME, nome);
        valores.put(CriaBanco.COLUNA_SENHA, senha);
        valores.put(CriaBanco.COLUNA_NICK, nick);
        valores.put(CriaBanco.COLUNA_EMAIL, email);

        db.update(CriaBanco.TABELA_USUARIO,valores,where,null);
        db.close();
    }
    public void DeletaRegistroUsuario(int id){
        String where = CriaBanco.COLUNA_CODIGO + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA_USUARIO,where,null);
        db.close();
    }

    public String AddFornecedor(String nome, String email, String descricao){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.COLUNA_NOME, nome);
        valores.put(CriaBanco.COLUNA_EMAIL, email);
        valores.put(CriaBanco.COLUNA_DESCRICAO, descricao);

        resultado = db.insert(CriaBanco.TABELA_FORNECEDOR, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public Cursor CarregaDadosFornecedor(){
        Cursor cursor;
        String[] campos =  {banco.COLUNA_CODIGO, banco.COLUNA_NOME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_FORNECEDOR, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor CarregaDadoByIdFornecedor(int id){
        Cursor cursor;
        String[] campos =  {banco.COLUNA_CODIGO,banco.COLUNA_NOME, banco.COLUNA_EMAIL, banco.COLUNA_DESCRICAO};
        String where = CriaBanco.COLUNA_CODIGO + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_FORNECEDOR,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public void AlteraRegistroFornecedor(int id, String nome, String email, String descricao){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.COLUNA_CODIGO + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.COLUNA_NOME, nome);
        valores.put(CriaBanco.COLUNA_EMAIL, email);
        valores.put(CriaBanco.COLUNA_DESCRICAO, descricao);;

        db.update(CriaBanco.TABELA_FORNECEDOR,valores,where,null);
        db.close();
    }
    public void DeletaRegistroFornecedor(int id){
        String where = CriaBanco.COLUNA_CODIGO + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA_FORNECEDOR,where,null);
        db.close();
    }

    public String AddItem(String nome, String descricao){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.COLUNA_NOME, nome);
        valores.put(CriaBanco.COLUNA_DESCRICAO, descricao);

        resultado = db.insert(CriaBanco.TABELA_ITEM, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public Cursor CarregaDadosItem(){
        Cursor cursor;
        String[] campos =  {banco.COLUNA_CODIGO, banco.COLUNA_NOME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_ITEM, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor CarregaDadoByIdItem(int id){
        Cursor cursor;
        String[] campos =  {banco.COLUNA_CODIGO,banco.COLUNA_NOME, banco.COLUNA_DESCRICAO};
        String where = CriaBanco.COLUNA_CODIGO + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_ITEM,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public void AlteraRegistroItem(int id, String nome, String descricao){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.COLUNA_CODIGO + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.COLUNA_NOME, nome);
        valores.put(CriaBanco.COLUNA_DESCRICAO, descricao);;

        db.update(CriaBanco.TABELA_ITEM,valores,where,null);
        db.close();
    }
    public void DeletaRegistroItem(int id){
        String where = CriaBanco.COLUNA_CODIGO + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA_ITEM,where,null);
        db.close();
    }
}
