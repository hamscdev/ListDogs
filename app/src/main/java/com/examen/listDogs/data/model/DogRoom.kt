package com.examen.listDogs.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog_table")
data class DogRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val age: Int,
    val description: String,
    val dogName: String,
    val image: String
)
