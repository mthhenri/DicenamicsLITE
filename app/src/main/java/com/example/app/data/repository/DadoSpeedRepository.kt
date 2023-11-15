package com.example.app.data.repository

import com.example.app.data.dao.DadoDao
import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.models.Dado
import com.example.app.data.models.DadoSpeed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface DadoSpeedRepository  {

    val dadosSpeed: Flow<List<DadoSpeed>>

    suspend fun salvar(dadoSpeed: DadoSpeed)

    suspend fun excluir(dadoFaces: Int)
}