package com.example.app.appLite.ui.dados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.data.models.Dado
import com.example.app.databinding.FragmentDadoCadastroBinding
import com.example.app.login.CadastroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DadoCadastroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDadoCadastroBinding.inflate(layoutInflater)
        val viewModel : DadosViewModel by activityViewModels()
        val viewModelUser : CadastroViewModel by activityViewModels()

        val dadoNovo = viewModel.dado

        binding.dadoCadastroSpinner
        binding.textNomeDadoCriar.setText(dadoNovo.nome)
        binding.textFacesDadoCriar.setText(dadoNovo.faces.toString())
        binding.textQuantidadeDadoCriar.setText(dadoNovo.quantidade.toString())
        binding.textModificadorDadoCriar.setText(dadoNovo.modificador)

        binding.btnConfirmarCadastrarDado.setOnClickListener {
            val dadoSalvar = Dado(
                dadoNovo.dadoId,
                binding.textIconDadoCriar.text.toString(),
                binding.textNomeDadoCriar.text.toString(),
                binding.textFacesDadoCriar.text.toString().toInt(),
                binding.textQuantidadeDadoCriar.text.toString().toInt(),
                binding.textModificadorDadoCriar.text.toString(),
                dadoNovo.pastaId.toInt(),
                viewModelUser.usuario.userId.toLong()
            )
            viewModel.dado = dadoSalvar
            viewModel.salvar()
            findNavController().popBackStack()
        }

        binding.btnCancelarCadastrarDado.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnLogoDadoCriar.setOnClickListener {
            findNavController().navigate(DadoCadastroFragmentDirections.DadoCriarToInicial())
        }

        binding.btnMenuDadoCriar.setOnClickListener {
            findNavController().navigate(DadoCadastroFragmentDirections.DadoCriarToMenu())
        }

        binding.btnUsuarioDadoCriar.setOnClickListener {
            findNavController().navigate(DadoCadastroFragmentDirections.DadoCriarToUsuario())
        }

        return binding.root
    }

}