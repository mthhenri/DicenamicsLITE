package com.example.app.appLite.ui.speedDados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.data.models.Dado
import com.example.app.data.models.DadoSpeed
import com.example.app.data.models.Icons
import com.example.app.databinding.FragmentRolagemRapidaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RolagemRapidaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRolagemRapidaBinding.inflate(layoutInflater)
        val viewModel: RolagemRapidaViewModel by activityViewModels()

        val D100 : DadoSpeed = DadoSpeed(100)
        val D20 : DadoSpeed = DadoSpeed(20)
        val D12 : DadoSpeed = DadoSpeed(12)
        val D10 : DadoSpeed = DadoSpeed(10)
        val D8 : DadoSpeed = DadoSpeed(8)
        val D6 : DadoSpeed = DadoSpeed(6)
        val D4 : DadoSpeed = DadoSpeed(4)
        val D3 : DadoSpeed = DadoSpeed(3)
        val D2 : DadoSpeed = DadoSpeed(2)

        binding.btnLogoRolagemRapida.setOnClickListener {
            findNavController().navigate(RolagemRapidaFragmentDirections.RolagemToInicial())
        }

        binding.btnMenuRolagemRapida.setOnClickListener {
            findNavController().navigate(RolagemRapidaFragmentDirections.RolagemToMenu())
        }

        binding.btnUsuarioRolagemRapida.setOnClickListener {
            findNavController().navigate(RolagemRapidaFragmentDirections.RolagemToUsuario())
        }

        binding.btnD2.setOnClickListener {
            val resultado = D2.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D2"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 19"))
        }

        binding.btnD3.setOnClickListener {
            val resultado = D3.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D3"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 19"))
        }

        binding.btnD4.setOnClickListener {
            val resultado = D4.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D4"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 20"))
        }

        binding.btnD6.setOnClickListener {
            val resultado = D6.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D6"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 19"))
        }

        binding.btnD8.setOnClickListener {
            val resultado = D8.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D8"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 18"))
        }

        binding.btnD10.setOnClickListener {
            val resultado = D10.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D10"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 17"))
        }

        binding.btnD12.setOnClickListener {
            val resultado = D12.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D12"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 16"))
        }

        binding.btnD20.setOnClickListener {
            val resultado = D20.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D20"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 15"))
        }

        binding.btnD100.setOnClickListener {
            val resultado = D100.rolarDado()
            binding.textResultado.text = resultado.toString()
            binding.textDadoRolado.text = "D100"
            binding.dadoResultado.setImageResource(Icons.Companion.get("dados icone 14"))
        }



        return binding.root
    }

}