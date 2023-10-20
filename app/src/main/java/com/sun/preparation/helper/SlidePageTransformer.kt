package com.sun.preparation.helper

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class SlidePageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        // Slide animation
        page.translationX = -position * page.width
        page.alpha = 1 - Math.abs(position)
    }
}
