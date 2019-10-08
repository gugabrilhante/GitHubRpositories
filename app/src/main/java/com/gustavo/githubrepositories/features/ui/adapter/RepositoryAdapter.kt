package com.gustavo.githubrepositories.features.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gustavo.githubrepositories.entity.Repository

class RepositoryAdapter : RecyclerView.Adapter<RepositoryViewHolder>() {

    var list: List<Repository> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepositoryViewHolder(parent)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(list[position])
    }
}