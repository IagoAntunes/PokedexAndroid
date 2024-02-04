package com.example.pokedexandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexandroid.R
import com.example.pokedexandroid.api.PokemonRepository
import com.example.pokedexandroid.domain.Pokemon
import com.example.pokedexandroid.domain.PokemonTypes
import com.example.pokedexandroid.view.viewModel.PokemonViewModel
import com.example.pokedexandroid.view.viewModel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory()).get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })

    }

    private fun loadRecyclerView(pokemons: List<Pokemon>) {
        //Recyclerview configuração
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}