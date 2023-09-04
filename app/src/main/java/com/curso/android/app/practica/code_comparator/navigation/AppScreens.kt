package com.curso.android.app.practica.code_comparator.navigation

sealed class AppScreens(val route: String) {
    object WelcomeScreen: AppScreens("welcome_screen")
    object IntroTextScreen: AppScreens("intro_text_screen")

}
