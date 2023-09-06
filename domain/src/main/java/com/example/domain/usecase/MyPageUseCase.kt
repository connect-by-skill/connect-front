package com.example.domain.usecase

import com.example.domain.EntityWrapper
import com.example.domain.model.ResumeModel

import com.example.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageUseCase @Inject constructor(private val myPageRepository: MyPageRepository) {
  suspend fun getResume(): EntityWrapper<ResumeModel> {
    return myPageRepository.getResume()
  }

  suspend fun saveResume(resumeModel: ResumeModel): EntityWrapper<ResumeModel> {
    return myPageRepository.saveResume(resumeModel)
  }

  suspend fun deleteResume(): EntityWrapper<ResumeModel> {
    return myPageRepository.deleteResume()
  }
}