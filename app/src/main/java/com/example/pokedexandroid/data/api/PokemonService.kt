package com.example.pokedexandroid.data.api

import com.example.pokedexandroid.data.api.model.PokemonApiResult
import com.example.pokedexandroid.data.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {


    @GET("pokemon")
    fun listPokemon(@Query("Limit") limit:Int): Call<PokemonsApiResult>


    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number:Int): Call<PokemonApiResult>

}