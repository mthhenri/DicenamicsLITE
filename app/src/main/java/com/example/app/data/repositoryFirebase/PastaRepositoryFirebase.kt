package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Pasta
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PastaRepositoryFirebase @Inject constructor() {

    private val databaseReference: DatabaseReference by lazy {
        Firebase.database.reference.child("pastas")
    }

    suspend fun salvar(pasta: Pasta) {
        val key = databaseReference.push().key
        key?.let {
            pasta.pastaId = key
            databaseReference.child(key).setValue(pasta).await()
        }
    }

    suspend fun excluirPorId(pastaId: String) {
        databaseReference.child(pastaId).removeValue().await()
    }

    suspend fun excluirPorNome(pastaNome: String) {
        val query: Query = databaseReference.orderByChild("nome").equalTo(pastaNome)
        val snapshot: DataSnapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            childSnapshot.ref.removeValue().await()
        }
    }

    suspend fun buscarUltimo(): Pasta {
        val query: Query = databaseReference.limitToLast(1)
        val snapshot: DataSnapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            return childSnapshot.getValue(Pasta::class.java)!!
        }

        throw NoSuchElementException("Nenhuma pasta encontrada")
    }
}
