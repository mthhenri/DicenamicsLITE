package com.example.app.data.repositorySqlite

import com.example.app.data.dao.DadoDao
import com.example.app.data.models.Dado
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DadoRepositorySqlite @Inject constructor(val dadoDao: DadoDao){

    val dados: Flow<List<Dado>> get() = dadoDao.listar()

    suspend fun salvar(dado: Dado) {
        if (dado.dadoId == 0){
            dadoDao.adicionar(dado)
        } else {
            dadoDao.atualizar(dado)
        }
    }

    suspend fun excluirPorId(dadoId: Int){
        dadoDao.deletarById(dadoId)
    }

    suspend fun excluirPorNome(dadoNome: String){
        dadoDao.deletarByNome(dadoNome)
    }

    suspend fun buscarUltimo() : Dado {
        return dadoDao.buscarUltimo()
    }
}