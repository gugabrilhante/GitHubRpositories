package com.gustavo.githubrepositories.features.repositorylist.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.githubrepositories.R
import com.gustavo.githubrepositories.common.extensions.inflate
import com.gustavo.githubrepositories.common.extensions.setInVisible
import com.gustavo.githubrepositories.common.extensions.setVisible
import com.gustavo.githubrepositories.entity.Repository
import kotlinx.android.synthetic.main.item_repository.view.*
import org.jetbrains.anko.sdk27.listeners.onClick

class RepositoryViewHolder(parent: ViewGroup,private val listener: RepositoryListener?) :
    RecyclerView.ViewHolder(parent.inflate(R.layout.item_repository)) {

    fun bind(repository: Repository) {
        itemView.repositoryNameTextView.text = repository.name
        itemView.descriptionTextView.text = repository.description ?: ""
        itemView.userNameTextView.text = repository.owner.login
        Glide.with(itemView.context).load(repository.owner.avatar_url)
            .into(itemView.userNameImageView)

        if (repository.isFork) itemView.forkImageView.setVisible()
        else itemView.forkImageView.setInVisible()

        itemView.onClick {
            listener?.onClick(repository)
        }
    }

}