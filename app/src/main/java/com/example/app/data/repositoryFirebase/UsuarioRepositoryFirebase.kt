package com.example.app.data.repositoryFirebase

import com.example.app.data.dao.UsuarioDao
import com.example.app.data.models.Usuario
import com.example.app.data.repository.UsuarioRepository
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

abstract class UsuarioRepositoryFirebase @Inject constructor(private val userRef : CollectionReference) : UsuarioRepository {

    private var _user = MutableStateFlow(listOf<Usuario>())
    override val usuarios: Flow<List<Usuario>> = _user.asStateFlow()

    init {
        userRef.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                var users = mutableListOf<Usuario>()
                snapshot.documents.forEach { doc ->
                    val user = doc.toObject<Usuario>()
                    if (user != null) {
                        user.userId = doc.id.toInt()
                        users.add(user)
                    }
                }
                _user.value = users
            } else {
                _user = MutableStateFlow(listOf())
            }
        }
    }


    override suspend fun salvar(usuario: Usuario) {
        if (usuario.userId.toString().isNullOrEmpty()) {
            var doc = userRef.document()
            usuario.userId = doc.id.toInt()
            doc.set(usuario)
        } else {
            userRef.document(usuario.userId.toString()).set(usuario)
        }
    }

    override suspend fun excluirPorId(usuarioId: Int) {
        userRef.document(usuarioId.toString()).delete()
    }

    override suspend fun excluirPorNome(usuarioNome: String) {
        userRef.document(usuarioNome).delete()
    }

}
