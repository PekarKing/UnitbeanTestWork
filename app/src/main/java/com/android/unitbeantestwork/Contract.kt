package com.android.unitbeantestwork

import com.android.unitbeantestwork.other.FactAdapter

interface Contract {
    interface MainView {
        fun onSetUpRecyclerView(adapter: FactAdapter)
        fun showDetail()
    }
    interface MainPresenter{}
    interface DetailView {}
    interface DetailPresenter {}
}