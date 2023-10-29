package com.sun.preparation.fragments.subjects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sun.preparation.databinding.FragmentEnvironmentBinding

class EnvironmentFragment : Fragment() {
    private lateinit var binding: FragmentEnvironmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEnvironmentBinding.inflate(layoutInflater)
        return binding.root
    }
}