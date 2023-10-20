package com.sun.preparation.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.sun.preparation.MainActivity
import com.sun.preparation.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // sharedPreferences
        sharedPreferences = this.getSharedPreferences("UserData", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            // Get the name from the EditText
            val userName = binding.editTextName.text.toString()

            // Create an Intent to start MainActivity
            if(userName.isNotEmpty()){
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
                sharedPreferences.edit().putString("userName", userName).apply()
                val intent = Intent(this, SelectedAvatarActivity::class.java)
                // Start MainActivity with the Intent
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this@LoginActivity, "Enter your name please!!!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSkip.setOnClickListener{
            sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}