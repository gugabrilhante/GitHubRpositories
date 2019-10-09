package com.gustavo.githubrepositories.interactor

import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.entity.Owner
import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class GetRepositoryDetailsInteractor(
    private val detailsDataSource: DataSources.DetailsDataSource
) : Iterators.GetRepositoryDetail {
    override fun execute(): Single<Repository> {
        val repository = detailsDataSource.getSelectedRepositorie()
        return Single.just(repository)
            .zipWith(detailsDataSource.getOwnerDetails(repository.owner.login),
                BiFunction<Repository, Owner, Repository> { repository, owner ->
                    Repository(
                        repository.name,
                        repository.description,
                        owner,
                        repository.isFork
                    )
                })
    }


}