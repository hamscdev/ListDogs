package com.examen.listDogs.data.network

import com.examen.listDogs.core.RetrofitHelper
import com.examen.listDogs.data.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDogs(): List<Dog> {
        return withContext(Dispatchers.IO) {
            val response: Response<List<Dog>> = retrofit.create(ApiClient::class.java).getAllDogs()
            response.body()?: emptyList()
        }
    }   //todo("NUESTRO SERVICIO RETORNARA EN VARIOS HILOS EL RESULTADO DE LA LISTA DE PERROS ESTO ESTARA OPTIMIZANDO LA PETICIÓN")
}