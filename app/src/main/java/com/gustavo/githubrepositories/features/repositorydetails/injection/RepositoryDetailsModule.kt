package com.gustavo.githubrepositories.features.repositorydetails.injection

import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.contracts.Iterators

interface RepositoryDetailsModule {
    val detailsDataSource: DataSources.DetailsDataSource
    val getRepositoryDetailsInteractor: Iterators.GetRepositoryDetail
}