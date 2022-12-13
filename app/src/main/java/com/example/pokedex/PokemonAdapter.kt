package com.example.pokedex

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PokemonAdapter(private val context: Context, private val list : List<PokemonModel>) : RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.nameView.text = list[position].name
        Picasso.get().load(list[position].sprite).into(holder.imgView)
    }

    override fun getItemCount(): Int {
        return list.size;
    }
}