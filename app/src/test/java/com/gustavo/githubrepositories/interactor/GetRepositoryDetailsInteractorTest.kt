package com.gustavo.githubrepositories.interactor

import com.gustavo.githubrepositories.common.mock.MockData
import com.gustavo.githubrepositories.contracts.DataSources
import com.gustavo.githubrepositories.entity.Owner
import com.gustavo.githubrepositories.entity.Repository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class GetRepositoryDetailsInteractorTest {

    private val detailsDataSource: DataSources.DetailsDataSource = mock()

    private lateinit var getRepositoryDetailsInteractor: GetRepositoryDetailsInteractor

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        getRepositoryDetailsInteractor = GetRepositoryDetailsInteractor(detailsDataSource)
    }

    @Test
    fun execute() {
        val repository = MockData.mockRepository(1)
        val owner = Owner("login", 0, "test", "name")
        whenever(detailsDataSource.getSelectedRepositorie()).thenReturn(repository)
        whenever(detailsDataSource.getOwnerDetails(any())).thenReturn(Single.just(owner))

        val testSingleObserver = TestObserver<Repository>()

        val result =  getRepositoryDetailsInteractor.execute()
        result.subscribe(testSingleObserver)

        val value = testSingleObserver.values()[0]
        assertNotEquals(value.owner.id, repository.owner.id)
        assertEquals(value.owner.id, owner.id)
        assertEquals(value.owner.name, owner.name)
        assertEquals(value.name, repository.name)

    }
}