package com.example.elllo_english.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elllo_english.R
import com.example.elllo_english.data.models.Grammar
import com.example.elllo_english.data.models.Script

class GrammarAdapter :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var grammars: List<Grammar> = emptyList()

    fun setListGrammar(tmp: List<Grammar>) {
        this.grammars = tmp
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_grammar, parent, false)
        return GrammarViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GrammarViewHolder) {
            val grammar = grammars.get(position)
            holder.bindingData(grammar)
        }
    }

    override fun getItemCount(): Int {
        return grammars.size
    }

    class GrammarViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val point: TextView = itemView.findViewById(R.id.point_grammar)
        private val title: TextView = itemView.findViewById(R.id.title_grammar)
        private val example: TextView = itemView.findViewById(R.id.example_grammar)

        fun bindingData(grammar: Grammar) {
            point.text = grammar.point
            title.text = grammar.title
            example.text=grammar.example
        }
    }
}