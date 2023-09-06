package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.domain.model.UserInfoModel

interface UserApi {
    suspend fun getUserInfo() : ApiResult<UserInfoModel>
}