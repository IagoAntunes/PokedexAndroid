package com.example.pokedexandroid.domain

data class Pokemon(
    val number:Int? = null,
    val name:String,
    val types: List<PokemonTypes>,
){
    val formattedName = name.capitalize()
    val formattedNumber = number.toString().padStart(3,'0')

    val url = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"

}

