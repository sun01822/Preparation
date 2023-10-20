package com.sun.preparation.activities

import android.content.Intent
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sun.preparation.adapter.SlideAdapter
import com.sun.preparation.databinding.ActivitySlideBinding
import com.sun.preparation.fragments.SlideFragment1
import com.sun.preparation.fragments.SlideFragment2
import com.sun.preparation.fragments.SlideFragment3
import com.sun.preparation.helper.SlidePageTransformer

class SlideActivity : AppCompatActivity() {
    private val fragmentList = listOf(SlideFragment1(), SlideFragment2(), SlideFragment3())
    private var currentPosition = 0
    private val handler = Handler()
    private lateinit var runnable: Runnable
    private lateinit var binding : ActivitySlideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.setPageTransformer(SlidePageTransformer())
        val adapter = SlideAdapter(fragmentList, this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPosition = position
            }
        })

        binding.btnSkip.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Update slider every 5 seconds (adjust the delay as needed)
        val delayMillis = 5000 // 5 seconds
        runnable = object : Runnable {
            override fun run() {
                if (currentPosition < fragmentList.size - 1) {
                    binding.viewPager.setCurrentItem(++currentPosition, true)
                } else {
                    binding.viewPager.setCurrentItem(0, true)
                }
                handler.postDelayed(this, delayMillis.toLong())
            }
        }
        handler.postDelayed(runnable, delayMillis.toLong())
    }

    override fun onDestroy() {
        super.onDestroy()
        // Remove the callbacks to stop the timer when the activity is destroyed
        handler.removeCallbacks(runnable)
    }
}
