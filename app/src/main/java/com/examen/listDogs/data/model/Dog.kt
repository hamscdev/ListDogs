package com.examen.listDogs.data.model

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("age")
    val age: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("dogName")
    val dogName: String,
    @SerializedName("image")
    val image: String
)