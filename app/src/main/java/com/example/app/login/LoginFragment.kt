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
import com.example.app.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(layoutInflater)
        val viewModel : CadastroViewModel by activityViewModels()

        binding.btnCadastrar.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.LoginToCadastro())
        }

        binding.btnEntrar.setOnClickListener{
            val username = binding.textUsernameLogin.text.toString()
            val senha = binding.textSenhaLogin.text.toString()
            viewModel.login(username, senha)
            viewModel.login(username, senha)

            if (viewModel.usuario.username == username && viewModel.usuario.senha == senha){
                val alertDialog = AlertDialog.Builder(this.context)
                    .setMessage("Bem-vindo ao Dicenamics LITE!")
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
                }, 5000) // 10 segundos em milissegundos
                viewModel.buscarPorUsername(username)
                findNavController().navigate(LoginFragmentDirections.LoginToInicial())
            } else {
                val alertDialog = AlertDialog.Builder(this.context)
                    .setMessage("Username ou Senha incorretos!")
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
                }, 5000) // 10 segundos em milissegundos
            }
        }
        return binding.root
    }
}