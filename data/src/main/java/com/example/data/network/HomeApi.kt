package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.data.model.CompanyResponse

interface HomeApi {
    suspend fun getRankItemList(): ApiResult<List<CompanyResponse>>
}