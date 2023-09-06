package com.example.data.network

import com.example.data.library.model.ApiResult
import com.example.domain.model.ResumeModel

interface MyPageApi {
  suspend fun getResume(): ApiResult<ResumeModel>
  suspend fun saveResume(resumeModel: ResumeModel): ApiResult<ResumeModel>
  suspend fun deleteResume(): ApiResult<ResumeModel>
}