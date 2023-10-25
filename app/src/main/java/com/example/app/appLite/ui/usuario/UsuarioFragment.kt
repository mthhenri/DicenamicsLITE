package com.example.app.appLite.ui.usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentUsuarioBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsuarioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUsuarioBinding.inflate(layoutInflater)
        val viewModel : UsuarioViewModel by activityViewModels()

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