package com.gustavo.githubrepositories.features.repositorylist.injection

import android.content.Context
import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.contracts.Routers
import com.gustavo.githubrepositories.datasource.api.RepositoriesServices
import com.gustavo.githubrepositories.datasource.providers.RepositoriesDataSourceImpl
import com.gustavo.githubrepositories.features.repositorylist.router.RepositoryListRouterImpl
import com.gustavo.githubrepositories.interactor.GetRepositoryListInteractor

class RepositoryListModuleImpl(private val context: Context) : RepositoryListModule {
    private val repositoriesServices :RepositoriesServices by lazy{
        RepositoriesServices()
    }

    override val repositoryListDataSource: DataSources.RepositoriesDataSource by lazy {
        RepositoriesDataSourceImpl(repositoriesServices)
    }

    override val getRepositoryList: Iterators.GetRepositoriesList by lazy {
        GetRepositoryListInteractor(repositoryListDataSource)
    }
    override val repositoryListRouter: Routers.RepositoryListRouter by lazy {
        RepositoryListRouterImpl(context)
    }
}