package com.example.app.data.repository

import com.example.app.data.dao.DadoDao
import com.example.app.data.models.Dado
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface DadoRepository {

    val dados: Flow<List<Dado>>

    suspend fun salvar(dado: Dado)
    suspend fun excluirPorId(dadoId: Int)

    suspend fun excluirPorNome(dadoNome: String)

    suspend fun buscarUltimo() : Dado
}