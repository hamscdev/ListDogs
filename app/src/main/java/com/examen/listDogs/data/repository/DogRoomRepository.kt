package com.examen.listDogs.data.repository

import com.examen.listDogs.data.dao.DogDao
import com.examen.listDogs.data.model.DogRoom

class DogRoomRepository(private val dogDao: DogDao) {

    fun readAllDogs(): List<DogRoom> = dogDao.getAllDogs()



    suspend fun addDogs(dogRoom: DogRoom){
        dogDao.addDogs(dogRoom)
    }

}