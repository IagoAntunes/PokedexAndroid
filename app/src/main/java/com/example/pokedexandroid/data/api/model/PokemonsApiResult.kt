package com.example.pokedexandroid.data.api.model

import com.example.pokedexandroid.domain.Pokemon
import com.example.pokedexandroid.domain.PokemonTypes

data class PokemonsApiResult(
    val count:Int,
    val previous:String?,
    val next:String?,
    val results: List<PokemonResult>
)

//Lista de pokemons
data class PokemonResult(
    val name:String,
    val url: String
)

//Individual
data class PokemonApiResult(
    val id:Int,
    val name:String,
    val types: List<PokemonTypeSlot>
)

data class PokemonTypeSlot(
    val slot:Int,
    val type:PokemonTypes
)