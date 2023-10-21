package com.example.app.appLite.conteudo.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.appLite.conteudo.inicial.InicialFragmentDirections
import com.example.app.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMenuBinding.inflate(layoutInflater)

        binding.btnLogoMenu.setOnClickListener{
            val action = MenuFragmentDirections.MenuToInicial()
            findNavController().navigate(action)
        }

        binding.btnMenuMenu.setOnClickListener {
            val action = MenuFragmentDirections.ToMenu()
            findNavController().navigate(action)
        }

        binding.btnUsuarioMenu.setOnClickListener {
            val action = MenuFragmentDirections.MenuToUsuario()
            findNavController().navigate(action)
        }

        binding.btnDadosMenu.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.MenuToDados())
        }

        return binding.root
    }
}