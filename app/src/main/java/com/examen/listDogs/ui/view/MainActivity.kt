package com.examen.listDogs.ui.view

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.examen.listDogs.R
import com.examen.listDogs.adapter.DogsAdapter
import com.examen.listDogs.ui.viewmodel.ViewModelDogs
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes




class MainActivity : AppCompatActivity() {



    val viewModelDogs: ViewModelDogs by viewModels()
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "9fe1e76f-44b1-44ca-8e5e-510088d13905",
            Analytics::class.java, Crashes::class.java
        )


        recyclerView = findViewById(R.id.recycle_view_dogs)


        viewModelDogs.onCreate()
        viewModelDogs.apiModel.observe(this, Observer {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = DogsAdapter(it, this)

        })


    }








}