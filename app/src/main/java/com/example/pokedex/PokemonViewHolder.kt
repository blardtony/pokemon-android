package com.example.pokedex

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonViewHolder(itemView: View, val nameView: TextView = itemView.findViewById(R.id.namePokemon), val imgView : ImageView = itemView.findViewById(R.id.pokemonImg)) : RecyclerView.ViewHolder(itemView) {

}