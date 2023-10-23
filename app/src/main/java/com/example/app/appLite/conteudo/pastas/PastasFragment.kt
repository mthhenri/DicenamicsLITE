package com.example.app.appLite.conteudo.pastas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.databinding.FragmentPastasBinding

class PastasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPastasBinding.inflate(layoutInflater)

        binding.btnMenuPastas.setOnClickListener {
            findNavController().navigate(PastasFragmentDirections.PastasToMenu())
        }

        binding.btnLogoPastas.setOnClickListener {
            findNavController().navigate(PastasFragmentDirections.PastasToInicial())
        }

        binding.btnUsuarioPastas.setOnClickListener {
            findNavController().navigate(PastasFragmentDirections.PastasToUsuario())
        }

        binding.btnCriarPasta.setOnClickListener {
            findNavController().navigate(PastasFragmentDirections.PastasToCadastroPasta())
        }

        return binding.root
    }
}