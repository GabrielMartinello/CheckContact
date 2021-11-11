package com.alura.checkcontact.ui.components;

import com.alura.checkcontact.callback.DialogCallback;
import com.alura.checkcontact.callback.DialogClickCallback;

import java.io.Serializable;


public class DialogArgs implements Serializable {
    private String titulo;
    private String conteudo;
    private CharSequence conteudoChar;
    private String enfase;
    private String neutro;
    private DialogClickCallback neutroClick;
    private String sim;
    private DialogClickCallback simClick;
    private String nao;
    private DialogClickCallback naoClick;
    private boolean cancelable;
    private DialogCallback callback;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public CharSequence getConteudoChar() {
        return conteudoChar;
    }

    public void setConteudoChar(CharSequence conteudoChar) {
        this.conteudoChar = conteudoChar;
    }

    public String getEnfase() {
        return enfase;
    }

    public void setEnfase(String enfase) {
        this.enfase = enfase;
    }

    public String getNeutro() {
        return neutro;
    }

    public void setNeutro(String neutro) {
        this.neutro = neutro;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getNao() {
        return nao;
    }

    public void setNao(String nao) {
        this.nao = nao;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }

    public DialogCallback getCallback() {
        return callback;
    }

    public void setCallback(DialogCallback callback) {
        this.callback = callback;
    }

    public DialogClickCallback getNeutroClick() {
        return neutroClick;
    }

    public void setNeutroClick(DialogClickCallback neutroClick) {
        this.neutroClick = neutroClick;
    }

    public DialogClickCallback getSimClick() {
        return simClick;
    }

    public void setSimClick(DialogClickCallback simClick) {
        this.simClick = simClick;
    }

    public DialogClickCallback getNaoClick() {
        return naoClick;
    }

    public void setNaoClick(DialogClickCallback naoClick) {
        this.naoClick = naoClick;
    }
}

