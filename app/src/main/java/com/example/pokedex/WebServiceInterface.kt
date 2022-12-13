package com.example.pokedex

import retrofit2.Call
import retrofit2.http.GET

interface WebServiceInterface {

    @GET("pokemons.json")
    fun getAllPokemon(): Call<List<PokemonModel>>
}