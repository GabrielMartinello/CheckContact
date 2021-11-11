package com.alura.checkcontact.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alura.checkcontact.R;
import com.alura.checkcontact.callback.DialogCallback;
import com.alura.checkcontact.ui.components.DialogArgs;

public class DialogUtil extends DialogFragment {
    private DialogCallback callback;
    private DialogArgs argsParams;
    private TextView txtTitulo, txtConteudo, txtEnfase, btnNeutro, btnNao, btnSim;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /*setRetainInstance(true);
        setCancelable(false);*/
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = (View) inflater.inflate(R.layout.dialog_padrao_single, null);
        instanceComponents(view);
        Bundle args = getArguments();
        if (args != null) {
            argsParams = (DialogArgs) args.getSerializable("args");
            setCancelable(argsParams.isCancelable());
            setTituloConteudo();
            setEnfase();
            setNeutroButton();
            setSimNaoButton();
        }
        builder.setView(view);
        return builder.create();
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (argsParams.getCallback() != null) {
            argsParams.getCallback().onDismiss();
        }
    }

    private void instanceComponents(View view) {
        txtTitulo = view.findViewById(R.id.dialog_titulo);
        txtConteudo = view.findViewById(R.id.dialog_conteudo);
        txtEnfase = view.findViewById(R.id.dialog_enfase);
        btnNeutro = view.findViewById(R.id.dialog_btn_neutral);
        btnNao = view.findViewById(R.id.dialog_btn_nao);
        btnSim = view.findViewById(R.id.dialog_btn_sim);
    }

    private void setSimNaoButton() {
        if (argsParams.getNao() != null) {
            setNaoButton();
            setSimButton();
        }
    }

    private void setNaoButton() {
        btnNao.setText(argsParams.getNao());
        if (argsParams.getNaoClick() != null) {
            btnNao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    argsParams.getNaoClick().onClick();
                    dismiss();
                }
            });
        }else {
            btnNao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }

    private void setSimButton() {
        btnSim.setText(argsParams.getSim());
        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                argsParams.getSimClick().onClick();
                dismiss();
            }
        });
    }

    private void setNeutroButton() {
        if (argsParams.getNeutro() != null) {
            btnNeutro.setVisibility(View.VISIBLE);
            btnSim.setVisibility(View.GONE);
            btnNao.setVisibility(View.GONE);
            btnNeutro.setText(argsParams.getNeutro());
            if (argsParams.getNeutroClick() != null) {
                btnNeutro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        argsParams.getNeutroClick().onClick();
                        dismiss();
                    }
                });
            } else {
                btnNeutro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
            }
        }
    }

    private void setEnfase() {
        if (argsParams.getEnfase() != null) {
            txtEnfase.setVisibility(View.VISIBLE);
            txtEnfase.setText(argsParams.getEnfase());
        }
    }

    private void setTituloConteudo() {
        txtTitulo.setText(argsParams.getTitulo());
        if (argsParams.getConteudo() != null) {
            txtConteudo.setText(argsParams.getConteudo());
        } else {
            txtConteudo.setText(argsParams.getConteudoChar());
        }
    }
}

