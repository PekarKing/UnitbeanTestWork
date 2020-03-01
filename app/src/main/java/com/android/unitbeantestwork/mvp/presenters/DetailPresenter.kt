package com.android.unitbeantestwork.mvp.presenters

import com.android.unitbeantestwork.api.ApiServiceInterface
import com.android.unitbeantestwork.mvp.views.DetailView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

@InjectViewState
class DetailPresenter(private val id: String) : MvpPresenter<DetailView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadFactDate()
    }

    private fun loadFactDate() {
        viewState.showProgressBar(true)
        ApiServiceInterface.create().getFactById(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val date = it.createdAt.substring(0, 16).replace("T", " ")
                viewState.showProgressBar(false)
                viewState.onFactLoaded(
                    SimpleDateFormat("hh:mm a dd MMM, yyyy", Locale.US)
                    .format(SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.US).parse(date) as Date))
            }, {
                it.printStackTrace()
                viewState.showProgressBar(false)
            })
    }
}