package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Pasta
import com.example.app.data.repository.PastaRepository
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

abstract class PastaRepositoryFirebase @Inject constructor(private val pastasRef : CollectionReference) : PastaRepository {

    private var _pastas = MutableStateFlow(listOf<Pasta>())
    override val pastas: StateFlow<List<Pasta>> = _pastas.asStateFlow()

    init {
        pastasRef.addSnapshotListener{ snapshot, _ ->
            if(snapshot != null){
                var pastas = mutableListOf<Pasta>()
                snapshot.documents.forEach{ doc ->
                    val pasta = doc.toObject<Pasta>()
                    if(pasta != null){
                        pasta.pastaId = doc.id.toInt().toLong()
                        pastas.add(pasta)
                    }
                }
                _pastas.value = pastas
            } else {
                _pastas = MutableStateFlow(listOf())
            }
        }
    }


    override suspend fun salvar(pasta: Pasta) {
        if(pasta.pastaId.toString().isNullOrEmpty()) {
            var doc = pastasRef.document()
            pasta.pastaId = doc.id.toLong()
            doc.set(pasta)
        } else {
            pastasRef.document(pasta.pastaId.toString()).set(pasta)
        }
    }

     override suspend fun excluirPorId(pastaId: Int) {
        pastasRef.document(pastaId.toString()).delete()
    }

    override suspend fun excluirPorNome(pastaNome: String) {
        pastasRef.document(pastaNome).delete()
    }
}
