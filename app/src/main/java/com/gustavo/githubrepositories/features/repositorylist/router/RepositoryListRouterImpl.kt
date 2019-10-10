package com.gustavo.githubrepositories.features.repositorylist.router

import android.content.Context
import android.content.Intent
import com.gustavo.githubrepositories.contracts.Routers
import com.gustavo.githubrepositories.entity.Repository
import com.gustavo.githubrepositories.features.repositorydetails.ui.RepositoryDetailsActivity
import com.gustavo.githubrepositories.features.repositorydetails.ui.RepositoryDetailsActivity.Companion.REPOSITORY_KEY

class RepositoryListRouterImpl(private val context: Context) : Routers.RepositoryListRouter {
    override fun goToRepositoryDetail(repository: Repository) {
        val intent = Intent(context, RepositoryDetailsActivity::class.java)
        intent.putExtra(REPOSITORY_KEY, repository)
        context.startActivity(intent)
    }
}