package com.alura.checkcontact.ui.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alura.checkcontact.R;
import com.alura.checkcontact.repository.FirebaseAuthRepository;

public class LoginActivity extends Activity {
    private TextView campoCadastro;
    private EditText campoUsuario;
    private EditText campoSenha;
    private Button button;
    private FirebaseAuthRepository firebaseAuthRepository = new FirebaseAuthRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializacaoDosCampos();
        configuraBotaoLogin();
        configuraAcaoCadastro();
    }

    private void configuraBotaoLogin() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateCampos();
            }
        });
    }

    private void validateCampos() {
        String usuario = campoUsuario.getText().toString();
        String senha = campoSenha.getText().toString();

        if (usuario.trim().isEmpty()) {
            campoUsuario.setError("É necessário informar o usuário.");
            campoUsuario.requestFocus();
        } else if (senha.trim().isEmpty()) {
            campoSenha.setError("É necessário informar a senha.");
            campoSenha.requestFocus();
        } else {
            firebaseAuthRepository.autenticaUser(LoginActivity.this, usuario, senha);
        }
    }

    private void configuraAcaoCadastro() {
        campoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, FormularioUsuarioActivity.class));
            }
        });
    }

    private void inicializacaoDosCampos() {
        campoCadastro = findViewById(R.id.activity_login_cadastrar);
        campoUsuario = findViewById(R.id.activity_login_usuario);
        campoSenha = findViewById(R.id.activity_login_senha);
        button = findViewById(R.id.activity_login_botao_login);
    }
}