package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Resultados
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ResultadosRepositoryFirebase @Inject constructor() {

    init {
        dadosRef.addSnapshotListener{ snapshot, _ ->
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
        Firebase.database.reference.child("resultados")
    }

    suspend fun salvar(resultados: Resultados) {
        val key = databaseReference.push().key
        key?.let {
            resultados.resultId = key
            databaseReference.child(key).setValue(resultados).await()
        }
    }

    suspend fun excluirPorId(resultadosId: String) {
        databaseReference.child(resultadosId).removeValue().await()
    }
}
