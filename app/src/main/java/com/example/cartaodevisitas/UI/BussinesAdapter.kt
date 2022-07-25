package com.example.cartaodevisitas.UI

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cartaodevisitas.Data.BussinesCard
import com.example.cartaodevisitas.databinding.ItemCartaoVisitasBinding

class BussinesAdapter : ListAdapter<BussinesCard,
        BussinesAdapter.ViewHolder>(DiffCallback()){

    var listenerShare: (View) -> Unit = {}

    inner class ViewHolder(private val binding : ItemCartaoVisitasBinding ) :
        RecyclerView.ViewHolder(binding.root){

            fun bind(item: BussinesCard){
                binding.tvNome.text = item.nome
                binding.tvEmail.text = item.email
                binding.tvTelefone.text = item.telefone
                binding.tvEmpresa.text = item.empresa
                //aqui vamos adicionar uma cor de fundo ao nosso cartão
                binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundo))
                //e aqui um evento de click que usaremos para compartilhar...
                binding.cdContent.setOnClickListener{

                    listenerShare(it)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val infrater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoVisitasBinding.inflate(infrater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback: DiffUtil.ItemCallback<BussinesCard>(){
    override fun areItemsTheSame(oldItem: BussinesCard, newItem: BussinesCard) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: BussinesCard, newItem: BussinesCard) =
        oldItem.id == newItem.id
}