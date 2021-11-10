package com.examen.listDogs.core

import android.app.Application
import com.examen.listDogs.di.Preference
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics



class Aplication: Application() {



    companion object{
        lateinit var preferences: Preference
    }
    override fun onCreate() {
        super.onCreate()

         preferences = Preference(applicationContext)

    }
}