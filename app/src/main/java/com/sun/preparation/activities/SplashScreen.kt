package com.sun.preparation.activities

import android.annotation.SuppressLint
import android.content.Intent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.brain).into(binding.imageView)
        delayTimer()
    }
    private fun delayTimer() {
        Handler(Looper.getMainLooper()).postDelayed({
            goToNext()
        },3500)
    }
    private fun goToNext() {
        val intent = Intent(this, SlideActivity::class.java)
        startActivity(intent)
        finish()
    }
}