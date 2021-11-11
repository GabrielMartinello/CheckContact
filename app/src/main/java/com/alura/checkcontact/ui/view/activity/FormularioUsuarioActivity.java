package com.alura.checkcontact.ui.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.checkcontact.R;
import com.alura.checkcontact.database.Database;
import com.alura.checkcontact.database.dao.UsuarioDAO;
import com.alura.checkcontact.model.Usuario;
import com.alura.checkcontact.repository.FirebaseAuthRepository;
import com.alura.checkcontact.ui.view.dialog.DialogBuilder;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FormularioUsuarioActivity extends AppCompatActivity {

    private Button botaoCadastro;
    private EditText campoUsuario;
    private EditText campoSenha;
    private FirebaseAuthRepository firebaseAuthRepository = new FirebaseAuthRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_usuario);
        inicializacaoDoCampos();
        configuraBotaoCadastro();
    }

    private void configuraBotaoCadastro() {
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        Boolean valido = true;
        preencheCampos();
        if (campoUsuario.getText().toString().trim().isEmpty()) {
            campoUsuario.setError(getString(R.string.mensagem_usuario_cadastro));
            campoUsuario.requestFocus();
            valido = false;
        }
        if (campoSenha.getText().toString().trim().isEmpty()) {
            campoSenha.setError(getString(R.string.mensagem_senha_cadastro));
            campoSenha.requestFocus();
            valido = false;
        }
        if(valido) {
            firebaseAuthRepository.cadastra(this,
                    campoUsuario.getText().toString(),
                    campoSenha.getText().toString());
        }
    }

    private void preencheCampos() {
        campoUsuario.getText().toString();
        campoSenha.getText().toString();
    }

    private void inicializacaoDoCampos() {
        campoUsuario = findViewById(R.id.activity_formulario_idUsuario);
        campoSenha = findViewById(R.id.activity_formulario_senha);
        botaoCadastro = findViewById(R.id.activity_formulario_botao_cadastrar);
    }
}