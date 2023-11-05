package com.sun.preparation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sun.preparation.databinding.ActivityMainBinding
import com.sun.preparation.fragments.BooksFragment
import com.sun.preparation.fragments.CategoriesFragment
import com.sun.preparation.fragments.HomeFragment
import com.sun.preparation.fragments.QuizFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("userName", "username").toString()
        val selectedAvatarNumber = sharedPreferences.getString("selectedAvatarNumber", "-1").toString()

        binding.userName.text = userName.lowercase()

        val avatarResource = when (selectedAvatarNumber) {
            "1" -> R.drawable.avatar1
            "2" -> R.drawable.avatar2
            "3" -> R.drawable.avatar3
            "4" -> R.drawable.avatar4
            "5" -> R.drawable.avatar5
            "6" -> R.drawable.avatar6
            "7" -> R.drawable.avatar7
            "8" -> R.drawable.avatar8
            "9" -> R.drawable.avatar9
            "10" -> R.drawable.avatar10
            "11" -> R.drawable.avatar11
            else -> R.drawable.ic_profile
        }
        binding.profileImage.setImageResource(avatarResource)

        setFragment(HomeFragment())

        binding.bottomNavigationBar.setOnItemSelectedListener {
            val selectedFragment = when (it.itemId) {
                R.id.nav_categories -> CategoriesFragment()
                R.id.nav_books -> BooksFragment()
                R.id.nav_quiz -> QuizFragment()
                else -> HomeFragment()
            }
            setFragment(selectedFragment)
            true
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}
