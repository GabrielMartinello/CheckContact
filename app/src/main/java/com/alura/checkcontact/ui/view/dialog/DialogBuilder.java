package com.alura.checkcontact.ui.view.dialog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.alura.checkcontact.callback.DialogCallback;
import com.alura.checkcontact.callback.DialogClickCallback;
import com.alura.checkcontact.ui.components.DialogArgs;
import com.alura.checkcontact.utils.DialogUtil;

public class DialogBuilder{
    private DialogArgs args;
    private DialogFragment dialogFragment;

    public DialogBuilder(@NonNull String titulo, @NonNull String conteudo) {
        args = new DialogArgs();
        args.setTitulo(titulo);
        args.setConteudo(conteudo);
    }


    public DialogBuilder(@NonNull String titulo, @NonNull CharSequence conteudo) {
        args = new DialogArgs();
        args.setTitulo(titulo);
        args.setConteudoChar(conteudo);
    }

    public DialogBuilder enfase(String txtEnfase) {
        args.setEnfase(txtEnfase);
        return this;
    }

    public DialogBuilder cancelable(boolean cancelable){
        args.setCancelable(cancelable);
        return this;
    }

    public DialogBuilder neutroButton(@NonNull String texto, DialogClickCallback onClik){
        args.setNeutro(texto);
        args.setNeutroClick(onClik);
        return this;
    }

    public DialogBuilder naoSimButton(@NonNull String txtNao, DialogClickCallback naoOnClick, @NonNull String txtSim, @NonNull DialogClickCallback simOnClick){
        args.setNao(txtNao);
        args.setNaoClick(naoOnClick);
        args.setSim(txtSim);
        args.setSimClick(simOnClick);
        return this;
    }

    public DialogBuilder dialogCallback(@NonNull DialogCallback callback){
        args.setCallback(callback);
        return this;
    }


    public void show(FragmentManager fragmentManager, String tag) {
        dialogFragment = new DialogUtil();
        Bundle params = new Bundle();
        params.putSerializable("args", args);
        dialogFragment.setArguments(params);
        dialogFragment.show(fragmentManager, tag);
    }


}
