package com.android.unitbeantestwork.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailView : MvpView {
    fun showProgressBar(boolean: Boolean)
    fun onFactLoaded(date: String)
}