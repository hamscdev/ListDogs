package com.examen.listDogs.di

import android.content.Context

class Preference(val context: Context) {

    val baseShare = "DogTable"
    val sharedName = "into"

    val storage = context.getSharedPreferences(baseShare,0)

    fun save(value: Boolean) {
        storage.edit().putBoolean(sharedName,value).apply()
    }

    fun getSave(): Boolean {
        return storage.getBoolean(sharedName,false)
    }


}