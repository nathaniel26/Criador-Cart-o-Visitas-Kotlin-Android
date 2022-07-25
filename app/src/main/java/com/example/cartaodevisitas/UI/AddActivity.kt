package com.example.cartaodevisitas.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.cartaodevisitas.Data.BussinesCard
import com.example.cartaodevisitas.Data.BussinesCardDao
import com.example.cartaodevisitas.Data.BussinesCardRepositore
import com.example.cartaodevisitas.MainActivity
import com.example.cartaodevisitas.R
import com.example.cartaodevisitas.databinding.ActivityAddBinding


class AddActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory(MainActivity().repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListener()
    }

    private fun insertListener() {
        binding.btFechar.setOnClickListener{
            finish()
        }

        binding.btSalvar.setOnClickListener(){

            val cartaoVisitas = BussinesCard(
                nome = binding.tiAddNome.editText?.text.toString(),
                empresa = binding.tiAddEmpresa.editText?.text.toString(),
                email = binding.tiAddEmail.editText?.text.toString(),
                telefone = binding.tiAddTelefone.editText?.text.toString(),
                fundo = binding.tiAddCor.editText?.text.toString()
            )

            mainViewModel.insert(cartaoVisitas)
            Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()
            finish()

        }
    }


}