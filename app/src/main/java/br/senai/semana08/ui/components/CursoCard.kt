package br.senai.semana08.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.semana08.model.Curso

@Composable
fun CursoCard(
    curso: Curso,
    onCardClick: () -> Unit
){
    Card(modifier = Modifier.fillMaxWidth(),
        onClick = onCardClick
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),) {
            Text("ID: ${curso.id}" )
            Text("Nome: ${curso.nome}")
            Text("Categoria: ${curso.categoria}")
            Text("Carga Horaria: ${curso.cargaHoraria}")
        }
    }
}


@Preview
@Composable
fun Preview(){
    CursoCard(
        curso = Curso(1,"jean","sigma",80,),
        onCardClick = {}
    )
}