package com.example.app.appLite.ui.dados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.data.database.BancoSQLite
import com.example.app.databinding.FragmentDadosBinding
import com.example.app.databinding.FragmentDadosListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DadosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDadosBinding.inflate(layoutInflater)
        val viewModel: DadosViewModel by activityViewModels()
        val recyclerView = binding.recycleViewDados

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dados.collect { dados ->
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = DadosAdapter(dados, viewModel)
                }
            }
        }


        binding.btnLogoDados.setOnClickListener {
            findNavController().navigate(DadosFragmentDirections.DadosToInicial())
        }

        binding.btnMenuDados.setOnClickListener {
            findNavController().navigate(DadosFragmentDirections.DadosToMenu())
        }

        binding.btnUsuarioDados.setOnClickListener {
            findNavController().navigate(DadosFragmentDirections.DadosToMenu())
        }

        binding.btnCriarDado.setOnClickListener{
            viewModel.novo()
            findNavController().navigate(DadosFragmentDirections.DadosToDadoCriar())
        }

        return binding.root
    }
}