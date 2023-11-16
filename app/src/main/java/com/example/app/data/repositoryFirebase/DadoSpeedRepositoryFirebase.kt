package com.example.app.data.repositoryFirebase

import com.example.app.data.models.DadoSpeed
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DadoSpeedRepositoryFirebase @Inject constructor() {

    private val databaseReference: DatabaseReference by lazy {
        Firebase.database.reference.child("dadosSpeed")
    }

    suspend fun salvar(dadoSpeed: DadoSpeed) {
        val key = databaseReference.push().key
        key?.let {
            dadoSpeed.faces = key
            databaseReference.child(key).setValue(dadoSpeed).await()
        }
    }

    suspend fun excluir(dadoFaces: Int) {
        val query = databaseReference.orderByChild("faces").equalTo(dadoFaces.toDouble())
        val snapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            childSnapshot.ref.removeValue().await()
        }
    }
}
