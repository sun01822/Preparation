package com.sun.preparation.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sun.preparation.MainActivity
import com.sun.preparation.R
import com.sun.preparation.adapter.AvatarAdapter
import com.sun.preparation.data.Avatar
import com.sun.preparation.databinding.ActivitySelectAvatarBinding

class SelectedAvatarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectAvatarBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AvatarAdapter
    private var selectedAvatarNumber: Int = -1 // Variable to store the selected avatar number
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var userName : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectAvatarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferences
        sharedPreferences = this.getSharedPreferences("UserData", Context.MODE_PRIVATE)
        userName = sharedPreferences.getString("userName", "User Name").toString()

        binding.nameTextView.text = userName + ", Please select an avatar"

        // Sample list of avatars (replace with your data)
        val avatars = listOf(
            Avatar(R.drawable.avatar1, 1),
            Avatar(R.drawable.avatar2, 2),
            Avatar(R.drawable.avatar3, 3),
            Avatar(R.drawable.avatar4, 4),
            Avatar(R.drawable.avatar5, 5),
            Avatar(R.drawable.avatar6, 6),
            Avatar(R.drawable.avatar7, 7),
            Avatar(R.drawable.avatar8, 8),
            Avatar(R.drawable.avatar9, 9),
            Avatar(R.drawable.avatar10, 10),
            Avatar(R.drawable.avatar11, 11),
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
                /*println("Selected Avatar Number: $selectedAvatarNumber")*/
                sharedPreferences.edit().putString("selectedAvatarNumber", selectedAvatarNumber.toString()).apply()
                // Create an Intent to start the MainActivity and pass the selectedAvatarNumber
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Finish the current activity (SelectedAvatarActivity) if needed
                finish()
            } else {
                // Handle the case when no avatar is selected (show an error message, etc.)
            }
        }

        // Initialize RecyclerView with GridLayoutManager to show 3 avatars per row
        binding.recyclerViewAvatars.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter

    }
}
