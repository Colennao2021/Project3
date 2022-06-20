package com.example.elllo_english.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.elllo_english.ui.fragment.GrammarFragment
import com.example.elllo_english.ui.fragment.ScriptFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ScriptFragment()
            1 -> return GrammarFragment()
            else -> return ScriptFragment()
        }
    }
}