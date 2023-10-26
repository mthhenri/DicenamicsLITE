package com.example.app.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.models.Dado
import com.example.app.data.models.Usuario
import com.example.app.data.repository.DadoRepository
import com.example.app.data.repository.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CadastroViewModel @Inject constructor(val repository: UsuarioRepository) : ViewModel() {

    var usuario : Usuario = Usuario()

    private var _usuarios = MutableStateFlow(listOf<Usuario>())
    val usuarios : Flow<List<Usuario>> = _usuarios

    init {
        viewModelScope.launch {
            repository.usuarios.collect {usuarios ->
                _usuarios.value = usuarios
            }
        }
    }

    fun novo(){
        this.usuario = Usuario()
    }

    fun editar(usuario: Usuario){
        this.usuario = usuario
    }

    fun salvar() = viewModelScope.launch{
        repository.salvar(usuario)
    }

    fun excluirPorId(usuario: Usuario) = viewModelScope.launch{
        repository.excluirPorId(usuario.userId)
    }

    fun buscarPorUsername(user: String) = viewModelScope.launch{
        val result = repository.buscarPorUsername(user)
        if(result != null){
            usuario = result
        }
    }

    fun  login(username : String, senha : String) = viewModelScope.launch{
        val user = repository.login(username, senha)
        if (user != null) {
            usuario.username = user.username
            usuario.senha = user.senha
        }
    }

}