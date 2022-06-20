package com.example.elllo_english.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elllo_english.R
import com.example.elllo_english.data.Repository
import com.example.elllo_english.data.models.Grammar
import com.example.elllo_english.ui.adapter.GrammarAdapter
import com.example.elllo_english.utils.AppLogger
import com.example.elllo_english.viewmodel.ViewModel

class GrammarFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_grammar, container, false)
        recyclerView = view.findViewById(R.id.grammar_recycleview)
        return view
    }

    companion object {
        var courseId = 0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AppLogger.info("Recycleview")
        val adapter = GrammarAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        AppLogger.info("ViewModel get grammar")
        Repository.CourseId = courseId
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getGrammar.observe(viewLifecycleOwner, Observer { grammars ->
            if (grammars.size > 0) {
                adapter.setListGrammar(grammars)
            } else {
                AppLogger.info("Default grammar if null")
                val listDefault: List<Grammar> = listOf(Grammar(0, 0, "Loading", "", ""))
                adapter.setListGrammar(listDefault)
            }

        })
    }
}