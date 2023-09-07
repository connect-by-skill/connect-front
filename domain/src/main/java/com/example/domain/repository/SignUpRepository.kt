package com.example.domain.repository

import com.example.domain.EntityWrapper


interface SignUpRepository {
    suspend fun requestCertificationNumber(email: String)
    suspend fun requestCertification(number: String) : Boolean
    suspend fun signUp(email: String, pw: String, name: String, disabilityType: String, disabilityLevel: String, age: String, addressInfo: String, addressDetail: String) : EntityWrapper<Int>
}