package com.example.cartaodevisitas.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

//Aqui temos que passar que entidades temos no projeto, por enquanto temos só uma..
@Database(entities = [BussinesCard::class], version = 1)
abstract class AppDataBase : RoomDatabase (){
    abstract fun bussinesDao() : BussinesCardDao
    // essa é uma estrutura padrão do room
    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    //nome do banco de dados
                    "Banco de dados",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}