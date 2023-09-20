package com.sun.preparation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sun.preparation.R
import com.sun.preparation.adapter.AvatarAdapter
import com.sun.preparation.data.Avatar
import com.sun.preparation.databinding.ActivitySelectAvatarBinding

class SelectedAvatarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectAvatarBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AvatarAdapter
    private var selectedAvatarNumber: Int = -1 // Variable to store the selected avatar number

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectAvatarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sample list of avatars (replace with your data)
        val avatars = listOf(
            Avatar(R.drawable.avatar1, 1),
            Avatar(R.drawable.avatar2, 2),
            Avatar(R.drawable.avatar3, 3),
            Avatar(R.drawable.avatar4, 4),
            // Add more avatars as needed
        )

        recyclerView = binding.recyclerViewAvatars
        adapter = AvatarAdapter(this, avatars) { position, item ->
            // Handle avatar item click here
            selectedAvatarNumber = item.avatarNumber
        }

        binding.btnConfirmSelection.setOnClickListener {
            if (selectedAvatarNumber != -1) {
                // Print the selected avatar number
                println("Selected Avatar Number: $selectedAvatarNumber")
            } else {
                // Handle the case when no avatar is selected (show an error message, etc.)
            }
        }

        // Initialize RecyclerView with GridLayoutManager to show 3 avatars per row
        binding.recyclerViewAvatars.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
    }
}
