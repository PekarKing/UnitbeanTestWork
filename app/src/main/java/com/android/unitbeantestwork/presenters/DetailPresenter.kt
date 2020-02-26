package com.android.unitbeantestwork.presenters

import com.android.unitbeantestwork.Contract
import com.android.unitbeantestwork.internet.Network
import com.android.unitbeantestwork.internet.SpecialFact
import com.android.unitbeantestwork.other.Fact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class DetailPresenter(_mDetailView: Contract.DetailView): Contract.DetailPresenter {

    private var mDetailView = _mDetailView

    override fun load(fact: Fact) {
        Network().getAPI().getFactById(fact.id).enqueue(object : Callback<SpecialFact> {
            override fun onResponse(call: Call<SpecialFact>, response: Response<SpecialFact>) {
                val date = response.body()!!.createdAt.substring(0, 16).replace("T", " ")
                fact.createdAt = SimpleDateFormat("hh:mm a dd MMM, yyyy", Locale.US)
                    .format(SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.US).parse(date))
                mDetailView.show(fact)
            }
            override fun onFailure(call: Call<SpecialFact>, t: Throwable) {
                fact.text = " ${t.message}"
                mDetailView.show(fact)
            }
        })
    }
}