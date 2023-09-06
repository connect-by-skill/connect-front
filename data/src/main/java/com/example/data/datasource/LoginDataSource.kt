package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.model.RequestType
import com.example.data.library.retrofit.NetworkRequestFactory
import com.example.data.model.LoginRequest
import com.example.data.model.LoginResponse
import com.example.data.network.LoginApi
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class LoginDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : LoginApi {
    override suspend fun login(email: String, password: String): ApiResult<LoginResponse> {
        return networkRequestFactory.create(
            url = "login",
            type = object: TypeToken<LoginResponse>(){}.type,
            requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withBody(
                LoginRequest(email = email, password = password)
            ).build()
        )
    }

}