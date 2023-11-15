package com.example.app.data.repository

import com.example.app.data.dao.UsuarioDao
import com.example.app.data.models.Usuario
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

 interface UsuarioRepository {

    val usuarios: Flow<List<Usuario>>

    suspend fun salvar(usuario: Usuario)

    suspend fun excluirPorId(usuarioId: Int)

    suspend fun excluirPorNome(usuarioNome: String)

    suspend fun  buscarPorUsername(usuarioNome : String) : Usuario?

    suspend fun  login(username : String, senha : String) : Usuario?
}