package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Dado
import com.example.app.data.repository.DadoRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

abstract class DadoRepositoryFirebase @Inject constructor(private val dadosRef : CollectionReference) :
    DadoRepository {

    private var _dados = MutableStateFlow(listOf<Dado>())
    override val dados: StateFlow<List<Dado>> = _dados.asStateFlow()

    init {
        dadosRef.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                var dados = mutableListOf<Dado>()
                snapshot.documents.forEach { doc ->
                    val dado = doc.toObject<Dado>()
                    if (dado != null) {
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


    override suspend fun salvar(dado: Dado) {
        if (dado.dadoId.toString().isNullOrEmpty()) {
            var doc = dadosRef.document()
            dado.dadoId = doc.id.toInt()
            doc.set(dado)
        } else {
            dadosRef.document(dado.dadoId.toString()).set(dado)
        }
    }

    override suspend fun excluirPorId(dadoId: Int) {

        dadosRef.document(dadoId.toString()).delete()

    }

     override suspend fun excluirPorNome(nome: String) {

        dadosRef.document(nome).delete()

    }
}