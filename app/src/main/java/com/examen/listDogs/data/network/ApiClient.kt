package com.examen.listDogs.data.network

import com.examen.listDogs.data.model.Dog
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("880188946124021760")
    suspend fun getAllDogs(): Response<List<Dog>>
}