package com.example.cartaodevisitas.UI

import android.graphics.ColorSpace
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartaodevisitas.Data.BussinesCard
import com.example.cartaodevisitas.Data.BussinesCardRepositore
import kotlinx.coroutines.Job

class MainViewModel(val bussinesCardRepositore: BussinesCardRepositore) : ViewModel(){

    fun insert(bussinesCard: BussinesCard): Job {

        return bussinesCardRepositore.insert(bussinesCard)
    }

    fun getAll() : LiveData<List<BussinesCard>>{

        return bussinesCardRepositore.getAll()
    }

}

//aqui criamos um metodo factory para essa nossa view funcionar
class MainViewModelFactory(private val repository: BussinesCardRepositore):
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}