package com.gustavo.githubrepositories.contracts

import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single

interface Iterators {
    interface GetRepositoriesList {
        fun execute(): Single<List<Repository>>
    }

    interface GetRepositoryDetail {
        fun execute(): Single<Repository>
    }
}