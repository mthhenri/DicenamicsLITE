package com.example.app.appLite.conteudo.pastas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.databinding.FragmentAcessoPastasBinding

class AcessoPastasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAcessoPastasBinding.inflate(layoutInflater)

        binding.btnLogoAcessoPastas.setOnClickListener {
            findNavController().navigate(AcessoPastasFragmentDirections.AcessoPastaToInicial())
        }

        binding.btnMenuAcessoPastas.setOnClickListener {
            findNavController().navigate(AcessoPastasFragmentDirections.AcessoPastaToMenu())
        }

        binding.btnUsuarioAcessoPastas.setOnClickListener {
            findNavController().navigate(AcessoPastasFragmentDirections.AcessoPastaToUsuario())
        }

        binding.btnCriarDadoPasta.setOnClickListener{
            findNavController().navigate(AcessoPastasFragmentDirections.AcessoPastaToAddDadoPasta())
        }

        return binding.root
    }
}