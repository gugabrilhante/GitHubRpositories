package com.gustavo.githubrepositories.interactor

import com.gustavo.githubrepositories.common.mock.MockData
import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.entity.Repository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetRepositoryListInteractorTest {

    private val repositoryDataSource: DataSources.RepositoriesDataSource = mock()

    private lateinit var getRepositoryListInteractor:GetRepositoryListInteractor

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        getRepositoryListInteractor = GetRepositoryListInteractor(repositoryDataSource)
    }

    @Test
    fun execute() {
        val list = MockData.mockRepositoryList()
        whenever(repositoryDataSource.getRepositoriesList()).thenReturn(Single.just(list))

        val testSingleObserver = TestObserver<List<Repository>>()

        val result =  getRepositoryListInteractor.execute()
        result.subscribe(testSingleObserver)

        val value = testSingleObserver.values()[0]
        assertEquals(list!!.size, value!!.size)
        value.forEachIndexed { index, repository ->
            assertEquals(repository, value[index])
        }

    }
}