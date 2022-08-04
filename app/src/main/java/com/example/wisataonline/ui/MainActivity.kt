package com.example.wisataonline.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.wisataonline.R
import com.example.wisataonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppBarConfiguration(
            setOf(
                R.id.catFragment,
                R.id.dogFragment
            )
        )

        binding.bottomNav.setupWithNavController(
            findNavController(R.id.nav_host_fragment_activity_main)
        )
    }
}