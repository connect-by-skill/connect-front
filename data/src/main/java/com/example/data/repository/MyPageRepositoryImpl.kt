package com.example.data.repository

import android.util.Log
import com.example.data.library.model.ApiResponse
import com.example.data.mapper.ResumeMapper
import com.example.data.network.MyPageApi
import com.example.domain.EntityWrapper
import com.example.domain.model.ResumeModel
import com.example.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(
  private val myPageApi: MyPageApi,
  private val resumeMapper: ResumeMapper
) : MyPageRepository {
  override suspend fun getResume(): EntityWrapper<ResumeModel> {
    val result = myPageApi.getResume()
    if(result.response is ApiResponse.Success)
      Log.d("MyPageRepositoryImpl", "getResume : ${result.response.data}")
    else if(result.response is ApiResponse.Fail)
      Log.d("MyPageRepositoryImpl", "getResume : ${result.response.error.message}")
    return resumeMapper.mapFromResult(
      result = result
    )
  }

  override suspend fun saveResume(resumeModel: ResumeModel): EntityWrapper<ResumeModel> {
    val result = myPageApi.saveResume(resumeModel)
    if(result.response is ApiResponse.Success)
      Log.d("MyPageRepositoryImpl", "saveResume : ${result.response.data}")
    else if(result.response is ApiResponse.Fail)
      Log.d("MyPageRepositoryImpl", "saveResume : ${result.response.error.message}")
    return resumeMapper.mapFromResult(
      result = result
    )
  }

  override suspend fun deleteResume(): EntityWrapper<ResumeModel> {
    val result = myPageApi.deleteResume()
    if(result.response is ApiResponse.Success)
      Log.d("MyPageRepositoryImpl", "deleteResume : ${result.response.data}")
    else if(result.response is ApiResponse.Fail)
      Log.d("MyPageRepositoryImpl", "deleteResume : ${result.response.error.message}")
    return resumeMapper.mapFromResult(
      result = result
    )
  }
}