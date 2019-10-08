package com.gustavo.githubrepositories.datasource.providers

import com.gustavo.githubrepositories.datasource.data.OwnerGson
import com.gustavo.githubrepositories.entity.Owner

class OwnerMapper {
    fun toEntity(ownerGson: OwnerGson): Owner {
        return Owner(
            login = ownerGson.login,
            id = ownerGson.id,
            avatar_url = ownerGson.avatar_url
        )
    }
}