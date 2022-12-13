package com.example.pokedex

data class PokemonModel(
    val id : Int? = null,
    val name : String? = null,
    val sprite : String? = null,
    val types : List<TypeModel>? = null
)
