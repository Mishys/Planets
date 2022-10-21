package com.example.planets.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.planets.ListPlanetsActivy
import com.example.planets.R

import com.example.planets.databinding.ActivityPlanetDetailBinding
import com.example.planets.ui.model.Planets

class PlanetDetailActivity: AppCompatActivity() {

    private lateinit var obj: Planets
    private val binding by lazy {
        ActivityPlanetDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        obj = intent.getParcelableExtra<Planets>("Planets")!!
        setPlanet(obj)
        hideNavigation()
        settingButton()
    }


    private fun settingButton() {
        val button = binding.buttonBackPlanetDetail
        val intent = Intent(this, ListPlanetsActivy::class.java)
        button.setOnClickListener{
            startActivity(intent)
            finish()
        }
    }


    fun setPlanet(planets: Planets){
        this.obj = planets

        val title = binding.planetDetailTitle
        title.text = planets.name

        val subtitle = binding.planetDetailSubtitle
        subtitle.text = planets.galaxy

        val distance = binding.planetDetailDistance
        distance.text = planets.distance  + "mi km"

        val gravity = binding.planetDetailGravity
        gravity.text = planets.gravity + " m/ss"

        val description = binding.planetDetailDescription
        description.text = planets.description

        val imagePlanet = binding.planetDetailPlanetImg
        val imagePlanetBackground = binding.planetDetailImg

        setImagePlanets(title, imagePlanet, imagePlanetBackground)

    }

    fun setImagePlanets(
        title: TextView,
        imagePlanet: ImageView,
        imagePlanetBackground: ImageView?
    ) {
        if (title.text == getString(R.string.mercury)) {
            imagePlanet.setImageResource(R.drawable.moon)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.mercury_detail)
            }
        }

        if (title.text == getString(R.string.Venus)) {
            imagePlanet.setImageResource(R.drawable.venus)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.venus_detail)
            }
        }

        if (title.text == getString(R.string.earth)) {
            imagePlanet.setImageResource(R.drawable.earth)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.earth_detail)
            }
        }

        if (title.text == getString(R.string.Mars)) {
            imagePlanet.setImageResource(R.drawable.mars)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.mars_detail)
            }
        }

        if (title.text == getString(R.string.Jupiter)) {
            imagePlanet.setImageResource(R.drawable.jupiter)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.jupiter_detail)
            }
        }
        if (title.text == getString(R.string.Saturn)) {
            imagePlanet.setImageResource(R.drawable.saturn)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.saturn_detail)
            }
        }
        if (title.text == getString(R.string.Uranus)) {
            imagePlanet.setImageResource(R.drawable.uranus)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.uranus_detail)
            }
        }
        if (title.text == getString(R.string.Neptun)) {
            imagePlanet.setImageResource(R.drawable.neptune)
            if (imagePlanetBackground != null) {
                imagePlanetBackground.setImageResource(R.drawable.neptune_detail)
            }
        }
    }
    fun hideNavigation() {
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}