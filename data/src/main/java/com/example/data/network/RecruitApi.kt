package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.data.model.CompanyResponse
import okhttp3.ResponseBody

interface RecruitApi {
  suspend fun addWishList(jobAnnouncementId: Int) : ApiResult<ResponseBody>
  suspend fun deleteWishList(jobAnnouncementId: Int) : ApiResult<ResponseBody>
  suspend fun getRecruitList(page: Int, sort: String): ApiResult<List<CompanyResponse>>
}