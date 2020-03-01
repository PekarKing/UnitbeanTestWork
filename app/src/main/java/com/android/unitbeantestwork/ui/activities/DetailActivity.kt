package com.android.unitbeantestwork.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.android.unitbeantestwork.R
import com.android.unitbeantestwork.mvp.model.Fact
import com.android.unitbeantestwork.mvp.presenters.DetailPresenter
import com.android.unitbeantestwork.mvp.views.DetailView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : MvpAppCompatActivity(), DetailView {

    companion object {
        fun buildIntent(activity: Activity, fact: Fact): Intent {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putStringArrayListExtra("fact", fact.toStringArrayList())
            return intent
        }
    }

    @InjectPresenter
    lateinit var mPresenter: DetailPresenter
    var fact = Fact()

    @ProvidePresenter
    fun providePresenter(): DetailPresenter {
        fact = Fact().toFactFromArray(intent.extras!!.getStringArrayList("fact") as ArrayList<String>)
        return DetailPresenter(fact.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mPresenter.attachView(this)
    }

    override fun showProgressBar(boolean: Boolean) {
        detailProgressBar.visibility = when(boolean){
            true -> View.VISIBLE
            false -> View.GONE
        }
    }

    override fun onFactLoaded(date: String){
        val user = "${fact.user.name.first} ${fact.user.name.last}"
        val body = "    ${fact.text}"
        detail_user.text = user
        detail_body.text = body
        detail_date.text = date
        detail_votes.text = fact.upVotes.toString()
        supportActionBar?.title = fact.factNumber
    }
}
