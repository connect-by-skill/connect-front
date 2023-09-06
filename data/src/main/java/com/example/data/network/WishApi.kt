package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.data.model.CompanyResponse
import okhttp3.ResponseBody

interface WishApi {
    suspend fun addWishItem(jobAnnouncementId: Int) : ApiResult<ResponseBody>
    suspend fun deleteWishItem(jobAnnouncementId: Int) : ApiResult<ResponseBody>
    suspend fun getWishList() : ApiResult<List<CompanyResponse>>
}