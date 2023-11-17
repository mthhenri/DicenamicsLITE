package com.example.app.data.repositoryFirebase

import com.example.app.data.models.DadoSpeed
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DadoSpeedRepositoryFirebase @Inject constructor() {

    init {
        dados.addSnapshotListener{ snapshot, _ ->
            if(snapshot != null){
                var dados = mutableListOf<Dado>()
                snapshot.documents.forEach{ doc ->
                    val dado = doc.toObject<Dado>()
                    if(dado != null){
                        dado.dadoId = doc.id.toInt()
                        dados.add(dado)
                    }
                }
                _dados.value = dados
            } else {
                _dados = MutableStateFlow(listOf())
            }
        }
    }

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
