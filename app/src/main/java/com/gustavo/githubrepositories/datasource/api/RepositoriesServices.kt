package com.gustavo.githubrepositories.datasource.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RepositoriesServices {

    private val repositoriesServices:RepositoriesServices

    companion object {
        const val BASE_URL = ""
    }


    init {
        val clientBuilder = OkHttpClient.Builder()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        repositoriesServices = retrofit
            .create(RepositoriesServices::class.java)
    }

}