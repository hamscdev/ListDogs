package com.examen.listDogs.core

import android.app.Application
import com.examen.listDogs.di.Preference
import java.lang.Appendable

class Aplication: Application() {



    companion object{
        lateinit var preferences: Preference
    }
    override fun onCreate() {
        super.onCreate()

         preferences = Preference(applicationContext)
    }
}