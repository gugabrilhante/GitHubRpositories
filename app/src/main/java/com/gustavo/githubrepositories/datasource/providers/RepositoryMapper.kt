package com.gustavo.githubrepositories.datasource.providers

import com.gustavo.githubrepositories.datasource.data.RepositoryGson
import com.gustavo.githubrepositories.entity.Repository

class RepositoryMapper {
    fun toEntity(repositoryGson: RepositoryGson):Repository {
        return Repository(
            name = repositoryGson.name,
            description = repositoryGson.description,
            owner = OwnerMapper().toEntity(repositoryGson.owner),
            isFork = repositoryGson.fork
        )
    }
}