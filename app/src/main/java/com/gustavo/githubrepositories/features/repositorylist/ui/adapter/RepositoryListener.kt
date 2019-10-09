package com.gustavo.githubrepositories.features.repositorylist.ui.adapter

import com.gustavo.githubrepositories.entity.Repository

interface RepositoryListener {
    fun onClick(repository: Repository)
}