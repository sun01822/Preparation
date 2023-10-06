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
        setContentView(R.layout.activity_main)

        // Retrieve the selectedAvatarNumber from the Intent
        val selectedAvatarNumber = intent.getIntExtra("selectedAvatarNumber", -1)

        // Check if the value is valid (-1 means no value was provided)
        if (selectedAvatarNumber != -1) {
            // Use the selectedAvatarNumber in your MainActivity as needed
            Log.d(TAG, "$selectedAvatarNumber")
            binding.numberId.text = selectedAvatarNumber.toString()
        } else {
            // Handle the case when no avatar number was provided
            println("No selected avatar number provided.")
        }
    }
}
