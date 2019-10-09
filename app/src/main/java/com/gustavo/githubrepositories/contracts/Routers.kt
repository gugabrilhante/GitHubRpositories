package com.gustavo.githubrepositories.contracts

import com.gustavo.githubrepositories.entity.Repository

interface Routers {
    interface RepositoryListRouter{
        fun goToRepositoryDetail(repository: Repository)
    }
}