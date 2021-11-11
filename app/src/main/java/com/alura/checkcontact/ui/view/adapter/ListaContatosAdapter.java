package com.alura.checkcontact.ui.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alura.checkcontact.R;
import com.alura.checkcontact.model.Teste;

import java.util.List;

public class ListaContatosAdapter extends RecyclerView.Adapter<ListaContatosAdapter.ContatoViewHolder> {
    private final Context context;
    private final List<Teste> lista;

    public ListaContatosAdapter(Context context, List<Teste> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ListaContatosAdapter.ContatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_contato, parent, false);
        return new ContatoViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(ListaContatosAdapter.ContatoViewHolder holder, int position) {
        Teste nota = lista.get(position);
        holder.vincula(nota);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ContatoViewHolder extends RecyclerView.ViewHolder {
        private final TextView titulo;
        private final TextView descricao;

        public ContatoViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.item_contato_nome);
            descricao = itemView.findViewById(R.id.item_contato_numero);
        }

        public void vincula(Teste nota){
            preencheCampo(nota);
        }

        private void preencheCampo(Teste teste) {
            titulo.setText(teste.getTitulo());
            descricao.setText(teste.getDescricao());
        }
    }
}
