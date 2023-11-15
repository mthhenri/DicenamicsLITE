package com.example.app.data.repository

import com.example.app.data.dao.PastaDao
import com.example.app.data.models.Pasta
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface PastaRepository {

    val pastas: Flow<List<Pasta>>

    suspend fun salvar(pasta: Pasta)

    suspend fun excluirPorId(pastaId: Int)

    suspend fun excluirPorNome(pastaNome: String)

    suspend fun buscarUltimo() : Pasta
}