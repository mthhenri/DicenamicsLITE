package com.example.app.appLite.ui.pastas

import android.app.AlertDialog
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.app.appLite.ui.dados.DadosFragmentDirections
import com.example.app.data.models.Pasta
import com.example.app.databinding.FragmentDadoRecyclerBinding
import com.example.app.databinding.FragmentPastaRecyclerBinding

class PastasAdapter (
        private var pastas : List<Pasta>,
        val viewModel: PastasViewModel
    ) :
    RecyclerView.Adapter<PastasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPastaRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var pasta = pastas[position]
        holder.nomePasta.text = pasta.nome

        holder.excluirPasta.setOnClickListener { view ->
            AlertDialog.Builder(view.context)
                .setMessage("ATENÇÃO: realmente deseja excluir?")
                .setPositiveButton("Confirmar") { dialog, id ->
                    viewModel.excluirPorId(pasta)
                }
                .setNegativeButton("Cancelar") { dialog, i ->

                }
                .create()
                .show()
            true
        }

        holder.editarPasta.setOnClickListener { view->
            viewModel.editar(pasta)
            val action = PastasFragmentDirections.PastasToCadastroPasta()
            view.findNavController().navigate(action)
        }

        holder.abrirPasta.setOnClickListener { view->
            view.findNavController().navigate(PastasFragmentDirections.PastasToAcessoPastas())
        }

    }

    override fun getItemCount(): Int = pastas.size

    inner class ViewHolder(binding : FragmentPastaRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        val nomePasta : TextView = binding.txtNomePasta
        val abrirPasta : ImageButton = binding.btnAbrirPasta
        val editarPasta : ImageButton = binding.btnEditarPasta
        val excluirPasta : ImageButton = binding.btnExcluirPasta
    }

}