package com.android.unitbeantestwork.presenters

import com.android.unitbeantestwork.Contract
import com.android.unitbeantestwork.internet.FactList
import com.android.unitbeantestwork.internet.Network
import com.android.unitbeantestwork.other.Fact
import com.android.unitbeantestwork.other.FactAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(_mMainView: Contract.MainView): Contract.MainPresenter {
    private var mMainView: Contract.MainView = _mMainView
    private var mFactArray = ArrayList<Fact>()
    private var mFactAdapter = FactAdapter(mFactArray, mMainView)

    init {
        Network().getAPI().getAllFacts().enqueue(object: Callback<FactList> {
            override fun onResponse(call: Call<FactList>, response: Response<FactList>){
                mFactArray.clear()
                mFactArray.addAll(response.body()!!.facts)
                mFactAdapter.notifyDataSetChanged()
                mMainView.onSetUpRecyclerView(mFactAdapter)
            }
            override fun onFailure(call: Call<FactList>, t: Throwable) {}
        })
    }
}