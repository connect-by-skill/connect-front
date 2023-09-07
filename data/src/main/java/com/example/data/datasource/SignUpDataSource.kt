package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.model.RequestType
import com.example.data.library.retrofit.NetworkRequestFactory
import com.example.data.model.SignUpRequest
import com.example.data.network.SignUpApi
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class SignUpDataSource @Inject constructor(
  private val networkRequestFactory: NetworkRequestFactory
) : SignUpApi {
  override suspend fun signUp(
    username: String,
    age: Int,
    email: String,
    encryptedPwd: String,
    addressInfo: String,
    addressDetails: String,
    disabilityType: String
  ): ApiResult<SignUpRequest> {
    return networkRequestFactory.create(
      url = "members",
      type = object : TypeToken<SignUpRequest>() {}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withBody(
        requestBody =
        SignUpRequest(
          username = username,
          age = age,
          email = email,
          encryptedPwd = encryptedPwd,
          addressInfo = addressInfo,
          addressDetails = addressDetails,
          disabilityType = disabilityType
        )
      ).build()
    )
  }

  override suspend fun verifyEmail(email: String) {
    networkRequestFactory.create<String>(
      url = "mail/send?email=${email}",
      type = object : TypeToken<String>() {}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).build()
    )
  }

  override suspend fun checkCode(code: String): Boolean {
    return networkRequestFactory.create<String>(
      url = "mail/check?code=${code}",
      type = object : TypeToken<String>() {}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.GET).build()
    ).let {
      true
    }
  }
}