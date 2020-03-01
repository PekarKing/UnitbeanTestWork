package com.android.unitbeantestwork.ui.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.unitbeantestwork.R
import com.android.unitbeantestwork.mvp.model.Fact
import com.android.unitbeantestwork.mvp.presenters.MainPresenter
import com.android.unitbeantestwork.mvp.views.MainView
import com.android.unitbeantestwork.ui.adapters.FactsAdapter
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.attachView(this)
    }

    override fun onFactsLoaded(facts: List<Fact>) {
        factList.layoutManager = LinearLayoutManager(this)
        factList.adapter = FactsAdapter(facts, this)
        updateView()
    }

    override fun updateView() {
        factList.adapter!!.notifyDataSetChanged()
    }

    override fun showProgressBar(boolean: Boolean) {
        mainProgressBar.visibility = when(boolean){
            true -> View.VISIBLE
            false -> View.GONE
        }
    }

    override fun openDetailScreen(fact: Fact) = startActivity(DetailActivity.buildIntent(this, fact))
}
