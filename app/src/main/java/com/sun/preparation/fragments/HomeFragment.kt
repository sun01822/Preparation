package com.sun.preparation.fragments

import SubjectAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.sun.preparation.R
import com.sun.preparation.data.Subject
import com.sun.preparation.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    // Declare the binding variable
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using view binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding?.root

        Glide.with(requireContext()).load(R.drawable.hi).into(binding!!.hiImageView)

        val subjects = generateSampleSubjects() // Create a list of sample subjects

        // Use view binding to get a reference to the RecyclerView
        // Setting the layout as Staggered Grid for vertical orientation
        // Setting the layout as Staggered Grid for vertical orientation
        val subjectRecyclerView = binding?.subjectRecyclerView
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        subjectRecyclerView?.layoutManager = staggeredGridLayoutManager
        subjectRecyclerView?.adapter = SubjectAdapter(subjects)

        return rootView
    }

    private fun generateSampleSubjects(): List<Subject> {
        val subjects = ArrayList<Subject>()
        subjects.add(Subject(1, "Math", R.drawable.ic_profile, 20.0))
        subjects.add(Subject(2, "Political Science", R.drawable.ic_profile,  40.0))
        subjects.add(Subject(3, "History", R.drawable.ic_profile, 80.0))
        subjects.add(Subject(3, "History", R.drawable.ic_profile, 80.0))
        subjects.add(Subject(2, "Political Science", R.drawable.ic_profile,  40.0))
        subjects.add(Subject(3, "History", R.drawable.ic_profile, 80.0))
        subjects.add(Subject(1, "Math", R.drawable.ic_profile, 20.0))
        subjects.add(Subject(2, "Political Science", R.drawable.ic_profile,  40.0))
        subjects.add(Subject(2, "Political Science", R.drawable.ic_profile,  40.0))
        subjects.add(Subject(3, "History", R.drawable.ic_profile, 80.0))
        subjects.add(Subject(3, "History", R.drawable.ic_profile, 80.0))
        subjects.add(Subject(2, "Political Science", R.drawable.ic_profile,  40.0))
        subjects.add(Subject(3, "History", R.drawable.ic_profile, 80.0))
        // Add more subjects as needed
        return subjects
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding
        binding = null
    }
}
