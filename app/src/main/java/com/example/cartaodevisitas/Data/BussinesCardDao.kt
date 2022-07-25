package com.example.cartaodevisitas.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface BussinesCardDao {

    //Aqui busca os dados no banco de dados....
    @Query("SELECT * FROM BussinesCard")
    fun getAll(): LiveData<List<BussinesCard>>

    //Aqui é quem passa os dados para o usuario
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(bussinesCard: BussinesCard)
}