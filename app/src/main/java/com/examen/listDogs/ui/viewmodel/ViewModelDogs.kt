package com.examen.listDogs.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.examen.listDogs.core.Aplication.Companion.preferences
import com.examen.listDogs.data.database.DogDataBase
import com.examen.listDogs.data.model.Dog
import com.examen.listDogs.data.model.DogRoom
import com.examen.listDogs.data.repository.DogRoomRepository
import com.examen.listDogs.domain.GetUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelDogs(application: Application): AndroidViewModel(application) {

    val apiModel = MutableLiveData<List<Dog>>()
    var getDogsUseCase = GetUseCase()



    private val repository: DogRoomRepository

    init{
        val dogDao = DogDataBase.getDatabase(application).dogDao()
        repository = DogRoomRepository(dogDao)
    }

    fun onCreate(){
        viewModelScope.launch(Dispatchers.IO){

            val preferenceValue: Boolean = preferences.getSave()
            if (preferenceValue){
                apiModel.postValue(getIntoDataBase())
            }else {
                preferences.save(true)
                addInformationToDataBase()
                apiModel.postValue(getIntoDataBase())
            }
        }
    }


    suspend fun addInformationToDataBase(){
        val result = getDogsUseCase()
        if (!result.isNullOrEmpty()) {
            result.forEach {
                val inserModel = DogRoom(0, it.age, it.description, it.dogName, it.image)
                repository.addDogs(inserModel)
            }
        }
    }

    fun getIntoDataBase(): List<Dog>{
        val listDogs: MutableList<Dog> = mutableListOf()
        val resultDogs: List<DogRoom> =  repository.readAllDogs() //get in database
        resultDogs.forEach {
            listDogs.add(Dog(it.age,it.description,it.dogName,it.image))
        }
        return listDogs
    }




}