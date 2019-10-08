package com.gustavo.githubrepositories.datasource.api

import com.gustavo.githubrepositories.datasource.data.RepositoryGson
import io.reactivex.Single
import retrofit2.http.GET

interface RepositoriesServerCalls {

    @GET("repositories")
    fun getRepositoryList():Single<List<RepositoryGson>>

}