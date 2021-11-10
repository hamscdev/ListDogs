package com.examen.listDogs.domain

import com.examen.listDogs.data.model.Dog
import com.examen.listDogs.data.repository.DogsRepository

class GetUseCase {

    private val repository = DogsRepository()

    suspend operator fun invoke(): List<Dog> = repository.getAllMyDogs()
}