package com.example.app.appLite.ui.usuario

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.data.models.Usuario
import com.example.app.databinding.FragmentUsuarioBinding
import com.example.app.login.CadastroViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException


@AndroidEntryPoint
class UsuarioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUsuarioBinding.inflate(layoutInflater)
        val viewModel : CadastroViewModel by activityViewModels()

        val resourceId = resources.getIdentifier(viewModel.usuario.imgPerfil, "drawable", requireContext().packageName)
        if(resourceId != 0){
            binding.imgUser.setImageResource(resourceId)
        }

        binding.textApelidoAntigo.setText(viewModel.usuario.apelido)
        binding.textUserAntigo.setText(viewModel.usuario.username)
        binding.textSenhaAntiga.setText(viewModel.usuario.senha)

        binding.btnImagemBuscar.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle("Em desenvolvimento")
                .setMessage("Desculpe, esta funcionalidade ainda está em desenvolvimento.")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()

        }

        binding.btnLogoUsuario.setOnClickListener{
            val action = UsuarioFragmentDirections.UsuarioToInicial()
            findNavController().navigate(action)
        }

        binding.btnMenuUsuario.setOnClickListener {
            val action = UsuarioFragmentDirections.UsuarioToMenu()
            findNavController().navigate(action)
        }

        binding.btnUsuarioUsuario.setOnClickListener {
            val action = UsuarioFragmentDirections.ToUsuario()
            findNavController().navigate(action)
        }

        binding.btnSalvar.setOnClickListener {
            viewModel.buscarPorUsername(binding.textUserNovo.text.toString())
            viewModel.buscarPorUsername(binding.textUserNovo.text.toString())
            if (viewModel.usuario.username == "" || viewModel.usuario.username != binding.textUserNovo.text.toString()){
                viewModel.usuario.username = binding.textUserNovo.text.toString()
                viewModel.usuario.apelido = binding.textApelidoNovo.text.toString()
                viewModel.usuario.senha = binding.textSenhaNova.text.toString()
                viewModel.salvar()
                findNavController().popBackStack()
            } else {
                val alertDialog = AlertDialog.Builder(this.context)
                    .setMessage("Este username já está em uso!")
                    .setCancelable(false) // Impede que o usuário feche manualmente
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                    })
                    .create()
                alertDialog.show()

                // Crie um Handler para fechar o AlertDialog após 10 segundos
                val handler = Handler()
                handler.postDelayed({
                    alertDialog.dismiss()
                }, 7000) // 10 segundos em milissegundos
            }
        }

        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}