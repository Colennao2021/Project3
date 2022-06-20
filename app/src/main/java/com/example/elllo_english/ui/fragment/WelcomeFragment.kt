package com.example.elllo_english.ui.fragment

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.elllo_english.R

class WelcomeFragment : Fragment() {
    private lateinit var next: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_welcome, container, false)
        next = view.findViewById(R.id.next)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToLevelFragment()
            findNavController().navigate(action)
        }

    }
}