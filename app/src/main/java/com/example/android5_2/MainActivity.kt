package com.example.android5_2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.example.android5_2.data.Preferences
import com.example.android5_2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var pref: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        initNavControllerListener()
        initClickers()
    }

    private fun initClickers() {
        binding.llHistory.setOnClickListener {
            findNavController(
                this, R.id.nav_host_fragment_activity_main
            ).navigate(R.id.action_navigation_home_to_navigation_history)
        }
        binding.llHome.setOnClickListener {
            findNavController(
                this, R.id.nav_host_fragment_activity_main
            ).navigate(R.id.action_navigation_history_to_navigation_home)
        }
    }

    private fun initNavControllerListener() {
        var navController = findNavController(this, R.id.nav_host_fragment_activity_main)
        if (!pref.isOnboardingShown()) {
            navController.navigate(R.id.onboarding)
        }
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.navigation_home) { // change the fragment id
                binding.ivHomeIcon.setImageResource(R.drawable.ic_home_clicked)
                binding.tvHome.setTextColor(resources.getColor(R.color.nav_text_clicked))
                binding.ivHistory.setImageResource(R.drawable.ic_history)
                binding.tvHistory.setTextColor(resources.getColor(R.color.black))
                binding.llHome.isEnabled = false
                binding.llHistory.isEnabled = true
            }
            if (destination.id == R.id.navigation_history) { // change the fragment id
                binding.ivHistory.setImageResource(R.drawable.ic_history_clicked)
                binding.tvHistory.setTextColor(resources.getColor(R.color.nav_text_clicked))
                binding.ivHomeIcon.setImageResource(R.drawable.ic_home)
                binding.tvHome.setTextColor(resources.getColor(R.color.black))
                binding.llHistory.isEnabled = false
                binding.llHome.isEnabled = true
            }
            if (destination.id == R.id.onboarding || destination.id == R.id.resultFragment) {
                binding.llTabBar.visibility = View.GONE
            } else {
                binding.llTabBar.visibility = View.VISIBLE
            }

        }
    }
}