package com.example.app.data.repository

import com.example.app.data.dao.PastaDao
import com.example.app.data.models.Pasta
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PastaRepository @Inject
constructor(val pastaDao: PastaDao) {

    val pastas: Flow<List<Pasta>> get() = pastaDao.listar()

    suspend fun salvar(pasta: Pasta) {
        if (pasta.pastaId.toInt() == 0) {
            pastaDao.adicionar(pasta)
        } else {
            pastaDao.atualizar(pasta)
        }
    }

    suspend fun excluirPorId(pastaId: Int) {
        pastaDao.deletarById(pastaId)
    }

    suspend fun excluirPorNome(pastaNome: String) {
        pastaDao.deletarByNome(pastaNome)
    }

    suspend fun buscarUltimo() : Pasta {
        return pastaDao.buscarUltimo()
    }
}