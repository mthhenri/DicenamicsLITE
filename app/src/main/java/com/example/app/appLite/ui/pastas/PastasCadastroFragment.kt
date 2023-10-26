package com.example.app.appLite.ui.pastas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.data.models.Pasta
import com.example.app.databinding.FragmentPastasCadastroBinding
import com.example.app.login.CadastroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PastasCadastroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPastasCadastroBinding.inflate(layoutInflater)
        val viewModel : PastasViewModel by activityViewModels()
        val viewModelUser : CadastroViewModel by activityViewModels()

        val pastaNova = viewModel.pasta

        binding.textNomePastaCriar.setText(pastaNova.nome)
        binding.textCorPastaCriar.setText(pastaNova.cor)

        binding.btnConfirmarCadastrarPasta.setOnClickListener {
            val pastaSalvar = Pasta(
                pastaNova.pastaId,
                binding.textNomePastaCriar.text.toString(),
                binding.textCorPastaCriar.text.toString(),
                viewModelUser.usuario.userId.toLong()
            )

            viewModel.pasta = pastaSalvar
            viewModel.salvar()
            findNavController().popBackStack()
        }

        binding.btnCancelarCadastrarPasta.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnLogoCadastroPasta.setOnClickListener {
            findNavController().navigate(PastasCadastroFragmentDirections.PastaCadastroToInicial())
        }

        binding.btnMenuCadastroPasta.setOnClickListener {
            findNavController().navigate(PastasCadastroFragmentDirections.PastaCadastroToMenu())
        }

        binding.btnUsuarioCadastroPasta.setOnClickListener {
            findNavController().navigate(PastasCadastroFragmentDirections.PastaCadastroToUsuario())
        }

        return binding.root
    }
}