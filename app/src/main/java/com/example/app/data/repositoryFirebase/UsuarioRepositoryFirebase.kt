package com.example.app.data.repositoryFirebase

import com.example.app.data.models.Usuario
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsuarioRepositoryFirebase @Inject constructor() {

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
        Firebase.database.reference.child("usuarios")
    }

    suspend fun salvar(usuario: Usuario) {
        val key = databaseReference.push().key
        key?.let {
            usuario.userId = key
            databaseReference.child(key).setValue(usuario).await()
        }
    }

    suspend fun excluirPorId(usuarioId: String) {
        databaseReference.child(usuarioId).removeValue().await()
    }

    suspend fun excluirPorNome(usuarioNome: String) {
        val query: Query = databaseReference.orderByChild("nome").equalTo(usuarioNome)
        val snapshot: DataSnapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            childSnapshot.ref.removeValue().await()
        }
    }

    suspend fun buscarPorUsername(usuarioNome: String): Usuario? {
        val query: Query = databaseReference.orderByChild("username").equalTo(usuarioNome)
        val snapshot: DataSnapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            return childSnapshot.getValue(Usuario::class.java)
        }

        return null
    }

    suspend fun login(username: String, senha: String): Usuario? {
        val query: Query = databaseReference.orderByChild("username").equalTo(username)
        val snapshot: DataSnapshot = query.get().await()

        for (childSnapshot in snapshot.children) {
            val usuario = childSnapshot.getValue(Usuario::class.java)
            if (usuario?.senha == senha) {
                return usuario
            }
        }

        return null
    }
}
