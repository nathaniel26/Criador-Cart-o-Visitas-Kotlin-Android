package com.example.cartaodevisitas.Data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BussinesCardRepositore (private val dao: BussinesCardDao){

    // criamos uma função inset que recebe bussines Card e abrimos essa
    //corrotina chamada runBloking
    fun insert(bussinesCard: BussinesCard) = runBlocking {
        launch (Dispatchers.IO){
            dao.insert(bussinesCard)
        }
    }

    fun getAll() = dao.getAll()
}

