package com.curso.android.app.practica.code_comparator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.curso.android.app.practica.code_comparator.screens.IntroTextScreen
import com.curso.android.app.practica.code_comparator.screens.WelcomeScreen
import com.curso.android.app.practica.code_comparator.viewModels.CodeComparisonViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.WelcomeScreen.route){
        composable(
            route = AppScreens.WelcomeScreen.route){
            WelcomeScreen(navController)
        }
        composable(
            route = AppScreens.IntroTextScreen.route,){
           // route = AppScreens.IntroTextScreen.route + "/{highlightedText}",){
            IntroTextScreen(navController, codeComparisonViewModel = CodeComparisonViewModel())
        }

    }
}