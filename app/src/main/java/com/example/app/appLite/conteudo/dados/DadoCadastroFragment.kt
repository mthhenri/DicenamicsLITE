package com.example.app.appLite.conteudo.dados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.databinding.FragmentDadoCadastroBinding

class DadoCadastroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDadoCadastroBinding.inflate(layoutInflater)

        binding.btnConfirmarCadastrarDado.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCancelarCadastrarDado.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnLogoDadoCriar.setOnClickListener {
            findNavController().navigate(DadoCadastroFragmentDirections.DadoCriarToInicial())
        }

        binding.btnMenuDadoCriar.setOnClickListener {
            findNavController().navigate(DadoCadastroFragmentDirections.DadoCriarToMenu())
        }

        binding.btnUsuarioDadoCriar.setOnClickListener {
            findNavController().navigate(DadoCadastroFragmentDirections.DadoCriarToUsuario())
        }

        return binding.root
    }

}