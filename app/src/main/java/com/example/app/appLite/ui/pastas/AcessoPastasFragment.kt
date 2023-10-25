package com.example.app.appLite.ui.pastas

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.data.models.Pasta
import com.example.app.databinding.FragmentAcessoPastasBinding
import com.example.app.databinding.FragmentPastasBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AcessoPastasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAcessoPastasBinding.inflate(layoutInflater)
        val viewModel : PastasViewModel by activityViewModels()

        binding.textNomePasta.setText(viewModel.pasta.nome)
        binding.acessoPastaLayout.setBackgroundColor(Color.parseColor(viewModel.pasta.cor))

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