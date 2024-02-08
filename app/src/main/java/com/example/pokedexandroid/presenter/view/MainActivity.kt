package com.example.pokedexandroid.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexandroid.R
import com.example.pokedexandroid.data.api.PokemonRepository
import com.example.pokedexandroid.domain.Pokemon
import com.example.pokedexandroid.domain.PokemonTypes
import com.example.pokedexandroid.presenter.viewModel.PokemonViewModel
import com.example.pokedexandroid.presenter.viewModel.PokemonViewModelFactory

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


        observers()
        actions()
    }

    private fun observers(){
        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
        val editText = findViewById<EditText>(R.id.edit_app_name)
        editText.addTextChangedListener {
            if(it.toString().isEmpty()){
                viewModel.fillPokemons()
            }
        }

    }

    private fun actions(){
        val btnFilter = findViewById<Button>(R.id.btn_app_filter)
        val editText = findViewById<EditText>(R.id.edit_app_name)
        btnFilter.setOnClickListener {
            viewModel.filterPokemons(editText.text.toString())
        }
    }

    private fun loadRecyclerView(pokemons: List<Pokemon>) {
        //Recyclerview configuração
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}