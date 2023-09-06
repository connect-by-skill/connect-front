package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.data.model.SignUpRequest


interface SignUpApi {
    suspend fun signUp(username: String, age: Int, email:String, encryptedPwd: String, addressInfo: String, addressDetails: String, disabilityType: String) : ApiResult<SignUpRequest>
}