package com.example.app.appLite.conteudo.navBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.databinding.FragmentDropdownMenuBinding

class DropdownMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDropdownMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}