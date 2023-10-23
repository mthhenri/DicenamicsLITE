package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.app.data.models.Pasta
import kotlinx.coroutines.flow.Flow

@Dao
interface PastaDao {

    @Query("SELECT * FROM pastas")
    fun listar() : Flow<List<Pasta>>

    @Query("SELECT * FROM pastas WHERE id = (:id)")
    suspend fun buscarById(id : Int)

    @Query("SELECT * FROM pastas WHERE nome = (:nome)")
    suspend fun buscarByNome(nome : String)

    @Insert
    suspend fun adicionar(pasta: Pasta)

    @Update
    suspend fun atualizar(pasta: Pasta)

    @Query("DELETE FROM pastas WHERE id = (:id)")
    suspend fun deletarById(id : Int)

    @Query("DELETE FROM pastas WHERE nome = (:nome)")
    suspend fun deletarByNome(nome: String)

}