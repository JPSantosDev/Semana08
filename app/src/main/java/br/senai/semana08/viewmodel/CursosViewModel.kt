package br.senai.semana08.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.senai.semana08.model.Curso
import br.senai.semana08.repository.CursosRepositoryFake
import br.senai.semana08.ui.state.CursosUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CursosViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CursosUiState())
    val uiState = _uiState.asStateFlow()
    private val repository = CursosRepositoryFake()

    private suspend fun atualizarCursos(){
        val cursos = repository.buscarCursos()

        _uiState.update {
            it.copy(
                cursos = cursos
            )
        }
    }
    fun carregarCursos(){

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }

            atualizarCursos()

            _uiState.update {
                it.copy(
                    isLoading = false
                )
            }
        }
    }

    fun removerCurso(id: Int){
       val removido =  repository.removerCurso(id)

        if(removido)
            viewModelScope.launch {
                atualizarCursos()
            }
        else{
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        mensagemErro = "Esse ID não existe"
                    )
                }
            }
        }

        viewModelScope.launch {
            atualizarCursos()
        }
    }

    fun addCurso(curso: Curso){
        val adicionado = repository.addCurso(curso)

        if(adicionado)
        viewModelScope.launch {
            atualizarCursos()
        }
        else{
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        mensagemErro = "ID já existe"
                    )
                }
            }
        }
    }

    init {
        carregarCursos()
    }
}