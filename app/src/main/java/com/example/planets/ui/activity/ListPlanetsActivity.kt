package com.example.planets.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.planets.databinding.ActivityListPlanetsBinding
import com.example.planets.ui.adapter.ListPlanetsAdapter

class ListPlanetsActivy: AppCompatActivity() {

    private val adapter = ListPlanetsAdapter(this)


    private val binding by lazy {
        ActivityListPlanetsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        setContentView(binding.root)
        hideNavigation()
        configuraRecyclerView()

    }

    override fun onStop() {
        super.onStop()
        finish()
    }

     fun hideNavigation() {
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }


    private fun configuraRecyclerView(){
        val recyclerView = binding.activityPlanetListRecyclerview
        recyclerView.adapter = adapter

    }

}