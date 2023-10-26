package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.app.data.models.Dado
import com.example.app.data.models.Pasta
import com.example.app.data.models.PastaDados
import kotlinx.coroutines.flow.Flow

@Dao
interface PastaDao {

    @Query("SELECT * FROM pastas")
    fun listar() : Flow<List<Pasta>>

    @Query("SELECT * FROM pastas WHERE pastaId = (:id)")
    suspend fun buscarById(id : Int) : Pasta

    @Query("SELECT * FROM pastas WHERE nome = (:nome)")
    suspend fun buscarByNome(nome : String) : Pasta

    @Query("SELECT * FROM pastas ORDER BY pastaId DESC LIMIT 1")
    suspend fun buscarUltimo() : Pasta

    @Insert
    suspend fun adicionar(pasta: Pasta)

    @Update
    suspend fun atualizar(pasta: Pasta)

    @Query("DELETE FROM pastas WHERE pastaId = (:id)")
    suspend fun deletarById(id : Int)

    @Query("DELETE FROM pastas WHERE nome = (:nome)")
    suspend fun deletarByNome(nome: String)

    @Insert
    fun inserirPasta(pasta: Pasta)

    @Insert
    fun inserirDados(dados: List<Dado>)

    @Query("SELECT * FROM pastas")
    fun obterPastas(): List<Pasta>

    @Query("SELECT * FROM dados WHERE pastaId = :pastaId")
    fun obterDadosPorPastaId(pastaId: Long): List<Dado>

    @Transaction
    fun obterPastasComDados(): List<PastaDados> {
        val pastas = obterPastas()
        return pastas.map { pasta ->
            PastaDados(pasta, obterDadosPorPastaId(pasta.pastaId))
        }
    }

}