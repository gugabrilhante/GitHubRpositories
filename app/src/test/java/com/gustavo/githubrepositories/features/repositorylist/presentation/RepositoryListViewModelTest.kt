package com.gustavo.githubrepositories.features.repositorylist.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gustavo.githubrepositories.common.mock.MockData
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.contracts.Routers
import com.gustavo.githubrepositories.entity.Repository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class RepositoryListViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private val getRepositoryList: Iterators.GetRepositoriesList = mock()
    private val repositoryListRouter: Routers.RepositoryListRouter = mock()

    private lateinit var viewModel: RepositoryListViewModel

    @Before
    fun setup() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        viewModel = RepositoryListViewModel(getRepositoryList, repositoryListRouter)
    }

    @Test
    fun `fetch repositories feeds livedata`() {
        val list = MockData.mockRepositoryList()
        whenever(getRepositoryList.execute()).thenReturn(Single.just(list))

        viewModel.fetchRepositories()
        verify(getRepositoryList).execute()

        val value = viewModel.repositoryListLiveData.value
        assertEquals(list!!.size, value!!.size)
        value.forEachIndexed { index, repository ->
            assertEquals(repository, value[index])
        }

    }

    @Test
    fun onRepositorySelected() {
        val repository = mock<Repository>()

        viewModel.onRepositorySelected(repository)

        verify(repositoryListRouter).goToRepositoryDetail(repository)

    }
}