package com.example.app.appLite.ui.pastas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.models.Pasta
import com.example.app.data.repository.PastaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PastasViewModel  @Inject constructor(val repository: PastaRepository) : ViewModel() {
    var pasta : Pasta = Pasta()
    var ultimaPasta : Pasta? = Pasta()

    private var _pastas = MutableStateFlow(listOf<Pasta>())
    val pastas : Flow<List<Pasta>> = _pastas

    init {
        viewModelScope.launch {
            repository.pastas.collect {pastas ->
                val userId = pasta.usuarioPastaId.toInt()
                val pastasFilter = pastas.filter { it.usuarioPastaId.toInt() == userId }
                _pastas.value = pastasFilter
            }
        }
    }

    fun novo(){
        this.pasta = Pasta()
    }

    fun editar(pasta : Pasta){
        this.pasta = pasta
    }

    fun salvar() = viewModelScope.launch{
        repository.salvar(pasta)
    }

    fun excluirPorId(pasta: Pasta) = viewModelScope.launch{
        repository.excluirPorId(pasta.pastaId.toInt())
    }

    fun excluirPorNome(pasta: Pasta) = viewModelScope.launch{
        repository.excluirPorNome(pasta.nome)
    }

    fun buscarultimo() = viewModelScope.launch {
        ultimaPasta = repository.buscarUltimo()
    }

}