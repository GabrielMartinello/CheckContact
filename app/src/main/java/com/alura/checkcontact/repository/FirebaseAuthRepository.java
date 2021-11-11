package com.alura.checkcontact.repository;

import android.app.Activity;
import android.content.Intent;

import com.alura.checkcontact.ui.view.activity.ContatosActivity;
import com.alura.checkcontact.ui.view.dialog.DialogBuilder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAuthRepository {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public boolean estaLogado() {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            return true;
        }
        return false;

    }

    public void desloga() {
        firebaseAuth.signOut();
    }

    public void autenticaUser(Activity activity, String email, String senha) {
        firebaseAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                devolveErrosDeLogin(task, activity);
            }
        });
    }

    public void cadastra(Activity activity, String email, String senha) {
        Task<AuthResult> tarefa =
                firebaseAuth.createUserWithEmailAndPassword(
                        email, senha);
        tarefa.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                activity.finish();
            }
        });
        tarefa.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                devolveErrosDeCadastro(e, activity);
            }
        });
    }

    private void devolveErrosDeCadastro(Exception e, Activity activity) {
        String mensagem = "";
        if (e instanceof FirebaseAuthWeakPasswordException) {
            mensagem = "Senha precisa ter pelo menos 6 dígitos.";
        } else if (e instanceof FirebaseAuthInvalidCredentialsException) {
            mensagem = "E-mail inválido.";
        } else if (e instanceof FirebaseAuthUserCollisionException) {
            mensagem = "E-mail já cadastrado.";
        } else {
            mensagem = "Erro desconhecido.";
        }
        if (activity.getWindow().getDecorView().getRootView() != null) {
            Snackbar.make(activity.getWindow().getDecorView().getRootView(), mensagem, Snackbar.LENGTH_SHORT).show();
        }
    }

    private void devolveErrosDeLogin(Task<AuthResult> task, Activity activity) {
        String mensagem = "";
        if (task.isSuccessful()) {
            activity.startActivity(new Intent(activity.getWindow().getContext(), ContatosActivity.class));
        } else {
            if (task.getException() instanceof FirebaseAuthRecentLoginRequiredException) {
                mensagem = "Este usuário já fez login.";
            }
            if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                mensagem = "Este usuário não existe.";
            }
            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                mensagem = "Usuário ou senha incorretos.";
            } else {
                mensagem = "Erro desconhecido.";
            }
            new DialogBuilder("Login Inválido", mensagem)
                    .neutroButton("Ok", null)
                    .cancelable(true)
                    .show(activity.getFragmentManager(), "warning_auth");
        }
    }
}
