package com.sun.preparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.preparation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Retrieve the name from the Intent's extra
        val name = intent.getStringExtra("name")

        // Check if the name is not null and set it in a TextView
        if (!name.isNullOrEmpty()) {
            binding.textViewWelcome.text = "Welcome, $name!"
        }
    }
}