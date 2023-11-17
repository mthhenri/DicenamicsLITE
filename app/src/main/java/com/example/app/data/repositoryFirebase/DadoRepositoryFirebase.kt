import com.example.app.data.models.Dado
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DadoRepositoryFirebase(private val dadosRef: CollectionReference) {

    private var _dados = MutableStateFlow(listOf<Dado>())
    val dados: StateFlow<List<Dado>> = _dados

    suspend fun salvar(dado: Dado) {
        if (dado.id.isNullOrEmpty()) {
            val doc = dadosRef.document()
            dado.id = doc.id
            doc.set(dado)
        } else {
            dadosRef.document(dado.id).set(dado)
        }
    }

    suspend fun excluirPorId(id: String) {
        dadosRef.document(id).delete()
    }

    suspend fun excluirPorNome(nome: String) {
        val result = dadosRef.whereEqualTo("nome", nome).get().await()

        for (document in result.documents) {
            document.reference.delete()
        }
    }

    suspend fun buscarPorUltimo(): Dado? {
        val result = dadosRef.orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .limit(1).get().await()

        return if (!result.isEmpty) {
            result.documents[0].toObject(Dado::class.java)
        } else {
            null
        }
    }
}
