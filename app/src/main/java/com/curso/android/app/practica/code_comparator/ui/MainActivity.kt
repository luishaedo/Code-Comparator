package com.curso.android.app.practica.code_comparator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.curso.android.app.practica.code_comparator.navigation.AppNavigation
import com.curso.android.app.practica.code_comparator.theme.JetpackComposeCodeComparatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCodeComparatorTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCodeComparatorTheme {
        AppNavigation()
    }
}