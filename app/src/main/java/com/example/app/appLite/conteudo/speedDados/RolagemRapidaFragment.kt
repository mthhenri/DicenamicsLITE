package com.example.app.appLite.conteudo.speedDados

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.databinding.FragmentRolagemRapidaBinding

class RolagemRapidaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRolagemRapidaBinding.inflate(layoutInflater)

        binding.btnLogoRolagemRapida.setOnClickListener {
            findNavController().navigate(RolagemRapidaFragmentDirections.RolagemToInicial())
        }

        binding.btnMenuRolagemRapida.setOnClickListener {
            findNavController().navigate(RolagemRapidaFragmentDirections.RolagemToMenu())
        }

        binding.btnUsuarioRolagemRapida.setOnClickListener {
            findNavController().navigate(RolagemRapidaFragmentDirections.RolagemToUsuario())
        }

        binding.btnD2.setOnClickListener {

        }

        binding.btnD3.setOnClickListener {

        }

        binding.btnD4.setOnClickListener {

        }

        binding.btnD6.setOnClickListener {

        }

        binding.btnD8.setOnClickListener {

        }

        binding.btnD10.setOnClickListener {

        }

        binding.btnD12.setOnClickListener {

        }

        binding.btnD20.setOnClickListener {

        }

        binding.btnD100.setOnClickListener {

        }



        return binding.root
    }

}