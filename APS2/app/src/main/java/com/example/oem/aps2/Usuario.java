package com.example.oem.aps2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by clayton on 26/03/17.
 */

public class Usuario implements Parcelable{

    public int codigo;
    public String nome;
    public String senha;

    public Usuario(int codigo, String nome, String senha){
        this.codigo=codigo;
        this.nome=nome;
        this.senha=senha;
    }

    private Usuario(Parcel from){
        codigo=from.readInt();
        nome=from.readString();
        senha=from.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>()
    {
        public Usuario createFromParcel(Parcel in){
            return new Usuario(in);
        }

        public Usuario[] newArray(int size){
            return new Usuario[size];
        }
    };

    //este método contém um número que servirá como identificador único dessa classe no projeto
    @Override
    public int describeContents() {
        return 0;
    }

    //este método serializa (transforma em bytes) os atributos da classe
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nome);
        dest.writeString(senha);
    }
}
