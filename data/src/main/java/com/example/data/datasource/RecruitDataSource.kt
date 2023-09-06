package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.model.RequestType
import com.example.data.library.retrofit.NetworkRequestFactory
import com.example.data.model.CompanyResponse
import com.example.data.network.RecruitApi
import com.example.domain.LoginTokenData
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import javax.inject.Inject

class RecruitDataSource @Inject constructor(
  private val networkRequestFactory: NetworkRequestFactory
): RecruitApi {
  override suspend fun getRecruitList(page: Int, sort: String): ApiResult<List<CompanyResponse>> {
    return networkRequestFactory.create(
      url = "announcement?page=${page}&size=10&sort=id,$sort",
      type = object : TypeToken<List<CompanyResponse>>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.GET).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun addWishList(jobAnnouncementId: Int): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "announcement/wish?jobAnnoucemnetId=${jobAnnouncementId}",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun deleteWishList(jobAnnouncementId: Int): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "announcement/wish?jobAnnoucemnetId=${jobAnnouncementId}",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.DELETE).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }
}