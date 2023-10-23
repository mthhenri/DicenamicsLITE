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

    @Query("SELECT * FROM dados WHERE id = (:id)")
    suspend fun buscarById(id : Int)

    @Query("SELECT * FROM dados WHERE nome = (:nome)")
    suspend fun buscarByNome(nome : String)

    @Insert
    suspend fun adicionar(dado: Dado)

    @Update
    suspend fun atualizar(dado: Dado)

    @Query("DELETE FROM dados WHERE id = (:id)")
    suspend fun deletarById(id : Int)

    @Query("DELETE FROM dados WHERE nome = (:nome)")
    suspend fun deletarByNome(nome: String)

}