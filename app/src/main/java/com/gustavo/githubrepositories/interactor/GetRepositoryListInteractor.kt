package com.gustavo.githubrepositories.interactor

import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single

class GetRepositoryListInteractor(
    private val repositoryDataSource: DataSources.RepositoriesDataSource
): Iterators.GetRepositoriesList {
    override fun execute(): Single<List<Repository>> {
        return repositoryDataSource.getRepositoriesList()
    }
}