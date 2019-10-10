package com.gustavo.githubrepositories.common.mock

import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.Single

class GetRepositoryListMock:Iterators.GetRepositoriesList {
    override fun execute(): Single<List<Repository>> {
        return mockRepositorios()
    }

    private fun mockRepositorios(): Single<List<Repository>> {
        return Single.just(MockData.mockRepositoryList())
    }


}