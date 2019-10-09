package com.gustavo.githubrepositories.features.repositorydetails.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gustavo.githubrepositories.features.repositorydetails.injection.RepositoryDetailsInjection
import com.gustavo.githubrepositories.features.repositorydetails.injection.RepositoryDetailsModule

class RepositoryDetailsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepositoryDetailsViewModel(
            module.getRepositoryDetailsInteractor
        ) as T
    }

    private val module: RepositoryDetailsModule
        get() = (context as RepositoryDetailsInjection).module
}