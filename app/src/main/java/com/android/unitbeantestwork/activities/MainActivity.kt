package com.android.unitbeantestwork.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.unitbeantestwork.Contract
import com.android.unitbeantestwork.R
import com.android.unitbeantestwork.other.Fact
import com.android.unitbeantestwork.other.FactAdapter
import com.android.unitbeantestwork.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.MainView {

    private var mMainPresenter: Contract.MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSetUpRecyclerView(adapter: FactAdapter) {
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.adapter = adapter
    }

    override fun showDetail(fact: Fact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putStringArrayListExtra("fact", fact.toStringArrayList())
        startActivity(intent)
        onPause()
    }
}
