package com.sun.preparation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sun.preparation.R
import com.sun.preparation.adapter.SlideAdapter
import com.sun.preparation.fragments.SlideFragment1
import com.sun.preparation.fragments.SlideFragment2
import com.sun.preparation.fragments.SlideFragment3

class SlideActivity : AppCompatActivity() {
    private val fragmentList = listOf(SlideFragment1(), SlideFragment2(), SlideFragment3())
    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnSkip = findViewById<Button>(R.id.btnSkip)

        val adapter = SlideAdapter(fragmentList, this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPosition = position
                updateButtonVisibility()
            }
        })

        btnNext.setOnClickListener {
            if (currentPosition < fragmentList.size - 1) {
                viewPager.setCurrentItem(++currentPosition, true)
            }
        }

        btnSkip.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        updateButtonVisibility()
    }

    private fun updateButtonVisibility() {
        val btnNext = findViewById<Button>(R.id.btnNext)
        if (currentPosition == fragmentList.size - 1) {
            btnNext.visibility = View.INVISIBLE
        } else {
            btnNext.visibility = View.VISIBLE
        }
    }
}
