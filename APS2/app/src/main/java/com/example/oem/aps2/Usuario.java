package com.example.oem.aps2;

/**
 * Created by oem on 15/05/17.
 */

public class Usuario {
    private int codigo;
    private String nome;
    private String senha;
    private String email;
    private String nick;

    public Usuario(int codigo, String nome, String senha, String email, String nick) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.nick = nick;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
