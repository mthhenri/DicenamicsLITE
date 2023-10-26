package com.example.app.login

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.data.models.Usuario
import com.example.app.databinding.FragmentCadastroBinding
import com.example.app.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CadastroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCadastroBinding.inflate(layoutInflater)
        val viewModel : CadastroViewModel by activityViewModels()

        var usuarioNovo = viewModel.usuario

        binding.btnCadastrarCadastro.setOnClickListener{
            if(binding.textUsernameCadastro.text.toString().isEmpty() || binding.textApelidoCadastro.text.toString().isEmpty() || binding.textSenhaCadastro.text.toString().isEmpty()){
                AlertDialog.Builder(context)
                    .setMessage("Campos em branco!.")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            } else {
                val usuarioSalvar = Usuario(
                    usuarioNovo.userId,
                    binding.textUsernameCadastro.text.toString(),
                    binding.textApelidoCadastro.text.toString(),
                    binding.textSenhaCadastro.text.toString(),
                    "sem_foto.png"
                )
                viewModel.buscarPorUsername(usuarioSalvar.username)
                viewModel.buscarPorUsername(usuarioSalvar.username)
                if (viewModel.usuario.username == ""){
                    viewModel.usuario = usuarioSalvar
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
        }
        return binding.root
    }

}