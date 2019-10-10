package com.gustavo.githubrepositories.contracts

import com.gustavo.githubrepositories.entity.Owner
import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single

interface DataSources {
    interface RepositoriesDataSource{
        fun getRepositoriesList():Single<List<Repository>>
    }
    interface DetailsDataSource{
        fun getOwnerDetails(username:String):Single<Owner>
        fun getSelectedRepositorie():Repository
    }

}