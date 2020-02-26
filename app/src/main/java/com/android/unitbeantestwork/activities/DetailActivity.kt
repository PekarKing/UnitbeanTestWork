package com.android.unitbeantestwork.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.unitbeantestwork.Contract
import com.android.unitbeantestwork.R
import com.android.unitbeantestwork.other.Fact
import com.android.unitbeantestwork.presenters.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), Contract.DetailView {

    private var mDetailPresenter: Contract.DetailPresenter = DetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val array = intent.getStringArrayListExtra("fact")
        iProgressBar.visibility = View.VISIBLE
        mDetailPresenter.load(Fact().toFactFromArray(array!!))
    }

    override fun show(fact: Fact){
        val name = "${fact.user.name.first} ${fact.user.name.last}"
        val body = "    ${fact.text}"
        detail_user.text = name
        detail_body.text = body
        detail_date.text = fact.createdAt
        detail_votes.text = fact.upVotes.toString()
        supportActionBar?.title = fact.factNumber
        iProgressBar.visibility = View.GONE
    }
}
