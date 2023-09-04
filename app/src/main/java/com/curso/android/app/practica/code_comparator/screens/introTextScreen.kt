package com.curso.android.app.practica.code_comparator.screens


import android.text.SpannableStringBuilder
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.curso.android.app.practica.code_comparator.viewModels.CodeComparisonViewModel

@Composable
fun IntroTextScreen(navController: NavController, codeComparisonViewModel: CodeComparisonViewModel) {
    val code1State = remember { mutableStateOf(TextFieldValue()) }
    val code2State = remember { mutableStateOf(TextFieldValue()) }

    // Almacena los resultados de comparación en tiempo real
    val highlightedText1 = remember { mutableStateOf(SpannableStringBuilder()) }
    val highlightedText2 = remember { mutableStateOf(SpannableStringBuilder()) }

    Column {
        TextField(
            value = code1State.value,
            onValueChange = {
                code1State.value = it
                // comparación y actualiza los resultados
                val result = codeComparisonViewModel.compareAndHighlight(code1State.value.text, code2State.value.text)
                highlightedText1.value = result.first
                highlightedText2.value = result.second
            },
            placeholder = { Text("Ingresa tu código aquí") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = {
                // Realiza la comparación y actualiza los resultados
                val result = codeComparisonViewModel.compareAndHighlight(code1State.value.text, code2State.value.text)
                highlightedText1.value = result.first
                highlightedText2.value = result.second
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Comparar")
        }

        TextField(
            value = code2State.value,
            onValueChange = {
                code2State.value = it
                // Realiza la comparación y actualiza los resultados
                val result = codeComparisonViewModel.compareAndHighlight(code1State.value.text, code2State.value.text)
                highlightedText1.value = result.first
                highlightedText2.value = result.second
            },
            placeholder = { Text("Ingresa tu otro código aquí") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Resultado 1:")
                Text(text = highlightedText1.value.toString())
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Resultado 2:")
                Text(text = highlightedText2.value.toString())
            }
        }
    }
}