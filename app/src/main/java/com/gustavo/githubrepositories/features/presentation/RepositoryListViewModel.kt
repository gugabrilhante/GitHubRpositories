package com.gustavo.githubrepositories.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gustavo.githubrepositories.common.base.BaseViewModel
import com.gustavo.githubrepositories.contracts.Interactors
import com.gustavo.githubrepositories.contracts.Routers
import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryListViewModel(
    private val getRepositoryList: Interactors.GetRepositoriesList,
    val repositoryListRouter: Routers.RepositoryListRouter
) : BaseViewModel() {

    private val _repositoryListLiveData = MutableLiveData<List<Repository>>()
    val repositoryListLiveData: LiveData<List<Repository>>
        get() = _repositoryListLiveData

    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean>
        get() = _isLoadingLiveData

    override val compositeDisposable = CompositeDisposable()

    fun fetchRepositories() {
        _isLoadingLiveData.value = true
        val disposable = getRepositoryList.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _repositoryListLiveData.value = it
                _isLoadingLiveData.value = false
            }, {
                _isLoadingLiveData.value = false
            })
        compositeDisposable.add(disposable)

    }

}