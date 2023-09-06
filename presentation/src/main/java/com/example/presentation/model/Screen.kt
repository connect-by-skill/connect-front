package com.example.presentation.model

sealed class Screen(val name: String) {
    object Login: Screen("login")
    object SignUp: Screen("signUp")
    object Main: Screen("main")
}