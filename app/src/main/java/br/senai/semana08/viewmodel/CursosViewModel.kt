package br.senai.semana08.viewmodel

import androidx.lifecycle.ViewModel
import br.senai.semana08.ui.state.CursosUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CursosViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CursosUiState())
    val uiState = _uiState.asStateFlow()

    init {


    }
}