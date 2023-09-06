package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.data.model.CompanyResponse


interface RecommendApi {
    suspend fun getWishListBasedRecommendList(id: String) : ApiResult<List<CompanyResponse>>
}