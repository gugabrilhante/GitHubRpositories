package com.gustavo.githubrepositories.features.repositorylist.injection

import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.contracts.Routers

interface RepositoryListModule {
    val repositoryListDataSource: DataSources.RepositoriesDataSource
    val getRepositoryList: Iterators.GetRepositoriesList
    val repositoryListRouter: Routers.RepositoryListRouter
}