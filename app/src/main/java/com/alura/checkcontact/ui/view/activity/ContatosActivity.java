package com.alura.checkcontact.ui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alura.checkcontact.R;
import com.alura.checkcontact.model.Teste;
import com.alura.checkcontact.repository.FirebaseAuthRepository;
import com.alura.checkcontact.ui.view.adapter.ListaContatosAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContatosActivity extends AppCompatActivity {
    private FirebaseAuthRepository firebaseAuthRepository = new FirebaseAuthRepository();
    private ListaContatosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        RecyclerView listaNotas = findViewById(R.id.lista_contatos_recyclerview);

        List<Teste> lista = new ArrayList<>(Arrays.asList(new Teste("Tio", "5546991356190")));

        adapter = new ListaContatosAdapter(this, lista);
        listaNotas.setAdapter(adapter);

        if(!firebaseAuthRepository.estaLogado()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        Button button = findViewById(R.id.botao_sair);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuthRepository.desloga();
                startActivity(new Intent(ContatosActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}