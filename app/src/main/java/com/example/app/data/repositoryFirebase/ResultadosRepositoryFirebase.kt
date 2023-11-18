package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Resultados
import com.example.app.data.repository.ResultadosRepository
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

abstract class ResultadosRepositoryFirebase @Inject constructor(private val resulsRef : CollectionReference) : ResultadosRepository {

    private var _resuls = MutableStateFlow(listOf<Resultados>())
    override val resultados: StateFlow<List<Resultados>> = _resuls.asStateFlow()
    init {
        resulsRef.addSnapshotListener{ snapshot, _ ->
            if(snapshot != null){
                var resuls = mutableListOf<Resultados>()
                snapshot.documents.forEach{ doc ->
                    val resul = doc.toObject<Resultados>()
                    if(resul != null){
                        resul.resultId = doc.id.toInt()
                        resuls.add(resul)
                    }
                }
                _resuls.value = resuls
            } else {
                _resuls = MutableStateFlow(listOf())
            }
        }
    }

    override suspend fun salvar(resultados: Resultados) {
        if(resultados.resultId.toString().isNullOrEmpty()){
            var doc = resulsRef.document()
            resultados.resultId = doc.id.toInt()
            doc.set(resultados)
        } else {
            resulsRef.document(resultados.resultId.toString()).set(resultados)
        }
    }

    override suspend fun excluirPorId(resultadosId: Int) {
        resulsRef.document(resultadosId.toString()).delete()
    }
}
