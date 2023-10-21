package com.example.app.appLite.conteudo.pastas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R

class PastasCadastroFragment : Fragment() {

    companion object {
        fun newInstance() = PastasCadastroFragment()
    }

    private lateinit var viewModel: PastasCadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pastas_cadastro, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PastasCadastroViewModel::class.java)
        // TODO: Use the ViewModel
    }

}