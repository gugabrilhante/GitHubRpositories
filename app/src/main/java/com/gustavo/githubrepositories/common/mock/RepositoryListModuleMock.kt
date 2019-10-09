package com.gustavo.githubrepositories.common.mock

import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.contracts.Routers
import com.gustavo.githubrepositories.features.repositorylist.injection.RepositoryListModule

class RepositoryListModuleMock:RepositoryListModule{
    override val repositoryListDataSource: DataSources.RepositoriesDataSource
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val getRepositoryList: Iterators.GetRepositoriesList
        get() = GetRepositoryListMock()

    override val repositoryListRouter: Routers.RepositoryListRouter
        get() = RepositoryListRouterMock()


}