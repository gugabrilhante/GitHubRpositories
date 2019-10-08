package com.gustavo.githubrepositories.contracts

import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single

interface Interactors {
    interface GetRepositoriesList{
        fun execute(): Single<List<Repository>>
    }
}