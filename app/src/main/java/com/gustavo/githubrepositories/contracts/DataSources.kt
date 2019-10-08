package com.gustavo.githubrepositories.contracts

import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single

interface DataSources {
    interface RepositoriesDataSource{
        fun getRepositoriesList():Single<List<Repository>>
        fun getRepositoryDetails()
    }
}