package com.example.app.appLite.conteudo.usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.appLite.conteudo.inicial.InicialFragmentDirections
import com.example.app.databinding.FragmentUsuarioBinding

class UsuarioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUsuarioBinding.inflate(layoutInflater)

        binding.btnLogoUsuario.setOnClickListener{
            val action = UsuarioFragmentDirections.UsuarioToInicial()
            findNavController().navigate(action)
        }

        binding.btnMenuUsuario.setOnClickListener {
            val action = UsuarioFragmentDirections.UsuarioToMenu()
            findNavController().navigate(action)
        }

        binding.btnUsuarioUsuario.setOnClickListener {
            val action = UsuarioFragmentDirections.ToUsuario()
            findNavController().navigate(action)
        }

        binding.btnSalvar.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}