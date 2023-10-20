package com.sun.preparation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sun.preparation.R
import com.sun.preparation.databinding.SlideLayoutBinding

class SlideFragment3 : Fragment() {
    private lateinit var binding : SlideLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = SlideLayoutBinding.inflate(layoutInflater)
        Glide.with(requireContext()).load(R.drawable.third).into(binding.slideImage)
        binding.slideTitle.setText("Free Book Library")
        binding.slideDescription.setText("Access Free Books to Expand Your Knowledge")
        return binding.root
    }
}