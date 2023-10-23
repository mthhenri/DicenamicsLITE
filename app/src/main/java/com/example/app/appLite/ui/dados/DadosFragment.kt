package com.example.app.appLite.ui.dados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentDadosBinding

class DadosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDadosBinding.inflate(layoutInflater)

        binding.btnLogoDados.setOnClickListener {
            findNavController().navigate(DadosFragmentDirections.DadosToInicial())
        }

        binding.btnMenuDados.setOnClickListener {
            findNavController().navigate(DadosFragmentDirections.DadosToMenu())
        }

        binding.btnUsuarioDados.setOnClickListener {
            findNavController().navigate(DadosFragmentDirections.DadosToMenu())
        }

        binding.btnCriarDado.setOnClickListener{
            findNavController().navigate(DadosFragmentDirections.DadosToDadoCriar())
        }

        return binding.root
    }
}