package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Dado
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DadoRepositoryFirebase @Inject constructor() {

    private val databaseReference: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.child("dados")
    }

    suspend fun salvar(dado: Dado) {
        val key = databaseReference.push().key
        key?.let {
            dado.dadoId = key
            databaseReference.child(key).setValue(dado).await()
        }
    }

    suspend fun excluirPorId(dadoId: String) {
        databaseReference.child(dadoId).removeValue().await()
    }

    suspend fun excluirPorNome(dadoNome: String) {
        val query: Query = databaseReference.orderByChild("nome").equalTo(dadoNome)
        val snapshot: DataSnapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            childSnapshot.ref.removeValue().await()
        }
    }

    suspend fun buscarUltimo(): Dado {
        val query: Query = databaseReference.limitToLast(1)
        val snapshot: DataSnapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            return childSnapshot.getValue(Dado::class.java)!!
        }
        throw NoSuchElementException("Nenhum dado encontrado")
    }
}