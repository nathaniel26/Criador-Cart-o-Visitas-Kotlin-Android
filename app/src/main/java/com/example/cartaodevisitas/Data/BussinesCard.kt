package com.example.cartaodevisitas.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

//essa entidade é para nossa classe bussinesCard
@Entity
data class BussinesCard (
    //Como estamos tabalhando com uma tabela, precisamos de uma chave primaria
    //o autoGenerate serve para gerar indices automaticamente
    //desa forma vai gerar um id 1, 2, 3, 4
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val empresa: String,
    val telefone:String,
    val email: String,
    val fundo: String)