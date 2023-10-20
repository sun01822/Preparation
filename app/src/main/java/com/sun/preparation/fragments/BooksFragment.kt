package com.sun.preparation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sun.preparation.R
import com.sun.preparation.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {
    private lateinit var binding : FragmentBooksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBooksBinding.inflate(layoutInflater)
        return binding.root
    }
}