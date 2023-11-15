package com.example.app.data.repositorySqlite

import com.example.app.data.dao.UsuarioDao
import com.example.app.data.models.Usuario
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsuarioRepositorySqlite @Inject constructor(val usuarioDao: UsuarioDao) {

    val usuarios: Flow<List<Usuario>> get() = usuarioDao.listar()

    suspend fun salvar(usuario: Usuario) {
        if (usuario.userId == 0) {
            usuarioDao.adicionar(usuario)
        } else {
            usuarioDao.atualizar(usuario)
        }
    }

    suspend fun excluirPorId(usuarioId: Int) {
        usuarioDao.deletarById(usuarioId)
    }

    suspend fun excluirPorNome(usuarioNome: String) {
        usuarioDao.deletarByUsername(usuarioNome)
    }

    suspend fun  buscarPorUsername(usuarioNome : String) : Usuario? {
        return usuarioDao.buscarByUsername(usuarioNome)
    }

    suspend fun  login(username : String, senha : String) : Usuario? {
        return usuarioDao.login(username, senha)
    }
}