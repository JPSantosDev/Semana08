package br.senai.semana08.ui.state

import br.senai.semana08.model.Curso

data class CursosUiState(
    val isLoading: Boolean = false,
    val cursos: List<Curso> = emptyList(),
    val mensagemErro: String? = ""
)
