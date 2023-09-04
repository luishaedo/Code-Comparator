package com.curso.android.app.practica.code_comparator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.curso.android.app.practica.code_comparator.navigation.AppScreens


@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold (topBar = {
        TopAppBar() {
        Text(text = "Code Comparator")
    }
    }){
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Text(
            modifier = Modifier.padding(36.dp),
            text = "Bienvenido a Code Comparator")
        Button(onClick = {
            navController.navigate(route = AppScreens.IntroTextScreen.route) }) {
            Text(text = "Compará tu codigo!")
        }
    }
}

