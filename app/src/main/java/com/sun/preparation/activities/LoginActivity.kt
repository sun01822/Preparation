package com.sun.preparation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.sun.preparation.MainActivity
import com.sun.preparation.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            // Get the name from the EditText
            val userName = binding.editTextName.text.toString()

            // Create an Intent to start MainActivity
            if(userName.isNotEmpty()){
                val intent = Intent(this, SelectedAvatarActivity::class.java)
                // Put the name as an extra in the Intent
                intent.putExtra("userName", userName)
                // Start MainActivity with the Intent
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Enter your name please!!!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSkip.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}