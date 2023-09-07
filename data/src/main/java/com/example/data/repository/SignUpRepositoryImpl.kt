package com.example.data.repository

import com.example.data.mapper.SignUpMapper
import com.example.data.network.SignUpApi
import com.example.domain.EntityWrapper
import com.example.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val signUpApi: SignUpApi,
    private val signUpMapper: SignUpMapper,
) : SignUpRepository {
    override suspend fun requestCertificationNumber(email: String) {
        signUpApi.verifyEmail(email = email)
    }

    override suspend fun requestCertification(number: String): Boolean {
        return signUpApi.checkCode(number)
    }

    override suspend fun signUp(
        email: String,
        pw: String,
        name: String,
        disabilityType: String,
        disabilityLevel: String,
        age: String,
        addressInfo: String,
        addressDetail: String
    ): EntityWrapper<Int> {
        return signUpMapper.getCode(
            result = signUpApi.signUp(email = email, encryptedPwd = pw, username = name, disabilityType = "$disabilityType $disabilityLevel", age = age.toInt(), addressInfo = addressInfo, addressDetails = addressDetail)
        )
    }
}