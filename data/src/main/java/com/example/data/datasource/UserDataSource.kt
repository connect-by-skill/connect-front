package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.retrofit.NetworkRequestFactory
import com.google.gson.reflect.TypeToken
import com.example.data.network.UserApi
import com.example.domain.LoginTokenData
import com.example.domain.model.UserInfoModel
import javax.inject.Inject

class UserDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : UserApi {
    override suspend fun getUserInfo(): ApiResult<UserInfoModel> {
        return networkRequestFactory.create(
            url = "members",
            type = object : TypeToken<UserInfoModel>(){}.type,
            requestInfo = NetworkRequestInfo.Builder().withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
        )
    }
}