package br.senai.semana08.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun carregarCursos(){
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            val cursos = repository.buscarCursos()
            _uiState.update {
                it.copy(
                    cursos = cursos,
                    isLoading = false
                )
            }
        }
    }
    init {
        carregarCursos()
    }
}