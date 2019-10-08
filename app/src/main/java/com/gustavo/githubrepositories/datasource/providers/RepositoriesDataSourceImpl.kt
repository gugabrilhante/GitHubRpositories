package com.gustavo.githubrepositories.datasource.providers

import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.datasource.api.RepositoriesServices
import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single

class RepositoriesDataSourceImpl(
    private val services: RepositoriesServices,
    private val mapper: RepositoryMapper = RepositoryMapper()
):DataSources.RepositoriesDataSource {
    override fun getRepositoriesList(): Single<List<Repository>> {
        return services.getRepositoryList().map {list ->
            list.map { mapper.toEntity(it) }
        }
    }

    override fun getRepositoryDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}