package com.example.heroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heroes.R;
import com.example.heroes.model.Hero;

import java.util.List;

public class AdapterHeroes extends RecyclerView.Adapter<AdapterHeroes.MyViewHolder> {

    private List<Hero> listHeroes;

    public AdapterHeroes(List<Hero> list) {
        this.listHeroes = list;
    }

    //Innerclass que contém as informações das células da lista
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, owner;
        ImageView img;

        public MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.textViewName);
            owner = view.findViewById(R.id.textViewOwner);
            img = view.findViewById(R.id.imageViewHero);
        }
    }

    //Métodos que precisam ser implementados para este tipo de adapter
    @NonNull
    @Override
    // Cria a lista em tempo real, retornando célula a célula
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_heroes, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    //Mostra os componentes de uma célula
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Hero obj = listHeroes.get(position);
        holder.name.setText(obj.getName());
        holder.owner.setText(obj.getOwner());
        holder.img.setImageResource(obj.getImg());
    }

    @Override
    //Informa o tamanho da lista
    public int getItemCount() {
        return listHeroes.size();
    }
    //Fim dos métodos que precisam ser implementados

}
