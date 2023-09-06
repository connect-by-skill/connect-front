package com.example.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.model.Screen
import com.example.presentation.theme.colors
import com.example.presentation.util.SpeechTool

@Composable
fun RootScreen(context: Context){
    val navController = rememberNavController()
    SpeechTool.navController = navController
    NavHost(
        navController = navController,
        modifier = Modifier.background(MaterialTheme.colors.background),
        startDestination = Screen.Login.name) {
        composable(Screen.Login.name) {
           LoginScreen(contextActivity = context, navController = navController)
        }
//        composable(Screen.SignUp.name) {
//            SignUpScreen(navController = navController)
//        }
//        composable(Screen.Main.name) {
//            MainScreen(navController = navController)
//        }
    }
}