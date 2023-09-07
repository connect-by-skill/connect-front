package com.example.domain.usecase

import com.example.domain.EntityWrapper
import com.example.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val signUpRepository: SignUpRepository) {
    fun checkEmailFormat(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")

        return emailRegex.matches(email)
    }

    fun checkPasswordFormat(pw: String): Boolean {
        val pwRegex = Regex("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%&*])[a-zA-Z0-9!@#$%&*]{8,15}$")

        return pwRegex.matches(pw)
    }

    suspend fun requestCertificationNumber(email: String) {
        signUpRepository.requestCertificationNumber(email)
    }

    suspend fun requestCertification(number: String) : Boolean{
        return signUpRepository.requestCertification(number)
    }

    suspend fun signUp(email: String, pw: String, name: String, disabilityType: String, disabilityLevel: String, age: String, addressInfo: String, addressDetail: String) : EntityWrapper<Int> {
        return signUpRepository.signUp(email, pw, name, disabilityType, disabilityLevel, age, addressInfo, addressDetail)
    }
}