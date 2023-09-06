package com.example.data.repository

import com.example.data.mapper.SignUpMapper
import com.example.data.network.SignUpApi
import com.example.domain.EntityWrapper
import com.example.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val signUpApi: SignUpApi,
    private val signUpMapper: SignUpMapper
) : SignUpRepository {
    override fun requestCertificationNumber(email: String) {
        println("인증 번호 요청")
        //TODO("인증번호 요청하기")
    }

    override fun requestCertification(number: String): Boolean {
        return true
        //TODO("인증 요청")
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