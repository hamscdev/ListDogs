package com.examen.listDogs.data.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.examen.listDogs.data.model.DogRoom

@Dao
interface DogDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDogs(dog: DogRoom)

    @Query("SELECT * FROM dog_table ORDER BY id")
    fun getAllDogs(): List<DogRoom>


}