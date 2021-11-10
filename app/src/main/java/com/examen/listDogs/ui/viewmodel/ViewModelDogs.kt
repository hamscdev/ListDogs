package com.examen.listDogs.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examen.listDogs.data.model.Dog
import com.examen.listDogs.domain.GetUseCase
import kotlinx.coroutines.launch

class ViewModelDogs: ViewModel() {

    val apiModel = MutableLiveData<List<Dog>>()
    var getDogsUseCase = GetUseCase()


    fun onCreate(){
        viewModelScope.launch {
            val result = getDogsUseCase()
            if (!result.isNullOrEmpty()) {
                    apiModel.postValue(result!!)
            }
        }
    }


}