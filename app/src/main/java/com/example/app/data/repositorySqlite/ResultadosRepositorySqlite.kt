package com.example.app.data.repositorySqlite

import com.example.app.data.dao.ResultadosDao
import com.example.app.data.models.Resultados
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ResultadosRepositorySqlite @Inject constructor(val resultadosDao: ResultadosDao) {

    val resultados : Flow<List<Resultados>> get() = resultadosDao.listar()

    suspend fun salvar(resultados: Resultados) {
        if (resultados.resultId == 0){
            resultadosDao.adicionar(resultados)
        } else {
            resultadosDao.atualizar(resultados)
        }
    }

    suspend fun excluirPorId(resultadosId: Int){
        resultadosDao.deletar(resultadosId)
    }

}