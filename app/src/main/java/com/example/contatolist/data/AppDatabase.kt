package com.example.contatolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contatolist.data.DAO.ContatoDAO
import com.example.contatolist.data.Entity.ContatoEntity

@Database(entities = [ContatoEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun contatoDao():ContatoDAO

    companion object{
        @Volatile private var INSTANCE : AppDatabase?=null

        fun getDataBase(context:Context):AppDatabase{
            return  INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "contato_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}