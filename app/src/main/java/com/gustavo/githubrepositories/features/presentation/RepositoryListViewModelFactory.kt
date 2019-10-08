package com.gustavo.githubrepositories.features.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gustavo.githubrepositories.features.injection.RepositoryListInjection
import com.gustavo.githubrepositories.features.injection.RepositoryListModule

class RepositoryListViewModelFactory(private val context: Context) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepositoryListViewModel(
            module.getRepositoryList,
            module.repositoryListRouter
        ) as T
    }

    private val module: RepositoryListModule
        get() = (context as RepositoryListInjection).module
}