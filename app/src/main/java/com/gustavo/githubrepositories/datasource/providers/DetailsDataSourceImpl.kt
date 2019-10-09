package com.gustavo.githubrepositories.datasource.providers

import android.os.Bundle
import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.datasource.api.RepositoriesServices
import com.gustavo.githubrepositories.datasource.providers.mapper.OwnerMapper
import com.gustavo.githubrepositories.entity.Owner
import com.gustavo.githubrepositories.entity.Repository
import com.gustavo.githubrepositories.features.repositorydetails.ui.RepositoryDetailsActivity
import io.reactivex.Single

class DetailsDataSourceImpl(
    private val services: RepositoriesServices,
    private val bundle: Bundle,
    private val mapper: OwnerMapper = OwnerMapper()
) : DataSources.DetailsDataSource {
    override fun getSelectedRepositorie(): Repository {
        return bundle.getSerializable(RepositoryDetailsActivity.REPOSITORY_KEY) as Repository
    }

    override fun getOwnerDetails(username:String): Single<Owner> {
        return services.getUserDatails(username).map {
            mapper.toEntity(it)
        }
    }

}