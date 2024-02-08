package com.example.pokedexandroid.presenter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedexandroid.data.api.PokemonRepository
import com.example.pokedexandroid.domain.Pokemon

class PokemonViewModel : ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon>>()
    var allPokemons: List<Pokemon> = mutableListOf()

    init {
        Thread(Runnable {
            loadPokemons()
            pokemons.value?.let {
                allPokemons = it
            }
        }).start()
    }

    fun fillPokemons(){
        pokemons.value = allPokemons
    }
    fun filterPokemons(text: String) {
        if(allPokemons.isEmpty()){
            allPokemons = pokemons.value!!
        }
        var auxList: MutableList<Pokemon> = mutableListOf()
        for (item in allPokemons) {
            if (item.name.contains(text) || item.number.toString().contains(text)) {
                auxList.add(item)
            }
        }
        pokemons.value = auxList
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()
        pokemonsApiResult?.results?.let {
            pokemons.postValue(it.map { pokemonResult ->
                val number =
                    pokemonResult.url.replace("https://pokeapi.co/api/v2/pokemon/", "")
                        .replace("/", "")
                val pokemonApiResult = PokemonRepository.getPokemons(number.toInt())
                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->
                            type.type
                        }
                    )
                }!!
            })
        }
    }
}