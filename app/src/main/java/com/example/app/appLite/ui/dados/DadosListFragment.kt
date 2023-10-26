package com.example.app.appLite.ui.dados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.FragmentDadosListBinding
import com.example.app.login.CadastroViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DadosListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: DadosViewModel by activityViewModels()
        val viewModelUser : CadastroViewModel by activityViewModels()
        val binding = FragmentDadosListBinding.inflate(layoutInflater)
        val recyclerView = binding.root

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dados.collect { dados ->
                    val userId = viewModelUser.usuario.userId.toInt()
                    val dadosFiltrados = dados.filter { it.usuarioDadosId.toInt() == userId }
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = DadosAdapter(dadosFiltrados, viewModel)
                }
            }
        }

        return binding.root
    }
}