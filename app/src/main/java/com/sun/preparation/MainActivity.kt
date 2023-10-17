package com.sun.preparation

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sun.preparation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the selectedAvatarNumber from the Intent
        val selectedAvatarNumber = intent.getStringExtra("selectedAvatarNumber").toString()
        val userName = intent.getStringExtra("userName").toString()
        // Perform actions based on selectedAvatarNumber
        when (selectedAvatarNumber) {
            "1" -> {
                // Handle avatar number 1
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar1)
            }
            "2" -> {
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar2)
            }
            "3" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar3)
            }
            "4" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar4)
            }
            "5" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar5)
            }
            "6" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar6)
            }
            "7" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar7)
            }
            "8" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar8)
            }
            "9" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar9)
            }
            "10" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar10)
            }
            "11" ->{
                // Handle avatar number 2
                // For example, update the UI or perform specific actions
                binding.profileImage.setImageResource(R.drawable.avatar11)
            }
            // Add more cases as needed
            else -> {
                // Handle cases where selectedAvatarNumber doesn't match any expected value
                // For example, show an error message or perform a default action
                binding.profileImage.setImageResource(R.drawable.ic_profile)
            }
        }
    }
}