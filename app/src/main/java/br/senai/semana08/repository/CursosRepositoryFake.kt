package br.senai.semana08.repository

import br.senai.semana08.model.Curso

class CursosRepositoryFake(
    private val cursos: MutableList<Curso> = mutableListOf(
        Curso(1, "Kotlin", "Programação", 40),
        Curso(2, "Java", "Programação", 60),
        Curso(3, "Python", "Programação", 50),
        Curso(4, "JavaScript", "Programação", 30),
        Curso(5, "Kotlin", "Programação", 65)
    )

) {
    fun buscarCursos(): List<Curso> {
        return cursos
    }
    fun removerCurso(id: Int): Boolean {
           return cursos.removeIf { it.id == id }
    }
    fun addCurso(curso: Curso): Boolean{
        if (cursos.any {it.id == curso.id }){ return false }

        cursos.add(curso)
        return true
    }
}