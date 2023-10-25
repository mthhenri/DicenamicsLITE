package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.app.data.models.Resultados
import com.example.app.data.models.ResultadosValores
import com.example.app.data.models.Valores
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultadosDao {

    @Query("SELECT * FROM resultados")
    fun listar() : Flow<List<Resultados>>

    @Query("SELECT * FROM resultados WHERE resultId = (:id)")
    suspend fun buscar(id : Int) : Resultados

    @Query("SELECT * FROM resultados ORDER BY resultId DESC LIMIT 1")
    suspend fun buscarUltimo() : Resultados

    @Insert
    suspend fun adicionar(resultados: Resultados)

    @Update
    suspend fun atualizar(resultados: Resultados)

    @Query("DELETE FROM resultados WHERE resultId = (:id)")
    suspend fun deletar(id : Int)

    @Insert
    fun inserirResultados(resultados: Resultados)

    @Insert
    fun inserirResultadosValores(valores: List<Valores>)

    @Transaction
    @Query("SELECT * FROM resultados")
    fun obterResultadosComValores(): List<ResultadosValores>
}