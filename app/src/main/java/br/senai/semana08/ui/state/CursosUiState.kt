package br.senai.semana08.ui.state

import br.senai.semana08.model.Curso
import br.senai.semana08.repository.CursosRepositoryFake

data class CursosUiState(
    val isLoading: Boolean = false,
    val cursos: List<Curso> = emptyList(),
)