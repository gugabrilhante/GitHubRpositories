package com.gustavo.githubrepositories.datasource.api

import com.gustavo.githubrepositories.datasource.data.OwnerGson
import com.gustavo.githubrepositories.datasource.data.RepositoryGson
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoriesServerCalls {

    @GET("repositories")
    fun getRepositoryList(): Single<List<RepositoryGson>>

    @GET("users/{username}")
    fun getUserDetails(@Path("username") username: String): Single<OwnerGson>

}