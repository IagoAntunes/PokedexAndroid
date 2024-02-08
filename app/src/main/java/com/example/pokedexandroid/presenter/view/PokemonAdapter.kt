package com.example.pokedexandroid.presenter.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexandroid.R
import com.example.pokedexandroid.domain.Pokemon
import com.example.pokedexandroid.utils.ColorsPokemon

class PokemonAdapter(
    private val items: List<Pokemon?>,
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun cardPokemonColor(pokemon:Pokemon) : String
        {
            val typeName = pokemon.types[0].name
            when (typeName) {
                ColorsPokemon.normal.first -> {
                    return ColorsPokemon.normal.second
                }
                ColorsPokemon.fire.first -> {
                    return ColorsPokemon.fire.second
                }
                ColorsPokemon.water.first -> {
                    return ColorsPokemon.water.second
                }
                ColorsPokemon.electric.first -> {
                    return ColorsPokemon.electric.second
                }
                ColorsPokemon.grass.first -> {
                    return ColorsPokemon.grass.second
                }
                ColorsPokemon.ice.first -> {
                    return ColorsPokemon.ice.second
                }
                ColorsPokemon.fighting.first -> {
                    return ColorsPokemon.fighting.second
                }
                ColorsPokemon.poison.first -> {
                    return ColorsPokemon.poison.second
                }
                ColorsPokemon.ground.first -> {
                    return ColorsPokemon.ground.second
                }
                ColorsPokemon.flying.first -> {
                    return ColorsPokemon.flying.second
                }
                ColorsPokemon.psychic.first -> {
                    return ColorsPokemon.psychic.second
                }
                ColorsPokemon.bug.first -> {
                    return ColorsPokemon.bug.second
                }
                ColorsPokemon.rock.first -> {
                    return ColorsPokemon.rock.second
                }
                ColorsPokemon.ghost.first -> {
                    return ColorsPokemon.ghost.second
                }
                ColorsPokemon.dragon.first -> {
                    return ColorsPokemon.dragon.second
                }
                ColorsPokemon.dark.first -> {
                    return ColorsPokemon.dark.second
                }
                ColorsPokemon.steel.first -> {
                    return ColorsPokemon.steel.second
                }
                ColorsPokemon.fairy.first -> {
                    return ColorsPokemon.fairy.second
                }
                else -> {
                    return "#212121" // Cor padrão para tipos de Pokémon desconhecidos
                }
            }

        }
        fun bindView(item: Pokemon?) = with(itemView) {
            val card = findViewById<CardView>(R.id.card_pokemon)

            card.setCardBackgroundColor(Color.parseColor(cardPokemonColor(item!!)))

            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvName = findViewById<TextView>(R.id.tvName)
            // tvType1 = findViewById<TextView>(R.id.tvType1)
            //val tvType2 = findViewById<TextView>(R.id.tvType2)

            //Pokemon item
            item?.let {
                //Carrega a imagem
                Glide.with(itemView.context).load(it.url).into(ivPokemon)

                tvNumber.text = "Nº ${item.formattedNumber}"
                tvName.text = item.name
                /*
                tvType1.text = item.types[0].name
                if (item.types.size > 1) {
                    tvType2.visibility = View.VISIBLE
                    tvType2.text = item.types[1].name
                } else {
                    tvType2.visibility = View.GONE
                }
                */

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Criando a view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }


}