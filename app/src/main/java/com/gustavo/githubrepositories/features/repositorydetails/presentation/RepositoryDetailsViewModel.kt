package com.gustavo.githubrepositories.features.repositorydetails.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gustavo.githubrepositories.common.base.BaseViewModel
import com.gustavo.githubrepositories.contracts.Iterators
import com.gustavo.githubrepositories.entity.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryDetailsViewModel(
    private val getRepositoryDetail: Iterators.GetRepositoryDetail
): BaseViewModel() {

    private val _repositoryLiveData = MutableLiveData<Repository>()
    val repositoryLiveData: LiveData<Repository>
        get() = _repositoryLiveData

    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean>
        get() = _isLoadingLiveData

    override val compositeDisposable = CompositeDisposable()

    fun fetchData(){
        _isLoadingLiveData.value = true
        val disposable = getRepositoryDetail.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _repositoryLiveData.value = it
                _isLoadingLiveData.value = false
            },{
                _isLoadingLiveData.value = false
            })

        compositeDisposable.add(disposable)
    }
}
