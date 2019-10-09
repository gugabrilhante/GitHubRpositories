package com.gustavo.githubrepositories.features.repositorydetails.injection

import android.os.Bundle
import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.datasource.api.RepositoriesServices
import com.gustavo.githubrepositories.datasource.providers.DetailsDataSourceImpl
import com.gustavo.githubrepositories.interactor.GetRepositoryDetailsInteractor

class RepositoryDetailsModuleImpl(private val bundle: Bundle):RepositoryDetailsModule {
    private val repositoriesServices : RepositoriesServices by lazy{
        RepositoriesServices()
    }

    override val getRepositoryDetailsInteractor: Iterators.GetRepositoryDetail by lazy {
        GetRepositoryDetailsInteractor(detailsDataSource)
    }
    override val detailsDataSource: DataSources.DetailsDataSource by lazy {
        DetailsDataSourceImpl(repositoriesServices, bundle)
    }
}