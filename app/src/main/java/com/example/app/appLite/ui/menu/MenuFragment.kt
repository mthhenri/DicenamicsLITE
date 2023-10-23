package com.example.app.appLite.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMenuBinding.inflate(layoutInflater)

        binding.btnLogoMenu.setOnClickListener{
            findNavController().navigate(MenuFragmentDirections.MenuToInicial())
        }

        binding.btnMenuMenu.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.ToMenu())
        }

        binding.btnUsuarioMenu.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.MenuToUsuario())
        }

        binding.btnDadosMenu.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.MenuToDados())
        }

        binding.btnRollRapidaMenu.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.MenuToRolagemRapida())
        }

        binding.btnPastasMenu.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.MenuToPastas())
        }

        return binding.root
    }
}