package com.example.myothercatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<PokemonData> data = new ArrayList<>();
        data.add(new PokemonData("Bulbasaur","https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"));
        data.add(new PokemonData("Ivysaur","https://assets.pokemon.com/assets/cms2/img/pokedex/full/002.png"));
        PokemonRecyclerViewAdapter adapter = new PokemonRecyclerViewAdapter(data,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}