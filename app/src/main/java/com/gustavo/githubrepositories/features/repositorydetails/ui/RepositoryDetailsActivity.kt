package com.gustavo.githubrepositories.features.repositorydetails.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.gustavo.githubrepositories.R
import com.gustavo.githubrepositories.common.extensions.setInVisible
import com.gustavo.githubrepositories.common.extensions.setVisible
import com.gustavo.githubrepositories.entity.Repository
import com.gustavo.githubrepositories.features.repositorydetails.injection.RepositoryDetailsInjection
import com.gustavo.githubrepositories.features.repositorydetails.injection.RepositoryDetailsModule
import com.gustavo.githubrepositories.features.repositorydetails.injection.RepositoryDetailsModuleImpl
import com.gustavo.githubrepositories.features.repositorydetails.presentation.RepositoryDetailsViewModel
import com.gustavo.githubrepositories.features.repositorydetails.presentation.RepositoryDetailsViewModelFactory
import kotlinx.android.synthetic.main.activity_repository_details.*

class RepositoryDetailsActivity : AppCompatActivity(), RepositoryDetailsInjection {
    override val module: RepositoryDetailsModule by lazy {
        RepositoryDetailsModuleImpl(intent.extras!!)
    }

    private lateinit var viewModel: RepositoryDetailsViewModel

    companion object {
        const val REPOSITORY_KEY = "repository_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_details)

        if (!intent.hasExtra(REPOSITORY_KEY)) finish()
        viewModel = getViewModel()
        setObservables()
        viewModel.fetchData()
    }

    private fun setObservables() {
        viewModel.repositoryLiveData.observe(this, Observer {
            setRepository(it)
        })
        viewModel.isLoadingLiveData.observe(this, Observer {
            progressCircular.isVisible = it
            repositoryLayout.isVisible = !it
        })
    }

    private fun setRepository(repository: Repository) {
        repositoryNameTextView.text = repository.name
        descriptionTextView.text = repository.description ?: ""
        userNameTextView.text = repository.owner.login
        nameTextView.text = repository.owner.name
        Glide.with(this).load(repository.owner.avatar_url)
            .into(userNameImageView)

        if (repository.isFork) forkImageView.setVisible()
        else forkImageView.setInVisible()

    }

    private fun getViewModel() =
        ViewModelProviders.of(this, RepositoryDetailsViewModelFactory(this)).get(
            RepositoryDetailsViewModel::class.java)
}
