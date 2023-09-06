package com.example.presentation.ui.components.signup

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.presentation.model.Screen
import com.example.presentation.model.SignUpScreen
import com.example.presentation.theme.Padding
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.viewmodel.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController){
    val signUpNavController = rememberNavController()
    val signUpViewModel = hiltViewModel<SignUpViewModel>()
    Scaffold(
        topBar = {
            Header(navController, signUpNavController)
        }
    ) {
        NavHost(
            navController = signUpNavController,
            startDestination = SignUpScreen.UserBasicInfo.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = SignUpScreen.UserBasicInfo.name){
                SignUpUserBasicInfoScreen(navController = signUpNavController, viewModel = signUpViewModel)

            }
            composable(route = SignUpScreen.EmailInfo.name){
                SignUpEmailScreen(navController = signUpNavController, viewModel = signUpViewModel)
            }
            composable(route = SignUpScreen.PasswordInfo.name){
                SignUpPasswordScreen(navController = signUpNavController, viewModel = signUpViewModel)
            }
            composable(route = SignUpScreen.DisabilityInfo.name){
                SignUpUserDisabilityInfoScreen(navController = navController, viewModel = signUpViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(navController : NavHostController, signUpNavController: NavHostController){
    val navBackStackEntry by signUpNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    TopAppBar(
        title = {},
        navigationIcon = {
            Spacer(modifier = Modifier.size(Padding.medium))
            IconButton(onClick = {
                when(currentRoute){
                    SignUpScreen.UserBasicInfo.name -> {
                        navController.navigate(Screen.Login.name) {
                            popUpTo(Screen.SignUp.name) { inclusive = true }
                        }
                    }
                    SignUpScreen.DisabilityInfo.name -> {
                        signUpNavController.navigate(SignUpScreen.PasswordInfo.name) {
                            popUpTo(SignUpScreen.DisabilityInfo.name) { inclusive = true }
                        }
                    }
                    SignUpScreen.EmailInfo.name -> {
                        signUpNavController.navigate(SignUpScreen.UserBasicInfo.name) {
                            popUpTo(SignUpScreen.EmailInfo.name) { inclusive = true }
                        }
                    }
                    SignUpScreen.PasswordInfo.name -> {
                        signUpNavController.navigate(SignUpScreen.EmailInfo.name) {
                            popUpTo(SignUpScreen.PasswordInfo.name) { inclusive = true }
                        }
                    }
                }
            }){
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back" )
            }
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(Screen.Login.name){
                    popUpTo(Screen.SignUp.name) {inclusive = true}
                }
            }){
                Icon(imageVector = Icons.Default.Close, contentDescription = "Close" )
            }
            Spacer(modifier = Modifier.size(Padding.small))
        }
    )
}

@Preview
@Composable
fun SignUpScreenPreview(){
    WhaleTheme {
        SignUpScreen(navController = rememberNavController())
    }
}