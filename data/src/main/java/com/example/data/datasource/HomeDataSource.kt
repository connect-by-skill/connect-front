package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.retrofit.NetworkRequestFactory
import com.example.data.model.CompanyResponse
import com.google.gson.reflect.TypeToken
import com.example.data.network.HomeApi
import com.example.domain.LoginTokenData
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : HomeApi {

    override suspend fun getRankItemList(): ApiResult<List<CompanyResponse>> {
        return networkRequestFactory.create(
            url = "announcement/sort/wish?page=0&size=10&sort=id,asc",
            type = object : TypeToken<List<CompanyResponse>>(){}.type,
            requestInfo = NetworkRequestInfo.Builder().withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
        )
    }
}