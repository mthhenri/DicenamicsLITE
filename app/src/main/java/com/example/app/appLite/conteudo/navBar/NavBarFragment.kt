package com.example.app.appLite.conteudo.navBar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.appLite.AppLiteFragmentDirections
import com.example.app.appLite.AppLiteViewModel
import com.example.app.databinding.FragmentAppLiteBinding
import com.example.app.databinding.FragmentDropdownMenuBinding
import com.example.app.databinding.FragmentNavBarBinding

class NavBarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNavBarBinding.inflate(layoutInflater)

        binding.btnMenu.setOnClickListener{
            //Usar Fragment Transaction?
        }

        binding.btnLogo.setOnClickListener{
            val action = AppLiteFragmentDirections.InitialToInitial()
            findNavController().navigate(action)
        }

        binding.btnUsuario.setOnClickListener{

        }

        return binding.root
    }
}
