package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Dado
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DadoRepositoryFirebase @Inject constructor() {

    private val firestore = FirebaseFirestore.getInstance()
    private val dadosCollection = firestore.collection("dados")

    suspend fun salvar(dado: Dado) {
        dadosCollection.add(dado).await()
    }

    suspend fun atualizar(dado: Dado) {
        val documento = dadosCollection.document(dado.dadoId.toString())
        documento.set(dado).await()
    }

    suspend fun excluirPorId(dadoId: Int) {
        dadosCollection.document(dadoId.toString()).delete().await()
    }

    suspend fun excluirPorNome(dadoNome: String) {
        val query = dadosCollection.whereEqualTo("nome", dadoNome)
        val await = query.get().addOnSuccessListener { documents ->
            for (document in documents) {
                document.reference.delete()
            }
        }.await()
    }

    suspend fun buscarUltimo(): Dado? {
        val query = dadosCollection.orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1)
        val result = query.get().await()
        return result.toObjects(Dado::class.java).firstOrNull()
    }

    fun listarDados(): Flow<List<Dado>> {
        return dadosCollection.addSnapshotListener { value, error ->
            if (error != null) {
            } else {
                val dados = value?.toObjects(Dado::class.java) ?: emptyList()
            }
        }
    }
}