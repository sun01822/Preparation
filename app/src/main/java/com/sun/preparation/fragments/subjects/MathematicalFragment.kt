package com.sun.preparation.fragments.subjects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sun.preparation.databinding.FragmentMathematicalBinding

class MathematicalFragment : Fragment() {
    private lateinit var binding : FragmentMathematicalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMathematicalBinding.inflate(layoutInflater)
        return binding.root
    }
}