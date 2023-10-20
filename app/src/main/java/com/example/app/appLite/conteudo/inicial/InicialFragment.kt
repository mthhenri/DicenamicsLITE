package com.example.app.appLite.conteudo.inicial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentInicialBinding

class InicialFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInicialBinding.inflate(layoutInflater)

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