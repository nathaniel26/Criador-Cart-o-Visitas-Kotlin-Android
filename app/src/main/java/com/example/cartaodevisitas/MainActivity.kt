package com.example.cartaodevisitas

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.example.cartaodevisitas.Data.AppDataBase
import com.example.cartaodevisitas.Data.BussinesCardRepositore
import com.example.cartaodevisitas.UI.AddActivity
import com.example.cartaodevisitas.UI.BussinesAdapter
import com.example.cartaodevisitas.UI.MainViewModel
import com.example.cartaodevisitas.UI.MainViewModelFactory
import com.example.cartaodevisitas.Util.Image
import com.example.cartaodevisitas.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    //precisamos instanciar o Room assim que nosso app iniciar
    val dataBase by lazy { AppDataBase.getDatabase(this) }
    //Precisamos tambem instanciar nosso repositorio
    val repository by lazy { BussinesCardRepositore(dataBase.bussinesDao()) }

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory(repository)
    }

    private val adapter by lazy { BussinesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvCards.adapter = adapter



        getAllBussinesCard()
        insertListener()

    }


    private fun insertListener(){
        //botão add
        binding.fbtAddCartao.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }

    }

    private fun getAllBussinesCard(){
        mainViewModel.getAll().observe(this, { businesCard ->
            adapter.submitList(businesCard)
        })
    }
}