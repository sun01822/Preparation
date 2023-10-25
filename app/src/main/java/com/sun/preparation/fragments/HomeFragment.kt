package com.sun.preparation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.sun.preparation.R
import com.sun.preparation.adapter.SubjectAdapter
import com.sun.preparation.data.Subject
import com.sun.preparation.databinding.FragmentHomeBinding
import com.sun.preparation.fragments.subjects.EnglishFragment

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
        val subjectRecyclerView = binding?.subjectRecyclerView
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        subjectRecyclerView?.layoutManager = staggeredGridLayoutManager
        val subjectAdapter = SubjectAdapter(subjects)
        subjectRecyclerView?.adapter = subjectAdapter

        // Set the item click listener for the adapter
        subjectAdapter.setOnItemClickListener(object : SubjectAdapter.OnItemClickListener {
            override fun onItemClick(subject: Subject) {
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                val newFragment = when (subject.name) {
                    "English Language and Literature" -> EnglishFragment() // Open EnglishFragment for "English"
                    else -> HomeFragment() // Open YourNextFragment for other titles
                }

                transaction.replace(R.id.fragmentContainer, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        })


        return rootView
    }

    private fun generateSampleSubjects(): List<Subject> {
        val subjects = ArrayList<Subject>()
        subjects.add(Subject(1, "বাংলা ভাষা ও সাহিত্য", R.drawable.id1, 0.0))
        subjects.add(Subject(2, "English Language and Literature", R.drawable.id2, 0.0))
        subjects.add(Subject(3, "বাংলাদেশ বিষয়াবলি", R.drawable.id3, 0.0))
        subjects.add(Subject(4, "আন্তর্জাতিক বিষয়াবলি", R.drawable.id4, 0.0))
        subjects.add(Subject(5, "ভুগোল", R.drawable.id5, 0.0))
        subjects.add(Subject(6, "পরিবেশ ও দূর্যোগ ব্যবস্থাপনা", R.drawable.id6, 0.0))
        subjects.add(Subject(7, "সাধারণ বিজ্ঞান", R.drawable.id7, 0.0))
        subjects.add(Subject(8, "কম্পিউটার ও তথ্য প্রযুক্তি", R.drawable.id8, 0.0))
        subjects.add(Subject(9, "গাণিতিক যুক্তি", R.drawable.id9, 0.0))
        subjects.add(Subject(10, "মানসিক দক্ষতা", R.drawable.id10, 0.0))
        subjects.add(Subject(11, "নৈতিকতা, মূল্যবোধ ও সুশাসন", R.drawable.id11, 0.0))
        // Add more subjects as needed
        return subjects
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding
        binding = null
    }
}
