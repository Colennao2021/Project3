package com.example.elllo_english.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elllo_english.R
import com.example.elllo_english.data.Repository
import com.example.elllo_english.data.models.Course
import com.example.elllo_english.data.models.Level
import com.example.elllo_english.ui.adapter.CourseAdapter
import com.example.elllo_english.utils.AppLogger
import com.example.elllo_english.viewmodel.ViewModel

class CourseFragment : Fragment() {
    private lateinit var viewModel: ViewModel
    private lateinit var recycleView: RecyclerView

    private val args: CourseFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_course, container, false)
        recycleView = view.findViewById(R.id.course_recycleview)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AppLogger.info("Recycleview")
        val adapter = CourseAdapter()
        recycleView.adapter = adapter
        recycleView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        AppLogger.info("ViewModel")
        Repository.levelId = args.level.id
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getCourse.observe(viewLifecycleOwner, Observer { courses ->
            if (courses.size > 0) {
                adapter.setListCourse(courses)
            } else {
                val courseDefault: List<Course> = listOf(Course(0, 0, "Updating course", "", 0))
                adapter.setListCourse(courseDefault)
            }
        })

    }
}