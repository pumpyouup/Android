package com.example.oem.aps2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by clayton on 26/03/17.
 */

public class Item implements Parcelable{

    public int codigo;
    public String nome;

    public Item(int codigo, String nome){
        this.codigo=codigo;
        this.nome=nome;
    }

    private Item(Parcel from){
        codigo=from.readInt();
        nome=from.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>()
    {
        public Item createFromParcel(Parcel in){
            return new Item(in);
        }

        public Item[] newArray(int size){
            return new Item[size];
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
