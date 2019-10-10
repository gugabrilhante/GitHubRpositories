package com.gustavo.githubrepositories.features.repositorylist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gustavo.githubrepositories.R
import com.gustavo.githubrepositories.common.extensions.verticalLinearLayout
import com.gustavo.githubrepositories.entity.Repository
import com.gustavo.githubrepositories.features.repositorylist.injection.RepositoryListInjection
import com.gustavo.githubrepositories.features.repositorylist.injection.RepositoryListModule
import com.gustavo.githubrepositories.features.repositorylist.injection.RepositoryListModuleImpl
import com.gustavo.githubrepositories.features.repositorylist.presentation.RepositoryListViewModel
import com.gustavo.githubrepositories.features.repositorylist.presentation.RepositoryListViewModelFactory
import com.gustavo.githubrepositories.features.repositorylist.ui.adapter.RepositoryAdapter
import com.gustavo.githubrepositories.features.repositorylist.ui.adapter.RepositoryListener
import kotlinx.android.synthetic.main.activity_repository_list.*

class RepositoryListActivity : AppCompatActivity(), RepositoryListInjection {

    override val module: RepositoryListModule by lazy {
        RepositoryListModuleImpl(this)
    }

    private lateinit var viewModel: RepositoryListViewModel
    private lateinit var adapter:RepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)
        viewModel = getViewModel()
        setObservables()
        viewModel.fetchRepositories()
        initViews()
    }

    private fun initViews() {
        adapter = RepositoryAdapter()
        adapter.listener = object : RepositoryListener {
            override fun onClick(repository: Repository) {
                viewModel.onRepositorySelected(repository)
            }
        }
        recyclerView.verticalLinearLayout(this)
        recyclerView.adapter = adapter
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
        adapter.list = it
    }

    private fun getViewModel() =
        ViewModelProviders.of(this, RepositoryListViewModelFactory(this)).get(RepositoryListViewModel::class.java)
}
