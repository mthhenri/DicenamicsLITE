package com.example.app.appLite.ui.pastas

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.appLite.back.pastaDados.DadosPastaAdapter
import com.example.app.appLite.ui.dados.DadosAdapter
import com.example.app.appLite.ui.dados.DadosViewModel
import com.example.app.data.models.Pasta
import com.example.app.databinding.FragmentAcessoPastasBinding
import com.example.app.databinding.FragmentPastasBinding
import com.example.app.login.CadastroViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AcessoPastasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAcessoPastasBinding.inflate(layoutInflater)
        val viewModelPasta : PastasViewModel by activityViewModels()
        val viewModelDados : DadosViewModel by activityViewModels()
        val viewModelUser : CadastroViewModel by activityViewModels()
        val recyclerView = binding.recycleViewDadosPastas

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModelDados.dados.collect { dados ->
                    val pastaIdDesejado = viewModelPasta.pasta.pastaId.toInt()
                    val userId = viewModelUser.usuario.userId
                    val dadosFiltrados = dados.filter { it.usuarioDadosId.toInt() == userId }
                    val dadosFiltradosFinal = dadosFiltrados.filter { it.pastaId == pastaIdDesejado }
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = DadosPastaAdapter(dadosFiltradosFinal, viewModelDados)
                }
            }
        }

        binding.textNomePasta.setText(viewModelPasta.pasta.nome)
        binding.acessoPastaLayout.setBackgroundColor(Color.parseColor(viewModelPasta.pasta.cor))

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
            viewModelDados.novo()
            viewModelDados.dado.pastaId = viewModelPasta.pasta.pastaId.toInt()
            findNavController().navigate(AcessoPastasFragmentDirections.AcessoPastaToAddDadoPasta())
        }

        return binding.root
    }
}