package com.example.app.appLite.ui.dados

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AlertDialogLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.app.data.models.Dado
import com.example.app.data.models.Icons
import com.example.app.databinding.FragmentDadoRecyclerBinding
import com.example.app.databinding.FragmentDadosBinding

class DadosAdapter(
        private var dados : List<Dado>,
        val viewModel: DadosViewModel
    ) :
    RecyclerView.Adapter<DadosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentDadoRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var dado = dados[position]
        var iconeIcon = Icons.get(dado.icon)
        holder.iconRolarDado.setImageResource(iconeIcon)
        holder.textNomeDado.text = dado.nome

        holder.deletarDado.setOnClickListener { view ->
            AlertDialog.Builder(view.context)
                .setMessage("ATENÇÃO: realmente deseja excluir?")
                .setPositiveButton("Confirmar") { dialog, id ->
                    viewModel.excluirPorId(dado)
                }
                .setNegativeButton("Cancelar") { dialog, i ->

                }
                .create()
                .show()
            true
        }

        holder.editarDado.setOnClickListener { view->

        }

        holder.iconRolarDado.setOnClickListener { view->
            val modText : String = dado.modificador.trim()
            AlertDialog.Builder(view.context)
                .setMessage(
                    "[${dado.quantidade}D${dado.faces}" + if(dado.modificador.isNotEmpty()){
                        modText
                    }else{""} + "] ${dado.nome} " +
                    "\n\nO Resultado da rolagem foi:" +
                    "\n\n${dado.rolarDado()}"
                )
                .setPositiveButton("Sair") { dialog, id ->

                }
                .create()
                .show()
            true
        }

//        holder.itemView.setOnLongClickListener { view ->
//            AlertDialog.Builder(view.context)
//                .setMessage("ATENÇÃO: realmente deseja excluir?")
//                .setPositiveButton("Confirmar") { dialog, id ->
//                    viewModel.excluirPorId(dado)
//                }
//                .setNegativeButton("Cancelar") { dialog, i ->
//
//                }
//                .create()
//                .show()
//            true
//        }
    }



    override fun getItemCount(): Int = dados.size

    inner class ViewHolder(binding : FragmentDadoRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        val textNomeDado : TextView = binding.txtNomeDado
        val iconRolarDado : ImageButton = binding.btnRolarDado
        val deletarDado : ImageButton = binding.btnDeletarDado
        val editarDado : ImageButton = binding.btnEditarDado
    }
}