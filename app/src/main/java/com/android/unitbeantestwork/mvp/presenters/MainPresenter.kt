package com.android.unitbeantestwork.mvp.presenters

import com.android.unitbeantestwork.api.ApiServiceInterface
import com.android.unitbeantestwork.mvp.model.Fact
import com.android.unitbeantestwork.mvp.views.MainView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    private val factList = ArrayList<Fact>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadAllFacts()
    }

    private fun loadAllFacts() {
        viewState.showProgressBar(true)
        ApiServiceInterface.create().getAllFacts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showProgressBar(false)
                factList.addAll(it.facts)
                viewState.onFactsLoaded(factList)
            }, {
                it.printStackTrace()
                viewState.showProgressBar(false)
            })
    }
}