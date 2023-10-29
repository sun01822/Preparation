package com.sun.preparation.fragments.subjects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sun.preparation.R
import com.sun.preparation.databinding.FragmentEnglishBinding

class EnglishFragment : Fragment() {
    private lateinit var binding : FragmentEnglishBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEnglishBinding.inflate(layoutInflater)
        return binding.root
    }
}