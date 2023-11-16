package com.example.app.data.repositoryFirebase

import com.example.app.data.models.DadoSpeed
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DadoSpeedRepositoryFirebase @Inject constructor() {

    private val firestore = FirebaseFirestore.getInstance()
    private val dadosSpeedCollection = firestore.collection("dadosSpeed")

    suspend fun salvar(dadoSpeed: DadoSpeed) {
        if (dadoSpeed.faces != 0) {
            if (dadoSpeed.id.isEmpty()) {
                dadosSpeedCollection.add(dadoSpeed).await()
            } else {
                dadosSpeedCollection.document(dadoSpeed.id).set(dadoSpeed).await()
            }
        }
    }

    suspend fun excluir(dadoFaces: Int) {
        val query = dadosSpeedCollection.whereEqualTo("faces", dadoFaces)
        query.get().addOnSuccessListener { documents ->
            for (document in documents) {
                document.reference.delete()
            }
        }.await()
    }

    suspend fun buscarPorId(id: String): DadoSpeed? {
        val document = dadosSpeedCollection.document(id).get().await()
        return document.toObject(DadoSpeed::class.java)
    }
}