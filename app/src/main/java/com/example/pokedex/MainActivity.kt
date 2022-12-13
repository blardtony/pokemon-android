package com.example.pokedex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerPokemon)
        val baseUrl : String = "https://www.surleweb.xyz/api/"
        val jsonConverter = GsonConverterFactory.create(GsonBuilder().create())
        val retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(jsonConverter)
            .build()
        val service = retrofitClient.create(WebServiceInterface::class.java)

        val callback : Callback<List<PokemonModel>> = object : Callback<List<PokemonModel>> {
            override fun onResponse(
                call: Call<List<PokemonModel>>,
                response: Response<List<PokemonModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { newData ->
                        val randomPokemon = newData.asSequence().shuffled().take(6).toList()
                        val pokemonAdapter = PokemonAdapter(this@MainActivity, randomPokemon)
                        println(pokemonAdapter.itemCount)
                        recyclerView.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = pokemonAdapter
                        }
                    }
                }
                else {
                    Log.d("Response not successful", "")
                }
            }

            override fun onFailure(call: Call<List<PokemonModel>>, t: Throwable) {
                Log.d("xxx", "Webservice error : " + t.message)
            }

        }
//
        service.getAllPokemon().enqueue(callback)
    }
}