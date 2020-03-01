package com.android.unitbeantestwork.mvp.views

import com.android.unitbeantestwork.mvp.model.Fact
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun openDetailScreen(fact: Fact)
    fun onFactsLoaded(facts: List<Fact>)
    fun updateView()
    fun showProgressBar(boolean: Boolean)
}