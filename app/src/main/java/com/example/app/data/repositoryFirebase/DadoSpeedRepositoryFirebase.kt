package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Dado
import com.example.app.data.models.DadoSpeed
import com.example.app.data.repository.DadoRepository
import com.example.app.data.repository.DadoSpeedRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DadoSpeedRepositoryFirebase @Inject constructor( private val dadosSpeedRef : CollectionReference ) : DadoSpeedRepository {

    private var _dadosSpeed = MutableStateFlow(listOf<DadoSpeed>())
    override val dadosSpeed: StateFlow<List<DadoSpeed>> = _dadosSpeed.asStateFlow()

    init {
        dadosSpeedRef.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                var dadosSpeed = mutableListOf<DadoSpeed>()
                snapshot.documents.forEach { doc ->
                    val dadoSpeed = doc.toObject<DadoSpeed>()
                    if (dadoSpeed != null) {
                        dadoSpeed.faces = doc.id.toInt()
                        dadosSpeed.add(dadoSpeed)
                    }
                }
                _dadosSpeed.value = dadosSpeed
            } else {
                _dadosSpeed = MutableStateFlow(listOf())
            }
        }
    }

    override suspend fun salvar(dadoSpeed: DadoSpeed) {
        if (dadoSpeed.faces.toString().isNullOrEmpty()) {
            var doc = dadosSpeedRef.document()
            dadoSpeed.faces = doc.id.toInt()
            doc.set(dadoSpeed)
        } else {
            dadosSpeedRef.document(dadoSpeed.faces.toString()).set(dadoSpeed)
        }
    }

    override suspend fun excluir(dadoFaces: Int) {

        dadosSpeedRef.document(dadoFaces.toString()).delete()

    }
}

