package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.app.data.models.Resultados
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultadosDao {

    @Query("SELECT * FROM resultados")
    fun listar() : Flow<List<Resultados>>

    @Query("SELECT * FROM resultados WHERE id = (:id)")
    suspend fun buscar(id : Int)

    @Query("SELECT * FROM resultados ORDER BY id DESC LIMIT 1")
    suspend fun buscarUltimo()

    @Insert
    suspend fun adicionar(resultados: Resultados)

    @Update
    suspend fun atualizar(resultados: Resultados)

    @Query("DELETE FROM resultados WHERE id = (:id)")
    suspend fun deletar(id : Int)
}