package br.senai.semana08.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.senai.semana08.viewmodel.CursosViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CursosScreen(
    viewModel: CursosViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.isLoading){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else{
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiState.cursos){ curso->
                Text(text = curso.nome)
            }

        }
    }
}


@Preview (showBackground = true)
@Composable
fun Preview(){
    CursosScreen()
}