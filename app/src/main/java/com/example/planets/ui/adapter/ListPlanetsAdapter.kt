package com.example.planets.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planets.databinding.ActivityPlanetCardBinding
import com.example.planets.ui.activity.PlanetDetailActivity
import com.example.planets.ui.model.Planets
import com.example.planets.ui.model.setDataPlanets

class ListPlanetsAdapter(
    private val context: Context,
    planets: List<Planets> = setDataPlanets.setPlanets()

): RecyclerView.Adapter<ListPlanetsAdapter.ViewHolder>() {

    private val planets = planets.toMutableList()

    inner class ViewHolder(private val binding: ActivityPlanetCardBinding):RecyclerView.ViewHolder(binding.root) {

        private lateinit var planets: Planets

        fun vincula(planets: Planets) {

            this.planets = planets

            val name = binding.planetCardTitle
            name.text = planets.name

            val galaxy = binding.planetCardSubtitle
            galaxy.text = planets.galaxy

            val distance = binding.planetCardTextDistance
            if (planets.id!! < 6){
                distance.text = planets.distance + "mi км"
            }else{
                distance.text = planets.distance + "bi км"
            }


            val gravity = binding.planetCardTextGravity
            gravity.text = planets.gravity + "м/сс"

            val image = binding.planetCardImage

            PlanetDetailActivity().setImagePlanets(
                title = name,
                imagePlanet = image,
                imagePlanetBackground = null
            )

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ActivityPlanetCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planets = planets[position]
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PlanetDetailActivity::class.java).apply {
                putExtra("Planets", planets)
            }

            holder.itemView.context.startActivity(intent)
        }
        holder.vincula(planets)

    }

    override fun getItemCount(): Int = planets.size

}