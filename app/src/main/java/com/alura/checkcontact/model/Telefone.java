package com.alura.checkcontact.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "TELEFONE")
public class Telefone {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String numero;
    private TipoTelefone tipoTelefone;
    @ForeignKey(
            entity = Usuario.class,
            parentColumns = "id",
            childColumns = "usuarioId",
            onUpdate = CASCADE,
            onDelete = CASCADE)
    private String usuarioId;

    public Telefone(String numero, TipoTelefone tipoTelefone) {
        this.numero = numero;
        this.tipoTelefone = tipoTelefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
