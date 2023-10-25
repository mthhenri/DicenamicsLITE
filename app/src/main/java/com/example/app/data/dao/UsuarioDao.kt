package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.app.data.models.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuarios")
    fun listar() : Flow<List<Usuario>>

    @Query("SELECT * FROM usuarios WHERE userId = (:id)")
    suspend fun buscarById(id : Int) : Usuario

    @Query("SELECT * FROM usuarios WHERE username = (:username)")
    suspend fun buscarByUsername(username : String) : Usuario

    @Insert
    suspend fun adicionar(usuario: Usuario)

    @Update
    suspend fun atualizar(usuario: Usuario)

    @Query("DELETE FROM usuarios WHERE userId = (:id)")
    suspend fun deletarById(id : Int)

    @Query("DELETE FROM usuarios WHERE username = (:username)")
    suspend fun deletarByUsername(username: String)

}