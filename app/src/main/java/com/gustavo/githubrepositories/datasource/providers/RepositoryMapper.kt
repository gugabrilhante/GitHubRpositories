package com.gustavo.githubrepositories.datasource.providers

import com.gustavo.githubrepositories.datasource.data.RepositoryGson
import com.gustavo.githubrepositories.entity.Repository

class RepositoryMapper {
    fun toEntity(repositoryGson: RepositoryGson):Repository {
        return Repository(
            description = repositoryGson.description,
            user = repositoryGson.user,
            owner = OwnerMapper().toEntity(repositoryGson.ownerGson)
        )
    }
}