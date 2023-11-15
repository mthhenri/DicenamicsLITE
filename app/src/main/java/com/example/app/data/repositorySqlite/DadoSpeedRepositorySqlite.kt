package com.example.app.data.repositorySqlite

import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.models.DadoSpeed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DadoSpeedRepositorySqlite @Inject constructor(val dadoSpeedDao: DadoSpeedDao) {

    val dadosSpeed: Flow<List<DadoSpeed>> get() = dadoSpeedDao.listar()

    suspend fun salvar(dadoSpeed: DadoSpeed) {
        if (dadoSpeed.faces != 0){
            dadoSpeedDao.adicionar(dadoSpeed)
        } else {
            dadoSpeedDao.atualizar(dadoSpeed)
        }
    }

    suspend fun excluir(dadoFaces: Int){
        dadoSpeedDao.deletar(dadoFaces)
    }
}