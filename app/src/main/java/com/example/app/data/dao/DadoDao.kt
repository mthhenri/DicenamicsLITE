package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.app.data.models.Dado
import kotlinx.coroutines.flow.Flow

@Dao
interface DadoDao {

    @Query("SELECT * FROM dados")
    fun listar() : Flow<List<Dado>>

    @Query("SELECT * FROM dados WHERE dadoId = (:dadoId)")
    suspend fun buscarById(dadoId : Int) : Dado

    @Query("SELECT * FROM dados WHERE nome = (:nome)")
    suspend fun buscarByNome(nome : String) : Dado

    @Query("SELECT * FROM dados ORDER BY dadoId DESC LIMIT 1")
    suspend fun buscarUltimo() : Dado

    @Insert
    suspend fun adicionar(dado: Dado)

    @Update
    suspend fun atualizar(dado: Dado)

    @Query("DELETE FROM dados WHERE dadoId = (:dadoId)")
    suspend fun deletarById(dadoId : Int)

    @Query("DELETE FROM dados WHERE nome = (:nome)")
    suspend fun deletarByNome(nome: String)

}