package com.examen.listDogs.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.examen.listDogs.data.dao.DogDao
import com.examen.listDogs.data.model.DogRoom


@Database(entities = [DogRoom::class], version = 1 , exportSchema = false)
abstract class DogDataBase: RoomDatabase() {

    abstract  fun dogDao(): DogDao

    companion object{
        @Volatile
        private var INSTANCE: DogDataBase? = null
        fun getDatabase(context: Context): DogDataBase{
            val tmpInstance = INSTANCE
            if (tmpInstance != null){
                return tmpInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    DogDataBase::class.java,
                    "dog_database").build()
                INSTANCE = instance
                return instance
            }

        }
    }

}