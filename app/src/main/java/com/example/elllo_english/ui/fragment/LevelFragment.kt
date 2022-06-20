package com.example.elllo_english.ui.fragment

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elllo_english.R
import com.example.elllo_english.ui.adapter.LevelAdapter
import com.example.elllo_english.utils.AppLogger
import com.example.elllo_english.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_level.*
import kotlinx.android.synthetic.main.fragment_level.view.*
import kotlinx.android.synthetic.main.item_level.*

class LevelFragment : Fragment() {
    private lateinit var viewModel: ViewModel
    private lateinit var recycleView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_level, container, false)
        recycleView = view.level_recycleview
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AppLogger.info("RecycleView")
        val adapter = LevelAdapter()
        recycleView.adapter = adapter
        recycleView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        AppLogger.info("ViewModel get all level")
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getALlLevel.observe(viewLifecycleOwner, Observer { level ->
            adapter.setListLevel(level)
        })
    }
}