package com.example.presentation.model

sealed class SignUpScreen(val name: String) {

    object EmailInfo: SignUpScreen("emailInfo")
    object PasswordInfo: SignUpScreen("passwordInfo")
    object UserBasicInfo: SignUpScreen("userBasicInfo")
    object DisabilityInfo: SignUpScreen("disabilityInfo")
}