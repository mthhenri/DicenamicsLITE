package com.example.app.data.repository

import com.example.app.data.dao.ResultadosDao
import com.example.app.data.models.Resultados
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ResultadosRepository {

    val resultados : Flow<List<Resultados>>

    suspend fun salvar(resultados: Resultados)

    suspend fun excluirPorId(resultadosId: Int)

}