package com.examen.listDogs.di

import com.examen.listDogs.data.model.Dog

class ApiProvider {

    companion object{
        var dogsList: List<Dog> = emptyList()
    }
}