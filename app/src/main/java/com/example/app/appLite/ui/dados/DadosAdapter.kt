package com.example.app.appLite.ui.dados

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.app.data.models.Dado
import com.example.app.data.models.Icons
import com.example.app.databinding.FragmentDadoRecyclerBinding

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
        val dado = dados[position]
        val iconeIcon = Icons.get(dado.icon)
        holder.iconRolarDado.setImageDrawable(iconeIcon.toDrawable())


        holder.itemView.setOnLongClickListener { view ->
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
    }



    override fun getItemCount(): Int = dados.size

    inner class ViewHolder(binding : FragmentDadoRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        val textNomeDado : TextView = binding.txtNomeDado
        val iconRolarDado : ImageButton = binding.btnRolarDado
    }
}