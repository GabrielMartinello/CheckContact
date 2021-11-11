package com.alura.checkcontact.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "USUARIO")
public class Usuario implements Serializable {

    @PrimaryKey
    @NonNull
    private String id;
    private String senha;

    public Usuario () {}

    public Usuario(@NonNull String id, String senha) {
        this.id = id;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public boolean temIdValido() {
        return !id.equals("");
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return id;
    }
}
