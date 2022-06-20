package com.example.elllo_english.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elllo_english.R
import com.example.elllo_english.data.models.Course
import com.example.elllo_english.data.models.Script

class ScriptAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var scripts: List<Script> = emptyList()

    fun setListScript(tmp: List<Script>) {
        this.scripts = tmp
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_script, parent, false)
        return ScriptViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ScriptViewHolder) {
            val script = scripts.get(position)
            holder.bindingData(script)
        }
    }

    override fun getItemCount(): Int {
        return scripts.size
    }

    class ScriptViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name_script)
        private val content: TextView = itemView.findViewById(R.id.content_script)

        fun bindingData(script: Script) {
            name.text = script.name
            content.text = script.content
        }
    }
}