package com.gustavo.githubrepositories.contracts

interface DataSources {
    interface RepositoriesProvider{
        fun getRepositoriesList()
        fun getRepositoryDetails()
    }
}