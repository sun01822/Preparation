package com.sun.preparation.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.sun.preparation.MainActivity
import com.sun.preparation.R
import com.sun.preparation.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var isLoggedIn : Boolean = false
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check the user Logged In or not
        sharedPreferences = this.getSharedPreferences("UserData", Context.MODE_PRIVATE)
        isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        Glide.with(this).load(R.drawable.brain).into(binding.imageView)
        delayTimer()
    }
    private fun delayTimer() {
        Handler(Looper.getMainLooper()).postDelayed({
            goToNext()
        },3500)
    }
    private fun goToNext() {
        if(isLoggedIn){
            intent = Intent(this, MainActivity::class.java)
        }
        else{
            intent = Intent(this, SlideActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}