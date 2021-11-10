package com.examen.listDogs.data.repository

import com.examen.listDogs.data.model.Dog
import com.examen.listDogs.data.network.ApiService
import com.examen.listDogs.di.ApiProvider

class DogsRepository {
    /*  todo ("Sera la encargada de gestionar todas las peticiones") */

    private val api = ApiService()

    suspend fun getAllMyDogs(): List<Dog> {
        val response: List<Dog> = api.getDogs()
        ApiProvider.dogsList = response
        return response
    }



}