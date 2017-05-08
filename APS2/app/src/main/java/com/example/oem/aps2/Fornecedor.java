package com.example.oem.aps2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by clayton on 26/03/17.
 */

public class Fornecedor implements Parcelable{

    public int codigo;
    public String nome;

    public Fornecedor(int codigo, String nome){
        this.codigo=codigo;
        this.nome=nome;
    }

    private Fornecedor(Parcel from){
        codigo=from.readInt();
        nome=from.readString();
    }

    public static final Creator<Fornecedor> CREATOR = new Creator<Fornecedor>()
    {
        public Fornecedor createFromParcel(Parcel in){
            return new Fornecedor(in);
        }

        public Fornecedor[] newArray(int size){
            return new Fornecedor[size];
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
    }
}
