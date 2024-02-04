package com.example.pokedexandroid.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PokemonViewModelFactory  : ViewModelProvider.Factory {
    override fun <T:ViewModel> create(modelClass: Class<T>): T{
        return PokemonViewModel() as T
    }
}