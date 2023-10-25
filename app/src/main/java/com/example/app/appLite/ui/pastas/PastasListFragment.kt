package com.example.app.appLite.ui.pastas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.FragmentPastaListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PastasListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: PastasViewModel by activityViewModels()
        val binding = FragmentPastaListBinding.inflate(layoutInflater)
        val recyclerView = binding.root

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pastas.collect { pastas ->
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = PastasAdapter(pastas, viewModel)
                }
            }
        }

        return binding.root
    }
}