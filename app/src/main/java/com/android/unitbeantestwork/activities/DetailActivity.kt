package com.android.unitbeantestwork.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.android.unitbeantestwork.R

class DetailActivity : AppCompatActivity() {

    fun start(@NonNull activity: Activity){
        val intent = Intent(activity, DetailActivity::class.java)
        activity.startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
