package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.data.model.LoginResponse

interface LoginApi {
    suspend fun login(email: String, password: String) : ApiResult<LoginResponse>
}