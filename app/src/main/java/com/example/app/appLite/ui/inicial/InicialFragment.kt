package com.example.app.appLite.ui.inicial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.appLite.ui.dados.DadosViewModel
import com.example.app.appLite.ui.pastas.PastasViewModel
import com.example.app.data.models.Dado
import com.example.app.databinding.FragmentInicialBinding
import kotlinx.coroutines.Job

class InicialFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInicialBinding.inflate(layoutInflater)
        val viewModelDado : DadosViewModel by activityViewModels()
        val viewModelPasta : PastasViewModel by activityViewModels()

        viewModelDado.buscarUltimo()
        viewModelPasta.buscarultimo()
        binding.textDado.setText("Último dado criado: \n\n${viewModelDado.ultimoDado.nome}")
        binding.textPasta.setText("Última pasta criada: \n\n${viewModelPasta.ultimaPasta.nome}")
        binding.textRolagem.setText("Última rolagem: \n\nNÃO FINALIZADO")

        binding.btnLogoInicial.setOnClickListener{
            val action = InicialFragmentDirections.ToInicial()
            findNavController().navigate(action)
        }

        binding.btnMenuInicial.setOnClickListener {
            val action = InicialFragmentDirections.InicialToMenu()
            findNavController().navigate(action)
        }

        binding.btnUsuarioInicial.setOnClickListener {
            val action = InicialFragmentDirections.InicialToUsuario()
            findNavController().navigate(action)
        }

        return binding.root
    }
}