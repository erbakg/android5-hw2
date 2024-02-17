package com.example.android5_2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.example.android5_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        initNavControllerListener()
        initClickers()
    }

    private fun initClickers() {
        binding.btnHistory.setOnClickListener {
            findNavController(
                this, R.id.nav_host_fragment_activity_main
            ).navigate(R.id.action_navigation_home_to_navigation_history)
        }
        binding.btnHome.setOnClickListener {
            findNavController(
                this, R.id.nav_host_fragment_activity_main
            ).navigate(R.id.action_navigation_history_to_navigation_home)
        }
    }

    private fun initNavControllerListener() {
        val navController = findNavController(this, R.id.nav_host_fragment_activity_main)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.navigation_home) { // change the fragment id
                binding.ivHome.setImageResource(R.drawable.ic_home_clicked)
                binding.tvHome.setTextColor(resources.getColor(R.color.nav_text_clicked))
                binding.ivHistory.setImageResource(R.drawable.ic_history)
                binding.tvHistory.setTextColor(resources.getColor(R.color.black))
                binding.btnHome.isEnabled = false
                binding.btnHistory.isEnabled = true
            }
            if (destination.id == R.id.navigation_history) { // change the fragment id
                binding.ivHistory.setImageResource(R.drawable.ic_history_clicked)
                binding.tvHistory.setTextColor(resources.getColor(R.color.nav_text_clicked))
                binding.ivHome.setImageResource(R.drawable.ic_home)
                binding.tvHome.setTextColor(resources.getColor(R.color.black))
                binding.btnHistory.isEnabled = false
                binding.btnHome.isEnabled = true
            }
        }
    }
}