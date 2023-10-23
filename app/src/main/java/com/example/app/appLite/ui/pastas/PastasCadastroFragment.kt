package com.example.app.appLite.ui.pastas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentPastasCadastroBinding

class PastasCadastroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPastasCadastroBinding.inflate(layoutInflater)

        binding.btnLogoCadastroPasta.setOnClickListener {
            findNavController().navigate(PastasCadastroFragmentDirections.PastaCadastroToInicial())
        }

        binding.btnMenuCadastroPasta.setOnClickListener {
            findNavController().navigate(PastasCadastroFragmentDirections.PastaCadastroToMenu())
        }

        binding.btnUsuarioCadastroPasta.setOnClickListener {
            findNavController().navigate(PastasCadastroFragmentDirections.PastaCadastroToUsuario())
        }

        binding.btnCancelarCadastrarPasta.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnConfirmarCadastrarPasta.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}