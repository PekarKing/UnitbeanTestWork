package com.android.unitbeantestwork

import android.content.Context
import com.android.unitbeantestwork.other.Fact
import com.android.unitbeantestwork.other.FactAdapter

interface Contract {
    interface MainView {
        fun onSetUpRecyclerView(adapter: FactAdapter)
        fun showDetail(fact: Fact)
        fun getContext(): Context
    }
    interface MainPresenter{}
    interface DetailView {
        fun show(fact: Fact)
    }
    interface DetailPresenter {
        fun load(fact: Fact)
    }
}