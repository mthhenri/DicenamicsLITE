package com.example.app.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.databinding.FragmentCadastroBinding
import com.example.app.databinding.FragmentLoginBinding

class CadastroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCadastroBinding.inflate(layoutInflater)

        binding.btnCadastrarCadastro.setOnClickListener{
            findNavController().popBackStack()
        }
        return binding.root
    }

}