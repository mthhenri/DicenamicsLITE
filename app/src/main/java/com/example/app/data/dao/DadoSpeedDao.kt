package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.app.data.models.DadoSpeed
import kotlinx.coroutines.flow.Flow

@Dao
interface DadoSpeedDao {

    @Query("SELECT * FROM dadosSpeed")
    fun listar() : Flow<List<DadoSpeed>>

    @Query("SELECT * FROM dadosSpeed WHERE faces = (:faces)")
    suspend fun buscar(faces : Int) : DadoSpeed

    @Insert
    suspend fun adicionar(dadoSpeed: DadoSpeed)

    @Update
    suspend fun atualizar(dadoSpeed: DadoSpeed)

    @Query("DELETE FROM dadosSpeed WHERE faces = (:faces)")
    suspend fun deletar(faces : Int)

}