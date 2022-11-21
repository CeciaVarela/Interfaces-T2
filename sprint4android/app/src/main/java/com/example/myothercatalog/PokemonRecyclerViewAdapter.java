package com.example.myothercatalog;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PokemonRecyclerViewAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private List<PokemonData> allTheData;
    private Activity activity;

    public PokemonRecyclerViewAdapter(List<PokemonData> dataset, Activity activity){
        this.allTheData = dataset;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_view_holder, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        PokemonData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {
        return allTheData.size();
    }
}