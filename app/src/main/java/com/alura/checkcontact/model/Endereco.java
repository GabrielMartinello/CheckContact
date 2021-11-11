package com.alura.checkcontact.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "ENDERECO")
public class Endereco {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String rua;
    private String cep;
    private String bairro;
    private String numero;
    @ForeignKey(entity = Usuario.class,
            parentColumns = "id",
            childColumns = "idUsuario",
            onDelete = CASCADE,
            onUpdate = CASCADE)
    private String idUsuario;

    public Endereco(String rua,
                    String cep,
                    String bairro,
                    String numero) {
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
