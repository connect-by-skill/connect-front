package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.model.RequestType
import com.example.data.library.retrofit.NetworkRequestFactory
import com.example.data.model.CompanyResponse
import com.google.gson.reflect.TypeToken
import com.example.data.network.WishApi
import com.example.domain.LoginTokenData
import okhttp3.ResponseBody
import javax.inject.Inject

class WishDataSource @Inject constructor(
  private val networkRequestFactory: NetworkRequestFactory
) : WishApi {


  override suspend fun addWishItem(
    jobAnnouncementId: Int
  ): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "announcement/wish?jobAnnoucemnetId=${jobAnnouncementId}",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun deleteWishItem(
    jobAnnouncementId: Int
  ): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "announcement/wish?jobAnnoucemnetId=${jobAnnouncementId}",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.DELETE).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun getWishList(): ApiResult<List<CompanyResponse>> {
    return networkRequestFactory.create(
      url = "announcement/wish",
      type = object: TypeToken<List<CompanyResponse>>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.GET).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }
}