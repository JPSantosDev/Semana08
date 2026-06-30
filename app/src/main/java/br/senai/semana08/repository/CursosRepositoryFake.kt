package br.senai.semana08.repository

import br.senai.semana08.model.Curso

class CursosRepositoryFake(
) {
    suspend fun buscarCursos(): List<Curso>{
        return listOf(
            Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação",
                cargaHoraria = 40
            ),
            Curso(
                id = 2,
                nome = "Java",
                categoria = "Programação",
                cargaHoraria = 60
            ),
            Curso(
                id = 3,
                nome = "Python",
                categoria = "Programação",
                cargaHoraria = 50
            ),
            Curso(
                id = 4,
                nome = "JavaScript",
                categoria = "Programação",
                cargaHoraria = 30
            ),
            Curso(
                id = 5,
                nome = "Kotlin",
                categoria = "Programação",
                cargaHoraria = 65
            )
        )
    }
}