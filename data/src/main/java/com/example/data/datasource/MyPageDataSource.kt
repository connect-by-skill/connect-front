package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.model.RequestType
import com.example.data.library.retrofit.NetworkRequestFactory
import com.example.data.network.MyPageApi
import com.example.domain.LoginTokenData
import com.example.domain.model.ResumeModel
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MyPageDataSource @Inject constructor(
  private val networkRequestFactory: NetworkRequestFactory
): MyPageApi {
  override suspend fun saveResume(resumeModel: ResumeModel): ApiResult<ResumeModel> {
    return networkRequestFactory.create(
      url = "resumes",
      type = object : TypeToken<ResumeModel>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).withBody(resumeModel).build()
    )
  }

  override suspend fun getResume(): ApiResult<ResumeModel> {
    return networkRequestFactory.create(
      url = "resumes",
      type = object : TypeToken<ResumeModel>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.GET).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun deleteResume(): ApiResult<ResumeModel> {
    return networkRequestFactory.create(
      url = "resumes",
      type = object : TypeToken<ResumeModel>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.DELETE).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }
}