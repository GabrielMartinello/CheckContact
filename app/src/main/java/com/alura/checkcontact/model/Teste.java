package com.alura.checkcontact.model;

import java.io.Serializable;

public class Teste implements Serializable{

    private final String titulo;
    private final String descricao;

    public Teste(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}