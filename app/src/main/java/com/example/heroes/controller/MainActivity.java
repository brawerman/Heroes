package com.example.heroes.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.heroes.R;
import com.example.heroes.RecyclerItemClickListener;
import com.example.heroes.adapter.AdapterHeroes;
import com.example.heroes.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHeroes;
    private List<Hero> listHeroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHeroes = findViewById(R.id.recyclerViewHeroes);

        //Configurar o Adapter
        this.createHero();
        AdapterHeroes adapter = new AdapterHeroes(listHeroes);

        //Configurar RecyclerView utilizando um layout linear
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerViewHeroes.setLayoutManager(layoutManager);
        //Otimizar o RecyclerView
        recyclerViewHeroes.setHasFixedSize(true);

        //Insere um divisor entre as células
        recyclerViewHeroes.addItemDecoration(
                new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //Liga o adapter ao recycler
        recyclerViewHeroes.setAdapter(adapter);

        //evento de clique
        recyclerViewHeroes.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerViewHeroes,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Hero obj = listHeroes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Selecionado " + obj.getName(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Clique longo",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );
    }

    public void createHero() {
        Hero obj = new Hero(R.drawable.flash, "Flash", "DC");
        listHeroes.add(obj);
        obj = new Hero(R.drawable.ironman, "Iron Man", "Marvel");
        listHeroes.add(obj);
    }
}