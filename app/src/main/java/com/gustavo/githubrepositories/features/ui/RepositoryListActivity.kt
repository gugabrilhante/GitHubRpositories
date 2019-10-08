package com.gustavo.githubrepositories.features.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gustavo.githubrepositories.R
import com.gustavo.githubrepositories.common.extensions.verticalLinearLayout
import com.gustavo.githubrepositories.common.mock.RepositoryListModuleMock
import com.gustavo.githubrepositories.entity.Repository
import com.gustavo.githubrepositories.features.injection.RepositoryListInjection
import com.gustavo.githubrepositories.features.injection.RepositoryListModule
import com.gustavo.githubrepositories.features.injection.RepositoryListModuleImpl
import com.gustavo.githubrepositories.features.presentation.RepositoryListViewModel
import com.gustavo.githubrepositories.features.presentation.RepositoryListViewModelFactory
import com.gustavo.githubrepositories.features.ui.adapter.RepositoryAdapter
import kotlinx.android.synthetic.main.activity_repository_list.*

class RepositoryListActivity : AppCompatActivity(), RepositoryListInjection {

    override val module: RepositoryListModule by lazy {
        RepositoryListModuleImpl(this)
    }

    private lateinit var viewModel: RepositoryListViewModel
    private var adapter:RepositoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)
        viewModel = getViewModel()
        setObservables()
        viewModel.fetchRepositories()
    }

    private fun setObservables() {
        viewModel.repositoryListLiveData.observe(this, Observer {
            setRecyclerView(it)
        })
        viewModel.isLoadingLiveData.observe(this, Observer {
            progressCircular.isVisible = it
            recyclerView.isVisible = !it
        })
    }

    private fun setRecyclerView(it: List<Repository>) {
        adapter = RepositoryAdapter()
        adapter?.list = it
        recyclerView.verticalLinearLayout(this)
        recyclerView.adapter = adapter
    }

    private fun getViewModel() =
        ViewModelProviders.of(this, RepositoryListViewModelFactory(this)).get(RepositoryListViewModel::class.java)
}
