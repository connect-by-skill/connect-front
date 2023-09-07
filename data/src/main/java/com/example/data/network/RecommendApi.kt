package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.data.model.CompanyResponse
import com.example.data.model.RecommendResponse
import com.example.data.model.WishRecommendResponse
import com.example.domain.model.RecommendItemData


interface RecommendApi {
    suspend fun getWishListBasedRecommendList(id: String) : ApiResult<List<WishRecommendResponse>>
    suspend fun getRecommendList(id: String) : ApiResult<List<RecommendResponse>>
}