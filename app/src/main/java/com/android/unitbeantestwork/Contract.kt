package com.android.unitbeantestwork

import com.android.unitbeantestwork.other.Fact
import com.android.unitbeantestwork.other.FactAdapter

interface Contract {
    interface MainView {
        fun onSetUpRecyclerView(adapter: FactAdapter)
        fun showDetail(fact: Fact)
    }
    interface MainPresenter{}
    interface DetailView {
        fun show(fact: Fact)
    }
    interface DetailPresenter {
        fun load(fact: Fact)
    }
}