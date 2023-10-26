package com.example.app.appLite.ui.dados

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.models.Dado
import com.example.app.data.models.Pasta
import com.example.app.data.repository.DadoRepository
import com.example.app.login.CadastroViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DadosViewModel @Inject constructor(val repository: DadoRepository) : ViewModel() {

    var dado : Dado = Dado()
    var ultimoDado : Dado = Dado()

    private var _dados = MutableStateFlow(listOf<Dado>())
    val dados : Flow<List<Dado>> = _dados

    init {
        viewModelScope.launch {
            repository.dados.collect { dados ->
                val userId = dado.usuarioDadosId.toInt()
                val dadosFiltrados = dados.filter { it.usuarioDadosId.toInt() == userId }
                _dados.value = dadosFiltrados
            }
        }
    }

    fun novo(){
        this.dado = Dado()
    }

    fun editar(dado : Dado){
        this.dado = dado
    }

    fun salvar() = viewModelScope.launch{
        repository.salvar(dado)
    }

    fun excluirPorId(dado: Dado) = viewModelScope.launch{
        repository.excluirPorId(dado.dadoId)
    }

    fun excluirPorNome(dado: Dado) = viewModelScope.launch{
        repository.excluirPorNome(dado.nome)
    }

    fun buscarUltimo() = viewModelScope.launch {
        ultimoDado = repository.buscarUltimo()
    }

}